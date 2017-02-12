package com.valverde.service.twilio;

import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

class TwilioSmsCreator {

    private final TwilioRestClient client;

    TwilioSmsCreator(TwilioRestClient client) {
        this.client = client;
    }

    Message create(String to, String from, String body) {
        MessageCreator messageCreator = new MessageCreator(
                new PhoneNumber(to),
                new PhoneNumber(from),
                body);

        return messageCreator.create(this.client);
    }
}