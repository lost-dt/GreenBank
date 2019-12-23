package com.kpi.greenbank.controller.websession;

import com.kpi.greenbank.model.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

public class ActiveSession {

    public static Boolean checkUserIsLogged(HttpServletRequest request, UserDTO user) {
        @SuppressWarnings("unchecked")
        HashSet<UserDTO> loggedUsers = (HashSet<UserDTO>) request.getSession()
                .getServletContext().getAttribute("loggedUsers");
        if (loggedUsers.stream().map(UserDTO::getEmail).anyMatch(user.getEmail()::equalsIgnoreCase)) return true;
        loggedUsers.add(user);
        request.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);
        return false;
    }

    public static void deleteUserFromActiveSession(HttpServletRequest request) {
        UserDTO user = (UserDTO) request.getSession().getAttribute("currentUserEntity");
        @SuppressWarnings("unchecked")
        HashSet<UserDTO> loggedUsers = (HashSet<UserDTO>) request.getSession()
                .getServletContext().getAttribute("loggedUsers");
        loggedUsers.remove(user);
        request.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);
    }
}
