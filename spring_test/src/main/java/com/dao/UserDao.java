package com.dao;

import com.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author admin iMarksce
 * @date 2020/10/7
 * @Description
 */
@Repository
public class UserDao {

    public void add(User user){
        String sql="insert into user1 values(?,?,?) ";
//        jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getSex());
    }

    public void update(User user){
        String sql="insert into user1 values(?,?,?) ";
//        jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getSex());
    }
}
