package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DbUtil {
    private static String DRIVER = null;
    private static String URL = null;
    private static String USERNAME = null;
    private static String PASSWORD = null;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\ideaproject\\login_test\\src\\main\\resources\\db.properties"));
            DRIVER = properties.getProperty("driver");
            URL = properties.getProperty("url");
            USERNAME = properties.getProperty("username");
            PASSWORD = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dml(String sql, Object... obj) {
        if (sql == null || obj == null || obj.length <= 0) {
            return;
        }
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps);
        }
    }

    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn, PreparedStatement ps) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
