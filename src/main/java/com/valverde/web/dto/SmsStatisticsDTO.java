package com.valverde.web.dto;

import com.valverde.entity.Sms;
import com.valverde.enums.State;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
public class SmsStatisticsDTO {

    private String recipients;

    private String message;

    private Date insertDate;

    private Date sentDate;

    private Integer sendAttempts;

    private State state;

    public SmsStatisticsDTO(Sms sms) {
        this.recipients = sms.getRecipients();
        this.message = sms.getMessage();
        this.insertDate = sms.getInsertDate();
        this.sentDate = sms.getSentDate();
        this.sendAttempts = sms.getSendAttempts();
        this.state = sms.getState();
    }
}