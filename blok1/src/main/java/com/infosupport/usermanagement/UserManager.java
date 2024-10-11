package com.infosupport.usermanagement;

public interface UserManager
{
    void savePassword(String username, String newPassword);

    boolean isValidPassword(String username, String oldPassword, String newPassword);

    String getEmailAddress(String username);
}