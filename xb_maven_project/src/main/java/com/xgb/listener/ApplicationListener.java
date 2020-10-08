package com.xgb.listener;

import com.xgb.shedule.MeetingTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;
import java.util.Timer;

/**
 * @author iMarksce
 * @date 2020/9/26
 * @Description
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
    /**
     * 功能描述
     *
     * @param sce
     * @return void
     * @author iMarksce
     * @date 2020/9/28
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Timer timer = new Timer();
        MeetingTask meetingTask = new MeetingTask();
        timer.schedule(meetingTask, new Date(), 1000 * 60);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
