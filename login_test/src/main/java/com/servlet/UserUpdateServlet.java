package com.servlet;

import com.dao.User1Dao;
import com.entity.User1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UserUpdateServlet extends HttpServlet {
    private User1Dao userDao = new User1Dao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        User1 user1 = new User1();
        user1.setName(name);
        user1.setAge(Integer.valueOf(age));
        user1.setSex(sex);
        User1Dao.update1(user1);
        resp.sendRedirect("/select");
    }
}
