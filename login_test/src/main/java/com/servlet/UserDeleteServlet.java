package com.servlet;

import com.dao.User1Dao;
import com.entity.User1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class UserDeleteServlet extends HttpServlet {
    private User1Dao userDao = new User1Dao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        User1Dao.delete1(new User1(name));
        resp.sendRedirect("/select");
    }
}
