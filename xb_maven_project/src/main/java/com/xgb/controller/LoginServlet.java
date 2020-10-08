package com.xgb.controller;

import com.alibaba.fastjson.JSONObject;
import com.xgb.constants.Constant;
import com.xgb.entity.User;
import com.xgb.enums.SessionEnum;
import com.xgb.service.LoginService;
import com.xgb.utils.MdUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author iMarksce
 * @date 2020/9/22
 * @Description
 */
@WebServlet("/login/*")
public class LoginServlet extends BaseServlet {

    private LoginService loginService = new LoginService();

    /**
     * 功能描述
     *
     * @param req, resp
     * @return void
     * @author iMarksce
     * @date 2020/9/22
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String automatic = req.getParameter("automatic");
        String code = req.getParameter("code");
        User loginUser = loginService.checkLogin(username, MdUtil.md5(password));
        HttpSession session = req.getSession();
        Object obj = session.getAttribute(SessionEnum.SESSION_PIC_CODE.getValue());
        if (!code.equalsIgnoreCase(obj.toString())) {
            resp.sendRedirect("/index.jsp");
            return;
        }

        if (loginUser != null) {
            session.setAttribute(Constant.SESSION_LOGIN, loginUser);
            session.setMaxInactiveInterval(30 * 60);
            if ("1".equals(automatic)) {
                String jsonUser = JSONObject.toJSONString(loginUser);
                Cookie cookie = new Cookie(Constant.COOKIE_LOGIN, URLEncoder.encode(jsonUser, "utf-8"));
                cookie.setMaxAge(7 * 24 * 60 * 60);
                cookie.setPath("/");
                resp.addCookie(cookie);
            }
            req.setAttribute("loginUser", loginUser);
            req.getRequestDispatcher("/html/common/home.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/index.jsp");
        }
    }

    /**
     *功能描述
     * @author iMarksce
     * @date 2020/9/27
     * @param req, resp
     * @return void
     */
    protected void forget(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        Object obj = req.getSession().getAttribute(SessionEnum.SESSION_FORGET.getValue());
        if (obj == null || !obj.toString().equals(code)) {
            req.getRequestDispatcher("/forget.jsp").forward(req, resp);
        }
        User user=new User();
        user.setUsername(username);
        user.setPassword(MdUtil.md5(password));
        loginService.updatePassword(user);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}