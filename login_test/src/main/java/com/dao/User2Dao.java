package com.dao;

import com.entity.User2;
import com.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class User2Dao {

    public void addUser2(User2 user2) {
        String sql = "insert into user2 values (?,?)";
        DbUtil.dml(sql, user2.getUsername(), user2.getPassword());
    }

    public static void delete2(User2 user2) {
        String sql = "delete from user2 where username=?";
        DbUtil.dml(sql, user2.getPassword());
    }

    public static void update2(User2 user2) {
        String sql = "update user2 set password=? where username=?";
        DbUtil.dml(sql, user2.getUsername(), user2.getPassword());
    }

    public User2 getUserById2(String username) {
        User2 user2 = new User2();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            String sql = "select * from user2 where name=?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                user2.setPassword(rs.getString("username"));
                user2.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return user2;
    }

    public Map<String, String> selectUser2() {
        Map<String, String> user2Map = new HashMap();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            String sql = "select*from user2";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User2 user2 = new User2();
                user2.setUsername(rs.getString("username"));
                user2.setPassword(rs.getString("password"));
                user2Map.put(user2.getUsername(), user2.getPassword());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return user2Map;
    }
}
