package com.xgb.shedule;

import com.xgb.service.MeetingService;

import java.util.TimerTask;

/**
 * @author iMarksce
 * @date 2020/9/26
 * @Description
 */
public class MeetingTask extends TimerTask {
    private boolean isRunning = false;
    private MeetingService meetingService = new MeetingService();

    @Override
    public void run() {
        if (!isRunning) {
            isRunning = true;
            meetingService.updateStatusTimer();
            isRunning = false;
        }
    }
}
