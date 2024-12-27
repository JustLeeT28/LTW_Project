package org.example.demo.dao.db;

import java.sql.*;

public class DbConnect {
    static String url = "jdbc:mysql://" + DbProperties.host() + ":" + DbProperties.port() + "/" + DbProperties.dbName() + "?" + DbProperties.option();
    static Connection conn;

    public static Statement get() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(url, DbProperties.username(), DbProperties.password());
//            return conn.createStatement();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        try {
            if (conn == null || conn.isClosed()) {
                makeConnection();
            }
            return conn.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        }
    }

    private static void makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, DbProperties.username(), DbProperties.password());
    }

    public static void main(String[] args) {
        if (DbConnect.get() != null) {
            System.out.println("Connected");
        } else {
            System.out.println("Not Connected");
        }
    }
}
