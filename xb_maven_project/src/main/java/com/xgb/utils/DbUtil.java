package com.xgb.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author iMarksce
 * @date 2020/9/22
 * @Description jdbcTemplate连接工具类
 */
public class DbUtil {

    private static DruidDataSource druidDataSource;

    /**
     *功能描述
     * @author iMarksce
     * @date 2020/9/23
     */
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

    /**
     * 获取数据源
     */
    public static DruidDataSource getDataSource() {
        return druidDataSource;
    }

}
