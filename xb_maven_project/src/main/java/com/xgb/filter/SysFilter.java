package com.xgb.filter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.xgb.constants.Constant;
import com.xgb.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author iMarksce
 * @date 2020/9/22
 * @Description
 */
@WebFilter("/*")
public class SysFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 功能描述
     *
     * @param servletRequest, servletResponse, filterChain
     * @return void
     * @author iMarksce
     * @date 2020/9/23
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession();

        if (requestURI.endsWith("index.jsp") || requestURI.endsWith("/")) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String key = cookie.getName();
                    if (Constant.COOKIE_LOGIN.equals(key)) {
                        String value = URLDecoder.decode(cookie.getValue(), "utf-8");
                        User loginUser = JSONObject.parseObject(value, new TypeReference<User>() {
                        });
                        session.setAttribute(Constant.SESSION_LOGIN, loginUser);
                        session.setMaxInactiveInterval(30 * 60);
                        request.setAttribute("loginUser", loginUser);
                        request.getRequestDispatcher("/html/common/home.jsp").forward(request, response);
                        filterChain.doFilter(request, response);
                        return;
                    }
                }
            }
        } else if (!(requestURI.endsWith("/login") || requestURI.endsWith("/menu/listAll") ||
                requestURI.endsWith("/img/getPicCode") || requestURI.endsWith("forget.jsp") ||
                requestURI.endsWith("sendEmail") || requestURI.contains("static") ||
                requestURI.endsWith("forget") || requestURI.contains("weChat"))) {
            Object obj = session.getAttribute(Constant.SESSION_LOGIN);
            if (obj == null) {
                response.sendRedirect("/index.jsp");
                return;
            }
        }
        request.setAttribute("loginUser", (User) session.getAttribute(Constant.SESSION_LOGIN));
        filterChain.doFilter(request, response);
    }
}
