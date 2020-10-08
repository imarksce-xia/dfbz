package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author admin iMarksce
 * @date 2020/10/7
 * @Description
 */
//@Repository
public class BaseDao {

//    @Autowired
    JdbcTemplate jdbcTemplate;

//    JdbcTemplate jdbcTemplate;
//
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
