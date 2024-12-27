package org.example.demo.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
    private static String url = "jdbc:mysql://" + DbProperties.host() + ":" + DbProperties.port() + "/" + DbProperties.dbName() + "?" + DbProperties.option();
    private static Connection conn;

    // Phương thức lấy Statement
    public static Statement get() {
        try {
            if (conn == null || conn.isClosed()) {
                makeConnection();
            }
            return conn.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error creating Statement", e);
        }
    }

    // Phương thức trả về Connection
    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                makeConnection();
            }
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error getting database connection", e);
        }
    }

    // Tạo kết nối
    private static void makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, DbProperties.username(), DbProperties.password());
    }

    // Đóng kết nối
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    // Kiểm tra kết nối
    public static void main(String[] args) {
        if (DbConnect.get() != null) {
            System.out.println("Connected");
        } else {
            System.out.println("Not Connected");
        }
    }
}
