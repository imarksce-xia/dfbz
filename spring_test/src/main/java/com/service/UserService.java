package com.service;

import com.dao.UserDao;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin iMarksce
 * @date 2020/10/7
 * @Description
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

//    private UserDao userDao;
//
//    public UserDao getUserDao() {
//        return userDao;
//    }

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void add(User user){
        System.out.println("add");
//        userDao.add(user);
    }

    public void update(User user){
        System.out.println("update");
    }
}
