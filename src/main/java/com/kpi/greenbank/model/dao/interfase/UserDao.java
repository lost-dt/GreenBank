package com.kpi.greenbank.model.dao.interfase;

import com.kpi.greenbank.model.dto.UserDTO;
import com.kpi.greenbank.model.entity.User;

import java.sql.SQLException;

public interface UserDao extends GeneralDao<User> {
    UserDTO findByEmail(String email);
    void deleteByEmail(String email) throws SQLException;
}
