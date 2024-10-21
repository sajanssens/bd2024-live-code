package com.infosupport.usermanagement;

public class Controller {
    private UserManager userManager;
    private NotificationService notificationService;

    public Controller(UserManager userManager, NotificationService notificationService) {
        this.userManager = userManager;
        this.notificationService = notificationService;
    }

    public void changePassword(String username, String oldPassword, String newPassword) {
        if (userManager.isValidPassword(username, oldPassword, newPassword)) {
            userManager.savePassword(username, newPassword);
            notificationService.sendMail(username, "Password changed", "Your password has been changed");
        } else {
            throw new SecurityException("Access Denied.");
        }
    }
}