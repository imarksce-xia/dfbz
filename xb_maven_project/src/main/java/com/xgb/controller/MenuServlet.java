package com.xgb.controller;

import com.alibaba.fastjson.JSONObject;
import com.xgb.entity.Menu;
import com.xgb.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * @author iMarksce
 * @date 2020/9/22
 * @Description
 */
@WebServlet("/menu/*")
public class MenuServlet extends BaseServlet {
    private MenuService menuService = new MenuService();

    /**
     *功能描述
     * @author iMarksce
     * @date 2020/9/23
     * @param req, resp
     * @return void
     */
    protected void listAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Menu> list = menuService.listAll();
        List<Menu> parentList = list.stream().filter(n-> n.getType().equals("1")).collect(toList());
        List<Menu> sonList = list.stream().filter(n-> n.getType().equals("2")).collect(toList());
        Map<String,List<Menu>> map=new HashMap<>();
        map.put("parent",parentList);
        map.put("son",sonList);
        resp.getWriter().write(JSONObject.toJSONString(map));
    }
}