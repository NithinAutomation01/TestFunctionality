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
package com.pdfunit.demo.mail_dumbster192;

import java.io.File;
import java.net.URL;

import javax.mail.MessagingException;

import com.pdfunit.demo.mail_dumbster192.util.SendMailHelper;

/**
 * This class is a dummy for any business system.
 * It sends a mail which is validated by a unit test.
 * 
 * @author Carsten Siedentop, August 2014
 */
public class BusinessSystem {

  private static final String pdfFileName = "pdf-in-tests/content/diverseContentOnMultiplePages.pdf";
  private String mailRecipient = "something@your.mailserver.com";
  private String bodyText = "Automated mail generated by " + BusinessSystem.class.getSimpleName();
  private String subject = "Unittest with PDF attachment. ID=";

  public static BusinessSystem newInstance() {
    return new BusinessSystem();
  }

  public BusinessSystem doSomethingImportant() {
    return this;
  }

  public String getAttachedPDFName() {
    ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
    URL resource = contextClassLoader.getResource(pdfFileName);
    String fileNameFromResourceWithLeadingSlash = resource.getFile();
    File file = new File(fileNameFromResourceWithLeadingSlash);
    String absolutePath = file.getAbsolutePath();
    return absolutePath;
  }

  public void sendMailWithPDFAttachment() throws MessagingException {
    String pdfFileName = getAttachedPDFName();
    SendMailHelper.newInstance()
                  .setRecipient(mailRecipient)
                  .setSubject(subject)
                  .setBodyText(bodyText)
                  .addAttachment(pdfFileName)
                  .send();
  }

  public String getSubject() {
    return subject;
  }
  
}
