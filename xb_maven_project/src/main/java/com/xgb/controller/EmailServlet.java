package com.xgb.controller;

import com.xgb.enums.SessionEnum;
import com.xgb.utils.EmailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author iMarksce
 * @date 2020/9/27
 * @Description
 */
@WebServlet("/email/*")
public class EmailServlet extends BaseServlet {

    /**
     *功能描述
     * @author iMarksce
     * @date 2020/9/28
     * @param req, resp
     * @return void
     */
    protected void sendEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String email = req.getParameter("email");
            int code = (int)((Math.random()+1)*1000);
            HttpSession session = req.getSession();
            session.setAttribute(SessionEnum.SESSION_FORGET.getValue(),code);
            session.setMaxInactiveInterval(60);

            EmailUtil.sendEmail(email,code+"");
            resp.getWriter().write("1");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("0");
        }
    }
}