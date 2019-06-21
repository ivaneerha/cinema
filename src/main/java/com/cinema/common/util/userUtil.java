package com.cinema.common.util;

import com.cinema.arena.users.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class userUtil {

    public static final String LOGGED = "LoggedUser";
    private static final int SESSION_TIMEOUT = 86400;
    public static final String USERNAME = "Username";

    public static void logIn(User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(SESSION_TIMEOUT);
        session.setAttribute(LOGGED, user);
        session.setAttribute(USERNAME, user.getUsername());
    }
}
