package com.dao;

import com.dbutil.DbUtil;
import com.entity.User3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public void addUser(User3 user3) {
        String sql = "insert into user3 values (null,?,?,?,?,?,?)";
        DbUtil.dml(sql, user3.getName(), user3.getAge(), user3.getSex(), user3.getSal(), user3.getBirth(), user3.getCreateTime());
    }

    public static void delete(Integer id) {
        String sql = "delete from user3 where id=?";
        DbUtil.dml(sql, id);
    }

    public static void update(User3 user3) {
        String sql = "update user3 set name=?,age=?,sex=?,sal=?,birth=?,create_time=? where id=?";
        DbUtil.dml(sql, user3.getName(), user3.getAge(), user3.getSex(), user3.getSal(), user3.getBirth(), user3.getCreateTime(), user3.getId());
    }

    public User3 getUserById(Integer id) {
        User3 user3 = new User3();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            String sql = "select * from user3 where id=?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                user3.setId(rs.getInt("id"));
                user3.setName(rs.getString("name"));
                user3.setAge(rs.getInt("age"));
                user3.setSex(rs.getString("sex"));
                user3.setSal(rs.getDouble("sal"));
                user3.setBirth(rs.getString("birth"));
                user3.setCreateTime(rs.getString("create_time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return user3;
    }

    public List<User3> selectUser(String name, Integer page) {
        List<User3> userList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            String sql = "select * from user3 where name like ? limit ?,3";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, "%" + name + "%");
            ps.setObject(2, (page - 1) * 3);
            rs = ps.executeQuery();
            while (rs.next()) {
                User3 user3 = new User3();
                user3.setId(rs.getInt("id"));
                user3.setName(rs.getString("name"));
                user3.setAge(rs.getInt("age"));
                user3.setSex(rs.getString("sex"));
                user3.setSal(rs.getDouble("sal"));
                user3.setBirth(rs.getString("birth"));
                user3.setCreateTime(rs.getString("create_time"));
                userList.add(user3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return userList;
    }

    public Integer count(String name) {
        Integer count=0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            String sql = "select count(*) rowCount from user3 where name like ? ";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()){
                count=rs.getInt("rowCount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return count;
    }
}
