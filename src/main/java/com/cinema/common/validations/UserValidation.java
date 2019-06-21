package com.cinema.common.validations;

import com.cinema.common.exceptions.InvalidInputDataException;
import com.cinema.common.exceptions.KinoArenaException;
import com.cinema.arena.users.userDtos.UserLoginDto;
import com.cinema.arena.users.userDtos.UserRegisterDto;
import com.cinema.arena.users.repository.UserRepository;
import com.cinema.arena.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserValidation {

    @Autowired
    UserRepository userRepository;

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9]+@[A-Za-z]+(\\.[A-Za-z]+)+$";
    private final static String PASSWORD_PATTERN = "^[a-zA-Z0-9]{8,30}$";
    private final static String NAME_PATTERN = "^[a-zA-Z]{2,30}$";
    private final static String USERNAME_PATTERN = "^[a-zA-Z]{5,30}$";


    private void validateEmail(String email) throws KinoArenaException {
        if (email==null || !email.matches(EMAIL_PATTERN)) {
            throw new InvalidInputDataException("The email does not meet the requirements!");
        }
    }

    private void validatePassword(String password) throws KinoArenaException {
        if (password==null || !password.matches(PASSWORD_PATTERN)) {
            throw new InvalidInputDataException("The password does not meet the requirements!");
        }
    }

    private void validateName(String name) throws KinoArenaException {
        if(name==null || !name.matches(NAME_PATTERN)){
            throw new InvalidInputDataException("The name is not valid!");
        }
    }

    private void validateUsername(String username) throws KinoArenaException {
        if(username==null || !username.matches(USERNAME_PATTERN)){
            throw new InvalidInputDataException("The username does not meet the requirements!");
        }
    }

    public void validateGsm(String gsm) throws KinoArenaException {
        if(gsm.trim().length()!=10 || !gsm.startsWith("08") ) {
            throw new InvalidInputDataException("The GSM does not meet the requirements!");
        }
    }

    public void validateString(String text) throws KinoArenaException {
        if(text.trim().length()>100) {
            throw new InvalidInputDataException();
        }
    }

    public void validateCityOrAddress(String address) throws KinoArenaException {
        if(address.length() > 50 || address == null) {
            throw new InvalidInputDataException("The address does not meet the requirements!");
        }
    }

    public void validateRegistration(UserRegisterDto reg) throws KinoArenaException {
        validateName(reg.getFirstName());
        validateName(reg.getLastName());
        validateEmail(reg.getEmail());
        validateUsername(reg.getUsername());
        validatePassword(reg.getPassword());
    }

    private static final String LOGGED = "LoggedUser";

    @Autowired
    private UserService userService;

    public static boolean isLogged(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.isNew())
            return false;
        if (session.getAttribute(LOGGED) == null) {
            return false;
        }
        return true;
    }


    public void validateLogin(UserLoginDto log) throws KinoArenaException {
        validateUsername(log.getUsername());
        validatePassword(log.getPassword());
    }
//
//    public void validateProfileUpdate(ProfileDto fav) throws KinoArenaException{
//        validateName(fav.getName());
//        validateName(fav.getLastName());
//        validateGsm(fav.getGsm());
//        validateCityOrAddress(fav.getCity());
//        validateCityOrAddress(fav.getAddress());
//
//    }
}
