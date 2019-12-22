package com.kpi.greenbank.model.dao.implementation;

import com.kpi.greenbank.model.dao.UserDao;
import com.kpi.greenbank.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBSUserDao implements UserDao {

    private static final String DATABASE_NAME = "green_bank";
    private static final String TABLE_NAME = "user";

    private static final String queryAdd = String.format(
            "INSERT INTO %s.%s (EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, ADDRESS, CITY, BRANCH, ZIP, PHONE_NUMBER) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
            DATABASE_NAME,
            TABLE_NAME
    );
    private static final String queryFindByEmail = String.format(
            "SELECT EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, ADDRESS, CITY, BRANCH, ZIP, PHONE_NUMBER  FROM %s.%s  " +
                    "WHERE EMAIL = ?",
            DATABASE_NAME,
            TABLE_NAME
    );

    private Connection connection;

    public JDBSUserDao(Connection connection) {
        this.connection = connection;
    }

    private User extractFromResultSet(ResultSet rs)
            throws SQLException {
        return new User.Builder()
                .setEmail(rs.getString("EMAIL"))
                .setPassword(rs.getString("PASSWORD"))
                .setFirstName(rs.getString("FIRST_NAME"))
                .setLastName(rs.getString("LAST_NAME"))
                .setAddress(rs.getString("ADDRESS"))
                .setCity(rs.getString("CITY"))
                .setBranch(rs.getString("BRANCH"))
                .setZip(rs.getString("ZIP"))
                .setPhoneNumber(rs.getString("PHONE_NUMBER"))
                .build();
    }

    @Override
    public void add(User entity) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(queryAdd);

        preparedStatement.setString(1, entity.getEmail());
        preparedStatement.setString(2, entity.getPassword());
        preparedStatement.setString(3, entity.getFirstName());
        preparedStatement.setString(4, entity.getLastName());
        preparedStatement.setString(5, entity.getAddress());
        preparedStatement.setString(6, entity.getCity());
        preparedStatement.setString(7, entity.getBranch());
        preparedStatement.setString(8, entity.getZip());
        preparedStatement.setString(9, entity.getPhoneNumber());

        preparedStatement.executeUpdate();
    }

    @Override
    public User findById(String email) throws SQLException {
        return null;
    }

    @Override
    public User findByEmail(String email) {

        try (PreparedStatement ps = connection.prepareStatement(queryFindByEmail)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
