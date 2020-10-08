package com.xgb.service;

import com.xgb.dao.MeetingDao;
import com.xgb.entity.Meeting;
import com.xgb.enums.MeetingStatusEnum;
import com.xgb.utils.DateUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author iMarksce
 * @date 2020/9/26
 * @Description
 */
public class MeetingService {

    private MeetingDao meetingDao = new MeetingDao();

    /**
     * 功能描述
     *
     * @return java.util.List<com.xgb.entity.Meeting>
     * @author iMarksce
     * @date 2020/9/26
     */
    public List<Meeting> listPage(String title, Integer page) {
        return meetingDao.listPage(title, page);
    }

    /**
     * 功能描述
     *
     * @param title
     * @return java.lang.Integer
     * @author iMarksce
     * @date 2020/9/26
     */
    public Integer getCount(String title) {
        return meetingDao.getCount(title);
    }

    /**
     * 功能描述
     *
     * @return java.util.List<com.xgb.entity.Meeting>
     * @author iMarksce
     * @date 2020/9/26
     */
    public List<Meeting> listAll() {
        return meetingDao.listAll();
    }

    /**
     * 功能描述
     *
     * @param meeting
     * @return void
     * @author iMarksce
     * @date 2020/9/26
     */
    public void addMeeting(Meeting meeting) {
        meeting.setPublishDate(DateUtil.getDateStr());
        meeting.setStatus(MeetingStatusEnum.NO_START.getValue());
        meeting.setMakeUser(Arrays.toString(meeting.getMakeUsers()));
        meetingDao.addMeeting(meeting);
    }

    /**
     * 功能描述
     *
     * @return void
     * @author iMarksce
     * @date 2020/9/26
     */
    public void updateStatusTimer() {
        List<Meeting> list = meetingDao.listAll();
        list.stream().forEach(n -> {
            long startDate = DateUtil.getTimeByStr(n.getStartTime());
            long endDate = DateUtil.getTimeByStr(n.getEndTime());
            long nowDate = new Date().getTime();

            Meeting meeting = new Meeting();
            meeting.setId(n.getId());
            if (startDate > nowDate) {

            } else if (startDate <= nowDate && endDate > nowDate) {
                meeting.setStatus(MeetingStatusEnum.MEETING.getValue());
                meetingDao.updateStatusById(meeting);
            } else {
                meeting.setStatus(MeetingStatusEnum.END.getValue());
                meetingDao.updateStatusById(meeting);
            }
        });
    }

    /**
     * 功能描述
     *
     * @param id
     * @return com.xgb.entity.Meeting
     * @author iMarksce
     * @date 2020/9/26
     */
    public Meeting getMeetingById(Integer id) {
        return meetingDao.getMeetingById(id);
    }

    /**
     * 功能描述
     *
     * @param meetingId
     * @return java.util.List<java.lang.Integer>
     * @author iMarksce
     * @date 2020/9/27
     */
    public List<Integer> listUserId(Integer meetingId) {
        return meetingDao.listUserId(meetingId);
    }

    /**
     * 功能描述
     *
     * @param meetingId, userId
     * @return void
     * @author iMarksce
     * @date 2020/9/27
     */
    public void joinMeeting(Integer meetingId, Integer userId) {
        meetingDao.joinMeeting(meetingId, userId);
    }

    /**
     * 功能描述
     *
     * @param meetingId, userId
     * @return void
     * @author iMarksce
     * @date 2020/9/27
     */
    public void delMeeting(Integer meetingId, Integer userId) {
        meetingDao.delMeeting(meetingId, userId);
    }
}