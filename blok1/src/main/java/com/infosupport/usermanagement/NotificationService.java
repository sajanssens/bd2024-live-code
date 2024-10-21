package com.infosupport.usermanagement;

public interface NotificationService {
    void sendMail(String username, String subject, String body);
}
