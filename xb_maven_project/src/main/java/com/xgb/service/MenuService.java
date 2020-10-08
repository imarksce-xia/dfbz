package com.xgb.service;

import com.xgb.dao.MenuDao;
import com.xgb.entity.Menu;

import java.util.List;

/**
 * @author iMarksce
 * @date 2020/9/22
 * @Description
 */
public class MenuService {
    private MenuDao menuDao = new MenuDao();

    /**
     * 功能描述
     *
     * @return java.util.List<com.xgb.entity.Menu>
     * @author iMarksce
     * @date 2020/9/23
     */
    public List<Menu> listAll() {
        return menuDao.listAll();
    }
}
