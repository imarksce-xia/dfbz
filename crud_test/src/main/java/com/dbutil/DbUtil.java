package com.dbutil;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @auth admin
 * @date 2020/9/16
 * @Description
 */
public class DbUtil {
    private static DruidDataSource druidDataSource;

    static {
        Properties prop = new Properties();
        InputStream in = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            prop.load(in);
            druidDataSource = new DruidDataSource();
            druidDataSource.setUsername(prop.getProperty("username"));
            druidDataSource.setPassword(prop.getProperty("password"));
            druidDataSource.setUrl(prop.getProperty("url"));
            druidDataSource.setDriverClassName(prop.getProperty("driver"));
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

    /**
     * 获取数据源
     */
    public static DruidDataSource getDataSource() {
        return druidDataSource;
    }

    public static Connection getConn() {
        Connection conn = null;
        try {
            // 每一次从dataSource中获取一个新的连接
            conn = druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
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

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
