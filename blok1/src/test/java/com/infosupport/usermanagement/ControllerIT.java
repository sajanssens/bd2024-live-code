package com.infosupport.usermanagement;

import io.restassured.RestAssured;

import com.infosupport.usermanagement.smtp.SmtpClient;
import com.infosupport.usermanagement.smtp.SmtpNotificationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Properties;

@Testcontainers
public class ControllerIT {

    private static final int PORT_SMTP = 1025;
    private static final int PORT_HTTP = 8025;
    private UserManager userManagerMock;
    private Controller sut;

    @Container
    private GenericContainer<?> mailhog = new GenericContainer<>("mailhog/mailhog")
            .withExposedPorts(PORT_SMTP, PORT_HTTP)
            .waitingFor(Wait.forListeningPort());

    @BeforeEach
    public void setUp() {
        var smtpPort = mailhog.getMappedPort(PORT_SMTP);
        var smtpHost = mailhog.getHost();
        int httpPort = mailhog.getMappedPort(PORT_HTTP);
        RestAssured.baseURI = "http://" + smtpHost;
        RestAssured.port = httpPort;
        RestAssured.basePath = "/api/v2";
        userManagerMock = mock(UserManager.class);
        var props = new Properties();
        props.setProperty("email.host", smtpHost);
        props.setProperty("email.port", String.valueOf(smtpPort));
        sut = new Controller(userManagerMock, new SmtpNotificationService(new SmtpClient(props), userManagerMock));
    }

    @Test
    public void changePassword_validNewPassword_sendsEmail() {
        // Arrange
        when(userManagerMock.getEmailAddress(anyString())).thenReturn("foo@example.org");
        when(userManagerMock.isValidPassword(anyString(), anyString(), anyString())).thenReturn(true);
        
        // Act
        sut.changePassword("foo", "bar", "baz");

        // Assert
        given().when().get("/messsages")
            .then().body("total", equalTo(1))
            .and().body("items[0].To", hasSize(1))
            .and().body("items[0].To[0].Domain", equalTo("example.org"))
            .and().body("items[0].To[0].Mailbox", equalTo("foo"))
            .and().body("items[0].Content.Body", equalTo("Your password has been changed"));
    }

}
