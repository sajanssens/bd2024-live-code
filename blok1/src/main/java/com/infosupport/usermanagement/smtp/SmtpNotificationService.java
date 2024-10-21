package com.infosupport.usermanagement.smtp;

import java.util.Collections;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.infosupport.usermanagement.NotificationService;
import com.infosupport.usermanagement.UserManager;

public class SmtpNotificationService implements NotificationService {

    private UserManager userManager;
    private SmtpClient client;

    public SmtpNotificationService(SmtpClient client, UserManager userManager) {
        this.client = client;
        this.userManager = userManager;
    }

    @Override
    public void sendMail(String username, String subject, String body) {
        String emailAddress = userManager.getEmailAddress(username);
        var message = new SimpleEmail();
        try {
            message.setFrom("noreply@example.com");
            message.setTo(Collections.singleton(new InternetAddress(emailAddress)));
            message.setMsg(body);
            client.send(message);
        } catch (AddressException | EmailException e) {
            throw new RuntimeException(String.format("Sending notification via email to %s", emailAddress), e);
        }
    }

}
