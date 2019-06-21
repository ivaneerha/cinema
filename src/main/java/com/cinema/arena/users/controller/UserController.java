package com.cinema.arena.users.controller;

import com.cinema.common.exceptions.InvalidRegisterException;
import com.cinema.common.exceptions.KinoArenaException;
import com.cinema.common.helper.CryptPassword;
import com.cinema.arena.users.userDtos.UserLoginDto;
import com.cinema.arena.users.userDtos.UserRegisterDto;
import com.cinema.common.util.userUtil;
import com.cinema.common.validations.UserValidation;
import com.cinema.arena.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cinema.arena.users.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private static final String LOG_OUT_TO_REGISTER = "You have to logout to register!";
    private static final String EMAIL_TAKEN = "Email already taken!";
    private static final String USERNAME_TAKEN = "Username already taken!";
    private static final String WRONG_CREDENTIALS = "Wrong password or username!";
    private static final String ALREADY_LOGGED_IN = "You are already logged!";


    @PostMapping("user/register")
    public void signUp(@RequestBody UserRegisterDto userDto, HttpServletRequest request)
            throws KinoArenaException, NoSuchAlgorithmException {
        new UserValidation().validateRegistration(userDto);
        if (UserValidation.isLogged((request))) {
            throw new InvalidRegisterException(LOG_OUT_TO_REGISTER);
        }
        if (userService.isEmailTaken(userDto.getEmail())) {
            throw new InvalidRegisterException(EMAIL_TAKEN);
        }
        if (userService.isUsernameTaken(userDto.getUsername())) {
            throw new InvalidRegisterException(USERNAME_TAKEN);
        }

        User user = User.builder()
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .username(userDto.getUsername())
                .password(CryptPassword.cryptPassword(userDto.getPassword()))
                .build();

        userService.saveUser(user, request);
    }

    // TODO - have to fix it!!!
    
    @GetMapping("user/login")
    public String login(@RequestBody UserLoginDto log, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, KinoArenaException, NoSuchAlgorithmException {
        User user = userService.getUserByUsername(log.getUsername());
        if (!UserValidation.isLogged(request) || request.getSession().getAttribute("Username") != log.getUsername()) {
            new UserValidation().validateLogin(log);
            if (user.getPassword().equals(CryptPassword.cryptPassword(log.getPassword()))) {
                userUtil.logIn(user, request);
                return "You successfully logged in as " + user.getUsername();
            } else {
                throw new KinoArenaException(WRONG_CREDENTIALS);
            }
        } else {
            throw new KinoArenaException(ALREADY_LOGGED_IN);
        }
    }
}


