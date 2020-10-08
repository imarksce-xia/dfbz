package com.servlet;

import com.entity.User3;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String uri = req.getRequestURI();
        String[] split = uri.split("/");
        if ("list".equals(split[split.length - 1])) {
            list(req, resp);
        } else if ("delete".equals(split[split.length - 1])) {
            delete(req, resp);
        } else if ("add".equals(split[split.length - 1])) {
            add(req, resp);
        } else if ("toUpdate".equals(split[split.length - 1])) {
            toUpdate(req, resp);
        } else if ("update".equals(split[split.length - 1])) {
            update(req, resp);
        }
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        if (name == null) {
            name = "";
        }

        Integer count = userService.count(name);
        Integer pageTotal = count % 3 == 0 ? count / 3 : count / 3 + 1;

        String pageStr = req.getParameter("page");
        Integer page = 1;
        if (pageStr != null && pageStr != "") {
            page = Integer.valueOf(pageStr);
        }
        if (page <= 0) {
            page = 1;
        }
        if (page > pageTotal) {
            page = pageTotal;
        }


        List<User3> list = userService.user3List(name, page);
        req.setAttribute("page", page);
        req.setAttribute("list", list);
        req.setAttribute("name", name);
        req.setAttribute("count", count);
        req.setAttribute("pageTotal", pageTotal);
        req.getRequestDispatcher("/userList.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        User3 user3 = new User3();
        Map<String, String[]> parameterMap = req.getParameterMap();
        try {
            BeanUtils.populate(user3, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        userService.add(user3);
        resp.sendRedirect("/user/list");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        if (id == null || id == "") {
            resp.sendRedirect("/user/list");
            return;
        }
        userService.deleteById(Integer.valueOf(id));
        resp.sendRedirect("/user/list");
    }

    protected void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        User3 user3 = userService.getUserById(Integer.valueOf(id));
        req.setAttribute("user3", user3);
        req.getRequestDispatcher("/userUpdate.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        User3 user3 = new User3();
        Map<String, String[]> parameterMap = req.getParameterMap();
        try {
            BeanUtils.populate(user3, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        userService.update(user3);
        resp.sendRedirect("/user/list");
    }
}
