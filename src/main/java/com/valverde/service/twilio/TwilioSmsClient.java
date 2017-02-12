package com.valverde.service.twilio;

import com.twilio.http.TwilioRestClient;
import org.springframework.core.env.Environment;

public class TwilioSmsClient {

    public void sendMessage(String to, String message) {
        messageCreator.create(to, env.getProperty("twilio.number"), message);
    }

    public TwilioSmsClient(Environment env) {
        this.env = env;
        this.messageCreator = new TwilioSmsCreator(
                new TwilioRestClient.Builder(env.getProperty("twilio.sid"),
                        env.getProperty("twilio.token")).build()
        );
    }

    private TwilioSmsCreator messageCreator;

    private Environment env;
}