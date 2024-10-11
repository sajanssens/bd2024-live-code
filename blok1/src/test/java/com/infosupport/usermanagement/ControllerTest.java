package com.infosupport.usermanagement;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class ControllerTest {

    private Controller sut;
    private UserManager userManagerMock;
    private NotificationService notificationServiceMock;

    public ControllerTest() {
        userManagerMock = mock(UserManager.class);
        notificationServiceMock = mock(NotificationService.class);
        sut = new Controller(userManagerMock, notificationServiceMock);
    }

    @Test
    public void changePassword_validNewPassword_savesThePassword() {
        // Arrange
        when(userManagerMock.isValidPassword(anyString(), anyString(), anyString())).thenReturn(true);
        
        // Act 
        sut.changePassword("foo", "Secret", "NewSecret");
        
        // Assert
        verify(userManagerMock).savePassword("foo", "NewSecret");
    }

    @Test
    public void changePassword_validNewPassword_notifies() {
        // Arrange
        when(userManagerMock.isValidPassword(anyString(), anyString(), anyString())).thenReturn(true);
        
        // Act
        sut.changePassword("foo", "Secret", "NewSecret");

        // Assert
        verify(notificationServiceMock).sendMail("foo", "Password changed", "Your password has been changed");
    }

    @Test
    public void changePassword_invalidPassword_doesNotSavePassword() {
        // Arrange
        when(userManagerMock.isValidPassword(anyString(), anyString(), anyString())).thenReturn(false);

        // Act
        assertThrows(SecurityException.class, () -> sut.changePassword("foo", "Secret", "NewSecret"));

        // Assert
        verify(userManagerMock, never()).savePassword(anyString(), anyString());
    }
}
