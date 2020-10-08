package com.servlet;

import com.dao.User2Dao;
import com.entity.User2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
    private User2Dao user2Dao = new User2Dao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Map<String, String> selectUser2 = user2Dao.selectUser2();
        if (selectUser2.containsKey(username)){
            resp.sendRedirect("failregister.jsp");
        }else {
            User2 user2=new User2(username,password);
            user2Dao.addUser2(user2);
            resp.sendRedirect("successregister.jsp");
        }
    }
}
