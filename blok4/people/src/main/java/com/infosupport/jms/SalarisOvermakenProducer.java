package com.infosupport.jms;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSProducer;
import jakarta.jms.Queue;

// @Singleton
// @Stateful
@Stateless
public class SalarisOvermakenProducer {

    @Resource(name = "jms/salarisQueue")
    private Queue queue;

    @Resource(name = "jms/connectionFactory")
    private ConnectionFactory connectionFactory;

    // @Schedule(hour = "*", minute = "*", second = "*/1")
    public void send() {
        SalarisDto dto = new SalarisDto(140, "schaal 14", 424242);
        System.out.println("About to send message: " + dto);
        try (var context = connectionFactory.createContext()) {
            JMSProducer producer = context.createProducer();
            producer.send(queue, dto.toString());
        }
    }
}
