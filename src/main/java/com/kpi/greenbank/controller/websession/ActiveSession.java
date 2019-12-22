package com.kpi.greenbank.controller.websession;

import com.kpi.greenbank.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

public class ActiveSession {

    public static Boolean checkUserIsLogged(HttpServletRequest request, User user) {
        @SuppressWarnings("unchecked")
        HashSet<User> loggedUsers = (HashSet<User>) request.getSession()
                .getServletContext().getAttribute("loggedUsers");
        if (loggedUsers.isEmpty()) return false;
        if (loggedUsers.stream().map(User::getEmail).anyMatch(user.getEmail()::equalsIgnoreCase)) return true;
        loggedUsers.add(user);
        request.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);
        return false;
    }

    public static void deleteUserFromActiveSession(HttpServletRequest request) {
        User user = (User) request.getSession().getServletContext().getAttribute("userEntity");
        @SuppressWarnings("unchecked")
        HashSet<User> loggedUsers = (HashSet<User>) request.getSession()
                .getServletContext().getAttribute("loggedUsers");
        loggedUsers.remove(user);
        request.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);
    }
}
