package com.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author admin iMarksce
 * @date 2020/10/7
 * @Description
 */
//@Component
public class DbUtil {
//    @Value("${db.driver}")
//    private String driver;
//
//    @Value("${db.url}")
//    private String url;
//
//    @Value("${db.username}")
//    private String username;
//
//    @Value("${db.password}")
//    private String password;
//
//    public DataSource getDataSource(){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUsername(username);
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(url);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//
//    public Connection getConnection(){
//        try {
//            return this.getDataSource().getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Bean("jdbcTemplate")
//    public JdbcTemplate getJdbcTemplate(){
//        return new JdbcTemplate(getDataSource());
//    }
}
