package com.servlet;

import com.dao.User1Dao;
import com.entity.User1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class UserAddServlet extends HttpServlet {
    private User1Dao user1Dao=new User1Dao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String sex=req.getParameter("sex");
        User1 user1 = new User1();
        user1.setName(name);
        user1.setAge(Integer.valueOf(age));
        user1.setSex(sex);
        user1Dao.addUser1(user1);
        resp.sendRedirect("successadd.jsp");
    }
}
