package com.xgb.dao;

import com.xgb.entity.Dept;
import com.xgb.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * @author iMarksce
 * @date 2020/9/23
 * @Description
 */
public class UserDao extends BaseDao {

    public List<User> listAll(String username, Integer page) {
        String sql = "SELECT " +
                "u.id, " +
                "u.username, " +
                "u.email, " +
                "u.real_name, " +
                "u.age, " +
                "u.sex, " +
                "u.register_time, " +
                "u.login_time, " +
                "u.dept_id, " +
                "d.NAME AS deptName  " +
                "FROM " +
                "user u " +
                "LEFT JOIN dept d ON u.dept_id = d.id  " +
                "WHERE " +
                "u.username LIKE ? " +
                "LIMIT ?,3";
        try {
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), "%" + username + "%", (page - 1) * 3);
        } catch (Exception e) {
            return null;
        }
    }

    public Integer getCount(String username) {
        String sql = "SELECT " +
                "count(*) rowCount  " +
                "FROM " +
                "user  " +
                "WHERE " +
                "username LIKE ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, "%" + username + "%");
    }

    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getQqOpenid(),
                user.getWxOpenid(), user.getRealName(), user.getAge(), user.getPhone(), user.getSex(), user.getDesc(),
                user.getRegisterTime(), user.getLoginTime(), user.getPic(), user.getLook(), user.getIsSecret(), user.getDeptId());
    }

    public void delete(Integer id) {
        String sql = "DELETE  " +
                "FROM " +
                "user  " +
                "WHERE " +
                "id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void update(User user) {
        String sql = "update user set username=?,`password`=?,email=?,qq_openid=?,wx_openid=?,real_name=?, " +
                "age=?,phone=?,sex=?,`desc`=?,register_time=?,login_time=?,pic=?,look=?,is_secret=?,dept_id=? where id = ?";
        int update = jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getQqOpenid(),
                user.getWxOpenid(), user.getRealName(), user.getAge(), user.getPhone(), user.getSex(), user.getDesc(),
                user.getRegisterTime(), user.getLoginTime(), user.getPic(), user.getLook(), user.getIsSecret(), user.getDeptId(), user.getId());
    }

    public User getUserById(Integer id) {
        String sql = "select * from user where id = ? ";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    public List<Dept> deptAll() {
        String sql = "SELECT " +
                "id, " +
                "name  " +
                "FROM " +
                "dept";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dept.class));
    }

    public void updatePic(Integer id, String pic) {
        String sql = "update user set pic = ? where id = ?";
        jdbcTemplate.update(sql, pic, id);
    }

    public List<User> getUserByDeptId(Integer deptId) {
        String sql = "select * from user where dept_id = ? ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), deptId);
    }
}
