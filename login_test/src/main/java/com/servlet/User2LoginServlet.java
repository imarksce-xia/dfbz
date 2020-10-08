package com.servlet;

import com.dao.User2Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class User2LoginServlet extends HttpServlet {
    private User2Dao user2Dao = new User2Dao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        Map<String, String> user2Map = user2Dao.selectUser2();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (user2Map.containsKey(username) && user2Map.get(username).equals(password)) {
            resp.sendRedirect("successlogin.jsp");
        } else {
            resp.sendRedirect("faillogin.jsp");
        }
    }
}
