package org.example.demo.dao.db;

import java.sql.*;

public class DbConnect {
    static String url = "jdbc:mysql://" + DbProperties.host() + ":" + DbProperties.port() + "/" + DbProperties.dbName() + "?" + DbProperties.option();
    static Connection conn;

    // Sử dụng PreparedStatement thay cho Statement
    public static PreparedStatement get(String query) {
        try {
            if (conn == null || conn.isClosed()) {
                makeConnection();
            }
            return conn.prepareStatement(query);  // Lấy PreparedStatement để thực thi câu lệnh SQL
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();  // Log lỗi nếu gặp vấn đề
            return null;  // Trả về null khi gặp lỗi
        }
    }

    private static void makeConnection() throws ClassNotFoundException, SQLException {
        // Load Driver MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Kết nối cơ sở dữ liệu
        conn = DriverManager.getConnection(url, DbProperties.username(), DbProperties.password());
    }

    public static void main(String[] args) throws SQLException {
        String query = "SELECT * FROM movies";
        PreparedStatement ps = DbConnect.get(query);
        if (ps != null) {
            System.out.println("PreparedStatement created successfully!");
        } else {
            System.out.println("Failed to create PreparedStatement.");
        }
        if(conn != null) {
            System.out.println("Connection established successfully!");
        } else {
            System.out.println("Failed to establish connection.");
        }
    }
}
