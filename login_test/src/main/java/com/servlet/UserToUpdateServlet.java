package com.servlet;

import com.dao.User1Dao;
import com.entity.User1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/toupdate")
public class UserToUpdateServlet extends HttpServlet {
    private User1Dao userDao = new User1Dao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        User1 user1 = userDao.getUserById1(name);
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.print("<meta charset='UTF-8'>");
        out.println("<title>查询用户</title>");
        out.println("<body>");
        out.println("<form action='update' method='service'>");
        out.println("name：<input type='text' name='name' value='" + user1.getName() + "'><br><br>");
        out.println("age：<input type='text' name='age' value='" + user1.getAge() + "'><br><br>");
        out.println("sex：<input type='text' name='sex' value='" + user1.getSex() + "'><br><br>");
        out.println("<input type='submit' value='修改' >");
        out.println("</form>");
        out.println("</body>");
        out.println("</head>");
        out.println("</html>");
        out.close();
    }
}
