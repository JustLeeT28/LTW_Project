package org.example.demo.dao.db;

import java.util.Properties;

public class DbProperties {
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(DbProperties.class.getResourceAsStream("/db.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Error loading db.properties file", e);
        }
    }

    public static String host() {
        return properties.getProperty("db.host", "localhost");
    }

    public static int port() {
        try {
            return Integer.parseInt(properties.getProperty("db.port", "3306"));
        } catch (NumberFormatException e) {
            return 3306; // Giá trị mặc định nếu xảy ra lỗi
        }
    }

    public static String username() {
        return properties.getProperty("db.username", "root");
    }

    public static String password() {
        return properties.getProperty("db.password", "");
    }

    public static String dbName() {
        return properties.getProperty("db.dbname", "test");
    }

    public static String option() {
        return properties.getProperty("db.option", "useSSL=false&serverTimezone=UTC");
    }

    public static void main(String[] args) {
        System.out.println("Host: " + host());
        System.out.println("Port: " + port());
        System.out.println("Username: " + username());
        System.out.println("Password: " + password());
        System.out.println("Database Name: " + dbName());
        System.out.println("Options: " + option());
    }
}
