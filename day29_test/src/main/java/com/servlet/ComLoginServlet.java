package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/login")
public class ComLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        ServletContext servletContext = getServletContext();

        Object obj = servletContext.getAttribute("count");

        if (obj == null) {
            servletContext.setAttribute("count", 1);
        } else {
            Integer oldCount = Integer.valueOf(obj.toString());
            servletContext.setAttribute("count", oldCount + 1);
        }
        resp.getWriter().write("总人数："+Integer.valueOf(servletContext.getAttribute("count").toString()));


//
//        InputStream resourceAsStream = servletContext.getResourceAsStream("/WEB-INF/1.jpg");
//        ServletOutputStream outputStream = resp.getOutputStream();
//        int len;
//        byte[] bytes=new byte[1024];
//        while (true){
//            len=resourceAsStream.read(bytes);
//            if (len==-1){
//                break;
//            }
//            outputStream.write(bytes,0,len);
//        }
//        outputStream.close();
//        resourceAsStream.close();
    }
}
