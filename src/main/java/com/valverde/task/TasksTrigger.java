package com.valverde.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TasksTrigger {

    /** Every 5 minutes from 9:00 AM to 9:00 PM */
    @Scheduled(cron = "0 0/5 9-21 * * *")
    public void SmsTaskTrigger() {
        smsSenderTask.startTask();
    }

    @Autowired
    public TasksTrigger(SmsSenderTask smsSenderTask) {
        this.smsSenderTask = smsSenderTask;
    }

    private final SmsSenderTask smsSenderTask;
}