package com.kpi.greenbank.model.service;

import com.kpi.greenbank.model.dao.DaoFactory;
import com.kpi.greenbank.model.dao.UserDao;
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

    public Boolean addUser(User user) {

        boolean status = false;
        try {
            userDao.add(user);
            status = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public Optional<User> findUser(String email, String password){
        Optional<User> user = Optional.ofNullable((userDao.findByEmail(email)));
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }
}
