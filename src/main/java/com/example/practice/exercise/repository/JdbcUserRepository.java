package com.example.practice.exercise.repository;

import com.example.practice.exercise.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUserRepository {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/userservice";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "@Chuxuanloc26032003";

    // Kết nối cơ sở dữ liệu
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    }

    // Lưu thông tin User vào cơ sở dữ liệu
    public void saveUser(User user) {
        String insertSql = "INSERT INTO user (userid, id, title) VALUES (?, ?, ?)";

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(insertSql)) {

            statement.setInt(1, user.getUserId());
            statement.setInt(2, user.getId());
            statement.setString(3, user.getTitle());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User has been inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
