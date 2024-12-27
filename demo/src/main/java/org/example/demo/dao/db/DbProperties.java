package org.example.demo.dao.db;

import java.util.Properties;

public class DbProperties  {
    private static Properties properties =  new Properties();
    static {
        try {
            properties.load(DbProperties.class.getResourceAsStream("/db.properties"));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public static String host() {
        return properties.get("db.host").toString();
    }
    public static int port() {
        try{
            return Integer.parseInt(properties.get("db.port").toString());
        } catch (NumberFormatException e) {
            return 3306;
        }
    }
    public static String username() {
        return properties.get("db.username").toString();
    }
    public static String password() {
        return properties.get("db.password").toString();
    }
    public static String dbName() {
        return properties.get("db.dbname").toString();
    }
    public static String option() {
        return properties.get("db.option").toString();
    }

    public static void main(String[] args) {
        DbProperties dbProperties = new DbProperties();
        System.out.println(dbProperties.host());
        System.out.println(dbProperties.port());
        System.out.println(dbProperties.username());
        System.out.println(dbProperties.password());
        System.out.println(dbProperties.dbName());
        System.out.println(dbProperties.option());
    }

}