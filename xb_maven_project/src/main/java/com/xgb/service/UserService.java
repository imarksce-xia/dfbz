package com.xgb.service;

import com.xgb.dao.UserDao;
import com.xgb.entity.Dept;
import com.xgb.entity.User;

import java.util.List;

/**
 * @author iMarksce
 * @date 2020/9/23
 * @Description
 */
public class UserService {
    private UserDao userDao = new UserDao();

    /**
     * 功能描述
     *
     * @param username, page
     * @return java.util.List<com.xgb.entity.User>
     * @author iMarksce
     * @date 2020/9/23
     */
    public List<User> listAll(String username, Integer page) {
        return userDao.listAll(username, page);
    }

    /**
     * 功能描述
     *
     * @param username
     * @return java.lang.Integer
     * @author iMarksce
     * @date 2020/9/23
     */
    public Integer getCount(String username) {
        return userDao.getCount(username);
    }

    /**
     * 功能描述
     *
     * @param user
     * @return void
     * @author iMarksce
     * @date 2020/9/23
     */
    public void add(User user) {
        userDao.add(user);
    }

    /**
     * 功能描述
     *
     * @param id
     * @return void
     * @author iMarksce
     * @date 2020/9/23
     */
    public void delete(Integer id) {
        userDao.delete(id);
    }

    /**
     * 功能描述
     *
     * @param user
     * @return void
     * @author iMarksce
     * @date 2020/9/23
     */
    public void update(User user) {
        userDao.update(user);
    }

    /**
     * 功能描述
     *
     * @param id
     * @return com.xgb.entity.User
     * @author iMarksce
     * @date 2020/9/23
     */
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    /**
     * 功能描述
     *
     * @return java.util.List<com.xgb.entity.Dept>
     * @author iMarksce
     * @date 2020/9/24
     */
    public List<Dept> deptAll() {
        return userDao.deptAll();
    }

    /**
     * 功能描述
     *
     * @param id, pic
     * @return void
     * @author iMarksce
     * @date 2020/9/24
     */
    public void updatePic(Integer id, String pic) {
        userDao.updatePic(id, pic);
    }

    /**
     * 功能描述
     *
     * @param deptId
     * @return java.util.List<com.xgb.entity.User>
     * @author iMarksce
     * @date 2020/9/26
     */
    public List<User> getUserByDeptId(Integer deptId) {
        return userDao.getUserByDeptId(deptId);
    }

}
