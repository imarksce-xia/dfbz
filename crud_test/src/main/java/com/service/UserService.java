package com.service;

import com.dao.UserDao;
import com.entity.User3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public void add(User3 user3) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user3.setCreateTime(sdf.format(new Date()));
        userDao.addUser(user3);
    }

    public Integer count(String name) {
        return userDao.count(name);
    }

    public void deleteById(Integer id) {
        UserDao.delete(id);
    }

    public List<User3> user3List(String name, Integer page) {
        return userDao.selectUser(name, page);
    }

    public User3 getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public void update(User3 user3) {
        UserDao.update(user3);
    }
}
