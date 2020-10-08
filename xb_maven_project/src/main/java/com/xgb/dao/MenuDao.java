package com.xgb.dao;

import com.xgb.entity.Menu;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * @author iMarksce
 * @date 2020/9/22
 * @Description
 */
public class MenuDao extends BaseDao {

    public List<Menu> listAll() {
        String sql = "select * from menu";
        List<Menu> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Menu.class));
        return list;
    }
}
