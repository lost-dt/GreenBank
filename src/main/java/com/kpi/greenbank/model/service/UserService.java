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

    public void updateUser(UserDTO userDTO) {

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAddress(userDTO.getAddress());
        user.setCity(userDTO.getCity());
        user.setBranch(userDTO.getBranch());
        user.setZip(userDTO.getZip());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setRole(userDTO.getRole());
        user.setAmount(userDTO.getAmount());

        try {
            userDao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
