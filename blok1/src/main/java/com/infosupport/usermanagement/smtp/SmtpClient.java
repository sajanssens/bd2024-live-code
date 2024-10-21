package com.infosupport.usermanagement.smtp;

import java.util.Properties;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

public class SmtpClient {

    private Properties props;

    public SmtpClient(Properties props){
        this.props = props;}
    
    public void send(Email email) throws EmailException{
        email.setHostName(props.getProperty("email.host"));
        email.setSmtpPort(Integer.parseInt(props.getProperty("email.port")));
        email.send();
    }
}
