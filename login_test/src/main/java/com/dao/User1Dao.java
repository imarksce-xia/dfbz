package com.dao;

import com.entity.User1;
import com.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class User1Dao {

    public void addUser1(User1 user1) {
        String sql = "insert into user1 values (?,?,?)";
        DbUtil.dml(sql, user1.getName(), user1.getAge(), user1.getSex());
    }

    public static void delete1(User1 user1) {
        String sql = "delete from user1 where name=?";
        DbUtil.dml(sql, user1.getName());
    }

    public static void update1(User1 user1) {
        String sql = "update user1 set age=?,sex=? where name=?";
        DbUtil.dml(sql, user1.getAge(), user1.getSex(), user1.getName());
    }

    public User1 getUserById1(String name) {
        User1 user1 = new User1();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            String sql = "select * from user1 where name=?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                user1.setName(rs.getString("name"));
                user1.setAge(rs.getInt("age"));
                user1.setSex(rs.getString("sex"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return user1;
    }

    public List<User1> selectUser1() {
        List<User1> user1List = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            String sql = "select*from user1";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User1 user1 = new User1();
                user1.setName(rs.getString("name"));
                user1.setAge(rs.getInt("age"));
                user1.setSex(rs.getString("sex"));
                user1List.add(user1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return user1List;
    }
}
