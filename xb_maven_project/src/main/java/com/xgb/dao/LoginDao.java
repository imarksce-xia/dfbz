package com.xgb.dao;

import com.xgb.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 * @author iMarksce
 * @date 2020/9/27
 * @Description
 */
public class LoginDao extends BaseDao {

    public User checkLogin(String username, String password) {
        String sql = "SELECT " +
                "*  " +
                "FROM " +
                "user  " +
                "WHERE " +
                "username = ?  " +
                "AND PASSWORD = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updatePassword(User user) {
        String sql = "update user set password = ? where username = ?";
        jdbcTemplate.update(sql, user.getPassword(), user.getUsername());
    }

    public User findByWxOpenid(String wxOpenid) {
        String sql = "select * from user where wx_Openid = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), wxOpenid);
        } catch (DataAccessException e) {
            return null;
        }
    }
}
