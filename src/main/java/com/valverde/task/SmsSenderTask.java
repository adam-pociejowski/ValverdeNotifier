package com.valverde.task;

import com.valverde.entity.Sms;
import com.valverde.enums.State;
import com.valverde.service.SmsService;
import com.valverde.service.twilio.TwilioSmsClient;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;

@Component
@CommonsLog
public class SmsSenderTask extends AbstractTask {

    @Async
    @Override
    void startTask() {
        try {
            logStartTask();
            List<Sms> messages = smsService.getMessagesToSend();
            TwilioSmsClient smsClient = new TwilioSmsClient(env);
            for (Sms sms : messages) {
                try {
                    smsClient.sendMessage(sms.getRecipients(), sms.getMessage());
                    sms.setState(State.SUCCESS);
                    sms.setSentDate(new Date());
                    log.info(getTaskName()+" send sms to "+sms.getRecipients());
                } catch (Exception e) {
                    if (sms.getSendAttempts() + 1 >= maxSendAttempts) {
                        sms.setState(State.ERROR);
                    }
                    log.error(getTaskName()+" cannot send sms to "+sms.getRecipients(), e);
                } finally {
                    sms.setSendAttempts(sms.getSendAttempts() + 1);
                    smsService.save(sms);
                }
            }
            logEndTask();
        } catch (Exception e) {
            log.error("Error in "+getTaskName(), e);
        }
    }

    @Autowired
    public SmsSenderTask(SmsService smsService, Environment env) {
        this.smsService = smsService;
        this.env = env;
        maxSendAttempts = Integer.parseInt(env.getProperty("sms.max.send.attempts"));
    }

    private final SmsService smsService;

    private final Environment env;

    private Integer maxSendAttempts;
}
