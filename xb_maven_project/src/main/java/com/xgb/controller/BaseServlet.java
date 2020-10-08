package com.xgb.controller;

import com.xgb.constants.Constant;
import com.xgb.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author iMarksce
 * @date 2020/9/22
 * @Description
 */
public class BaseServlet extends HttpServlet {

    public User loginUser = new User();

    /**
     * 功能描述
     *
     * @param req, resp
     * @return void
     * @author iMarksce
     * @date 2020/9/22
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        loginUser = (User) session.getAttribute(Constant.SESSION_LOGIN);
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String method = split[split.length - 1];
        Class c = this.getClass();
        try {
            Method declaredMethod = c.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
