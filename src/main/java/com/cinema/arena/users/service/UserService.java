package com.cinema.arena.users.service;

import com.cinema.common.exceptions.KinoArenaException;
import com.cinema.arena.users.model.User;
import com.cinema.arena.users.repository.UserRepository;
import com.cinema.common.util.userUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isEmailTaken(String email) {
        return userRepository.findByEmail(email) != null;
    }

    public boolean isUsernameTaken(String username){
        return userRepository.findByUsername(username) !=null;
    }

    public void saveUser(User user, HttpServletRequest request) {
        userRepository.save(user);
        userUtil.logIn(user, request);
    }

    public User getUserByUsername(String username) throws KinoArenaException {
        User user = userRepository.findByUsername(username);

        if(user == null) {
            throw new KinoArenaException("No such user found!");
        }

        return user;
    }



}
