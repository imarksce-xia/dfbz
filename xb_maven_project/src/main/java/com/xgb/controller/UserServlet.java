package com.xgb.controller;

import com.alibaba.fastjson.JSONObject;
import com.xgb.entity.Dept;
import com.xgb.entity.User;
import com.xgb.service.UserService;
import com.xgb.utils.DateUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author iMarksce
 * @date 2020/9/22
 * @Description
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserService();

    /**
     * 功能描述
     *
     * @param req, resp
     * @return void
     * @author iMarksce
     * @date 2020/9/23
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        Map parameterMap = req.getParameterMap();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String time = DateUtil.getDateStr();
        user.setLoginTime(time);
        userService.update(user);
        resp.sendRedirect("/user/list");
    }


    /**
     * 功能描述
     *
     * @param req, resp
     * @return void
     * @author iMarksce
     * @date 2020/9/22
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pageStr = req.getParameter("page");
        if (username == null) {
            username = "";
        }
        Integer page = 1;
        Integer count = userService.getCount(username);
        Integer pageTotal = count % 3 == 0 ? count / 3 : count / 3 + 1;
        if (pageStr != null && !"".equals(pageStr)) {
            page = Integer.valueOf(pageStr);
        }
        if (page <= 0) {
            page = 1;
        }
        if (page >= pageTotal) {
            page = pageTotal;
        }
        List<User> list = userService.listAll(username, page);
        req.setAttribute("list", list);
        req.setAttribute("username", username);
        req.setAttribute("page", page);
        req.setAttribute("pageTotal", pageTotal);
        req.setAttribute("count", count);
        req.getRequestDispatcher("/html/user/userList.jsp").forward(req, resp);
    }

    /**
     * 功能描述
     *
     * @param resp, resp
     * @return void
     * @author iMarksce
     * @date 2020/9/23
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        Map<String, String[]> map = req.getParameterMap();
        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String loginTime = DateUtil.getDateStr();
        user.setLoginTime(loginTime);
        user.setRegisterTime(loginTime);
        userService.add(user);
        resp.sendRedirect("/user/list");
    }

    /**
     * 功能描述
     *
     * @param req, resp
     * @return void
     * @author iMarksce
     * @date 2020/9/23
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        userService.delete(Integer.valueOf(id));
        resp.sendRedirect("/user/list");
    }

    /**
     * 功能描述
     *
     * @param req, resp
     * @return void
     * @author iMarksce
     * @date 2020/9/23
     */
    protected void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = userService.getUserById(Integer.valueOf(id));
        List<Dept> dept = userService.deptAll();
        req.setAttribute("user", user);
        req.setAttribute("list", dept);
        req.getRequestDispatcher("/html/user/userUpdate.jsp").forward(req, resp);
    }

    /**
     * 功能描述
     *
     * @param req, resp
     * @return void
     * @author iMarksce
     * @date 2020/9/24
     */
    protected void listDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> dept = userService.deptAll();
        resp.getWriter().write(JSONObject.toJSONString(dept));
    }

    /**
     * 功能描述
     *
     * @param req, resp
     * @return void
     * @author iMarksce
     * @date 2020/9/26
     */
    protected void getUserByDeptId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptId = req.getParameter("deptId");
        List<User> userByDeptId = userService.getUserByDeptId(Integer.valueOf(deptId));
        resp.getWriter().write(JSONObject.toJSONString(userByDeptId));
    }
}
