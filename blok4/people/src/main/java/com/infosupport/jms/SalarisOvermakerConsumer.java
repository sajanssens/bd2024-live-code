package com.infosupport.jms;

import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(name = "salarisMdb")
public class SalarisOvermakerConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            String m = message.getBody(String.class);
            System.out.println("Message received: " + m);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
