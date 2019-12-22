package com.kpi.greenbank.model.dao;

import com.kpi.greenbank.model.entity.User;

public interface UserDao extends GeneralDao<User> {
    User findByEmail(String email);
}
