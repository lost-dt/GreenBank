package com.kpi.greenbank.model.service;

import com.kpi.greenbank.model.dao.DaoFactory;
import com.kpi.greenbank.model.dao.interfase.UserDao;
import com.kpi.greenbank.model.dto.UserDTO;
import com.kpi.greenbank.model.entity.User;

import java.sql.SQLException;
import java.util.Optional;

public class UserService {
    private DaoFactory daoFactory ;
    private UserDao userDao ;

    public UserService() {
        this.daoFactory = DaoFactory.getInstance();
        this.userDao = daoFactory.createUserDao();
    }

    public Boolean addUser(User userDTO) {

        boolean status = false;
        try {
            userDao.add(userDTO);
            status = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public Optional<UserDTO> checkUserCredentials(String email, String password){
        Optional<UserDTO> user = Optional.ofNullable((userDao.findByEmail(email)));
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }

    public Optional<UserDTO> findUserByEmail(String email) {
        return Optional.ofNullable((userDao.findByEmail(email)));

    }
}
