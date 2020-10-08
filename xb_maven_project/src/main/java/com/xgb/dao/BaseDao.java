package com.xgb.dao;

import com.xgb.utils.DbUtil;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author iMarksce
 * @date 2020/9/22
 * @Description
 */
public class BaseDao {

    public static JdbcTemplate jdbcTemplate = new JdbcTemplate(DbUtil.getDataSource());
}
