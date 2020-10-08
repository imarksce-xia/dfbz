package com.xgb.controller;

import com.xgb.constants.Constant;
import com.xgb.entity.Meeting;
import com.xgb.entity.User;
import com.xgb.enums.MeetingStatusEnum;
import com.xgb.service.MeetingService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author iMarksce
 * @date 2020/9/26
 * @Description
 */
@WebServlet("/meeting/*")
public class MeetingServlet extends BaseServlet {
    private MeetingService meetingService = new MeetingService();

    /**
     * 功能描述
     *
     * @param req, resp
     * @return void
     * @author iMarksce
     * @date 2020/9/26
     */
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String pageStr = req.getParameter("page");
        if (title == null) {
            title = "";
        }
        Integer page = 1;
        Integer count = meetingService.getCount(title);
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
        List<Meeting> list = meetingService.listPage(title, page);
        req.setAttribute("list", list);
        req.setAttribute("page", page);
        req.setAttribute("pageTotal", pageTotal);
        req.setAttribute("count", count);
        req.setAttribute("title", title);
        req.getRequestDispatcher("/html/meeting/meetingList.jsp").forward(req, resp);
    }

    /**
     * 功能描述
     *
     * @param req, resp
     * @return void
     * @author iMarksce
     * @date 2020/9/26
     */
    public void addMeeting(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();
        Meeting meeting = new Meeting();
        try {
            BeanUtils.populate(meeting, map);
            meetingService.addMeeting(meeting);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/meeting/list").forward(req, resp);
    }

    /**
     * 功能描述
     *
     * @param req, resp
     * @return void
     * @author iMarksce
     * @date 2020/9/26
     */
    public void getMeetingById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> map = new HashMap<>();
        String id = req.getParameter("id");
        Integer loginUserId = loginUser.getId();

        Meeting meeting = meetingService.getMeetingById(Integer.valueOf(id));
        List<Integer> integers = meetingService.listUserId(Integer.valueOf(id));
        String makeUser = meeting.getMakeUser();
        Integer should = makeUser.split(",").length;

        map.put("should", should.toString());
        if (integers == null) {
            map.put("realCount", "0");
        } else {
            map.put("realCount", integers.size() + "");
        }

        boolean contains = makeUser.contains(loginUserId.toString());
        if (contains) {
            if (integers.contains(loginUserId)) {
                map.put("flag", "2");
            } else {
                map.put("flag", "3");
            }
        } else {
            map.put("flag", "1");
        }
        req.setAttribute("meeting", meeting);
        req.setAttribute("map", map);
        req.getRequestDispatcher("/html/meeting/meetingDetail.jsp").forward(req, resp);
    }

    /**
     * 功能描述
     *
     * @param req, resp
     * @return void
     * @author iMarksce
     * @date 2020/9/28
     */
    public void joinMeeting(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Meeting meeting = meetingService.getMeetingById(Integer.valueOf(id));
        if (meeting.getStatus().equals(MeetingStatusEnum.NO_START.getValue())) {
            meetingService.joinMeeting(Integer.valueOf(id), loginUser.getId());
        }
        req.setAttribute("id", id);
        req.getRequestDispatcher("/meeting/getMeetingById").forward(req, resp);
    }

    /**
     * 功能描述
     *
     * @param req, resp
     * @return void
     * @author iMarksce
     * @date 2020/9/28
     */
    public void unJoinMeeting(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Meeting meeting = meetingService.getMeetingById(Integer.valueOf(id));
        if (meeting.getStatus().equals(MeetingStatusEnum.NO_START.getValue())) {
            meetingService.delMeeting(Integer.valueOf(id), loginUser.getId());
        }
        req.setAttribute("id", id);
        req.getRequestDispatcher("/meeting/getMeetingById").forward(req, resp);
    }

}