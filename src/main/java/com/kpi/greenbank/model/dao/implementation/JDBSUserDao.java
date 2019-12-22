package com.kpi.greenbank.model.dao.implementation;

import com.kpi.greenbank.model.dao.interfase.UserDao;
import com.kpi.greenbank.model.dto.UserDTO;
import com.kpi.greenbank.model.entity.User;
import com.kpi.greenbank.model.entity.UserBranch;
import com.kpi.greenbank.model.entity.UserRole;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBSUserDao implements UserDao {

    private static final Logger logger = LogManager.getLogger(JDBSUserDao.class);

    private static final String DATABASE_NAME = "green_bank";
    private static final String TABLE_NAME = "user";

    private static final String QUERY_ADD = String.format(
            "INSERT INTO %s.%s (EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, ROLE, ADDRESS, CITY, BRANCH, ZIP, PHONE_NUMBER, AMOUNT) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
            DATABASE_NAME,
            TABLE_NAME
    );
    private static final String QUERY_FIND_BY_EMAIL = String.format(
            "SELECT EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, ROLE, ADDRESS, CITY, BRANCH, ZIP, PHONE_NUMBER, AMOUNT  FROM %s.%s  " +
                    "WHERE EMAIL = ?",
            DATABASE_NAME,
            TABLE_NAME
    );

    private Connection connection;

    JDBSUserDao(Connection connection) {
        this.connection = connection;
    }

    private UserDTO extractFromResultSet(ResultSet rs)
            throws SQLException {
        return new UserDTO.Builder()
                .setEmail(rs.getString("EMAIL"))
                .setPassword(rs.getString("PASSWORD"))
                .setFirstName(rs.getString("FIRST_NAME"))
                .setLastName(rs.getString("LAST_NAME"))
                .setRole(UserRole.valueOf(rs.getString("ROLE").toUpperCase().replace(" ", "_")))
                .setAddress(rs.getString("ADDRESS"))
                .setCity(rs.getString("CITY"))
                .setBranch(UserBranch.valueOf(rs.getString("BRANCH").toUpperCase().replace(" ", "_")))
                .setZip(rs.getString("ZIP"))
                .setPhoneNumber(rs.getString("PHONE_NUMBER"))
                .setAmount(rs.getFloat("AMOUNT"))
                .build();
    }

    @Override
    public void add(User entity) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ADD);

        preparedStatement.setString(1, entity.getEmail());
        preparedStatement.setString(2, entity.getPassword());
        preparedStatement.setString(3, entity.getFirstName());
        preparedStatement.setString(4, entity.getLastName());
        preparedStatement.setString(5, entity.getRole().getTitle());
        preparedStatement.setString(6, entity.getAddress());
        preparedStatement.setString(7, entity.getCity());
        preparedStatement.setString(8, entity.getBranch().getTitle());
        preparedStatement.setString(9, entity.getZip());
        preparedStatement.setString(10, entity.getPhoneNumber());
        preparedStatement.setFloat(11, entity.getAmount());


        preparedStatement.executeUpdate();
    }

    @Override
    public User findById(String email) throws SQLException {
        return null;
    }

    @Override
    public UserDTO findByEmail(String email) {

        try (PreparedStatement ps = connection.prepareStatement(QUERY_FIND_BY_EMAIL)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            logger.error(e.getStackTrace());
        }
        return null;
    }


    @Override
    public void update(User entity) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void close() throws SQLException {

    }
}
