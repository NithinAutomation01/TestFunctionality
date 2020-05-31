/* ***************************************************************************
 *                                                                           *
 * PDFUnit - Automated PDF Tests                                             *
 *                                                                           *
 * Copyright (C) 2016 PDFUnit.com                                            *
 *                                                                           *
 * This file is part of the commercial library PDFUnit.                      *
 *                                                                           *
 * Legal information__: http://pdfunit.com/en/licenseinfo.html               *
 * Manual_____________: http://pdfunit.com/en/download/index.html            *
 * Contact for license: license[at]pdfunit.com                               *
 *                                                                           *
 *************************************************************************** *
 * Author: Carsten Siedentop                                                 *
 *************************************************************************** */
package com.pdfunit.demo.mail_dumbster192.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Helper class to send a mail with an attachment.
 * This class is used in the context of unit tests.
 * 
 * <p>
 * This helper class is related to com.dumbster.smtp.SmtpMessage
 * of dumbster-1.9.0.2-SNAPSHOT.jar.
 * </p>
 *
 * @author Carsten Siedentop, August 2014
 */
public class SendMailHelper {

  public static final int SMTP_PORT = 1081;

  private static String FROM = "something@your.mailserver.com";
  private String mailRecipient;
  private String subject;
  private String bodyText;
  private String fileAttachment;

  private SendMailHelper() {
  }

  public static SendMailHelper newInstance() {
    return new SendMailHelper();
  }

  public SendMailHelper setRecipient(String mailRecipient) {
    this.mailRecipient = mailRecipient;
    return this;
  }

  public SendMailHelper setSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public SendMailHelper setBodyText(String bodyText) {
    this.bodyText = bodyText;
    return this;
  }

  public SendMailHelper addAttachment(String fileAttachment) {
    this.fileAttachment = fileAttachment;
    return this;
  }

  public void send() throws MessagingException {
    Session mailSession = createMailSession();
    MimeBodyPart bodyPart = buildMessageBody(bodyText);
    MimeBodyPart attachmentPart = buildFileAttachment(fileAttachment);
    MimeMessage mimeMessage = new MimeMessage(mailSession);
    setHeaderData(mimeMessage, mailRecipient, subject);
    setContentAndAttachment(mimeMessage, bodyPart, attachmentPart);
    Transport.send(mimeMessage);
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // Private methods:
  //////////////////////////////////////////////////////////////////////////////

  private static void setHeaderData(MimeMessage message, String mailReceiver, String subject) throws AddressException, MessagingException {
    message.setFrom(new InternetAddress(FROM ));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailReceiver));
    message.setSubject(subject);
  }

  private static void setContentAndAttachment(MimeMessage message, BodyPart bodyPart, BodyPart attachmentPart) throws MessagingException {
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(bodyPart);
    multipart.addBodyPart(attachmentPart);
    message.setContent(multipart);
  }
  
  private Session createMailSession() {
    Properties mailProps = new Properties();
    mailProps.setProperty("mail.smtp.host", "localhost");
    mailProps.setProperty("mail.smtp.port", "" + SMTP_PORT);
    mailProps.setProperty("mail.smtp.sendpartial", "true");
    mailProps.put("mail.smtp.host", "localhost");
    Authenticator noAuthenticator = null;
    Session session = Session.getDefaultInstance(mailProps, noAuthenticator);
    return session;
  }

  private MimeBodyPart buildFileAttachment(String fileToAttach) throws MessagingException {
    MimeBodyPart messageBodyPart = new MimeBodyPart();
    DataSource source = new javax.activation.FileDataSource(fileToAttach);
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(fileToAttach);
    return messageBodyPart;
  }

  private MimeBodyPart buildMessageBody(String bodyText) throws MessagingException {
    MimeBodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setText(bodyText);
    return messageBodyPart;
  }

}
