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
import java.util.List;

@WebServlet("/select")
public class UserSelectServlet extends HttpServlet {
    private User1Dao userDao = new User1Dao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        List<User1> user1List = userDao.selectUser1();
        out.println("<html>");
        out.println("<head>");
        out.print("<meta charset='UTF-8'>");
        out.println("<title>查询界面</title>");
        out.println("<body>");
        out.println("<table border='1px solid red'  style='width:50%;' > ");
        out.println("<tr><td>姓名</td><td>年龄</td><td>性别</td><td>删除</td><td>修改</td></tr>");
        user1List.stream().forEach(n -> {
            out.println("<tr>");
            out.println("<td>" + n.getName() + "</td><td>" + n.getAge() + "</td><td>" + n.getSex() + "</td>");
            out.println("<td><a href='delete?name=" + n.getName() + "'>删除</a></td>");
            out.println("<td><a href='toupdate?name=" + n.getName() + "'>修改</a></td>");
            out.println("</tr>");
        });
        out.println("<td><a href='adduser.jsp'>添加</a></td>");
        out.println("</table>");
        out.println("</body>");
        out.println("</head>");
        out.println("</html>");
        out.close();
    }
}
