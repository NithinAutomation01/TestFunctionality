/* ***************************************************************************
 *                                                                           *
 * PDFUnit - Automated PDF Tests                                             *
 *                                                                           *
 * Copyright (C) 2016 PDFUnit.com                                            *
 *                                                                           *
 * This file is part of the commercial library PDFUnit.                      *
 *                                                                           *
 * Legal informati_: http://pdfunit.com/license/                          *
 * Manual_____________: http://pdfunit.com/en/download/index.html            *
 * Contact for license: license[at]pdfunit.com                               *
 *                                                                           *
 *************************************************************************** *
 * Author: Carsten Siedentop                                                 *
 *************************************************************************** */
package com.pdfunit.demo.mail_dumbster192;

import static com.pdfunit.Constants.EVERY_PAGE;
import static com.pdfunit.Constants.FIRST_PAGE;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dumbster.smtp.ServerOptions;
import com.dumbster.smtp.SmtpServer;
import com.dumbster.smtp.SmtpServerFactory;
import com.pdfunit.AssertThat;
import com.pdfunit.demo.mail_dumbster192.util.ReceiveMailHelper;
import com.pdfunit.demo.mail_dumbster192.util.SendMailHelper;
import com.pdfunit.validators.DocumentValidator;

/**
 * This sample shows how to test a PDF document which was sent by email.
 * 
 * <p>
 * This example uses the mail testing API <a href="https://github.com/rjo1970/dumbster.git">dumbster</a>,
 * version 1.9.2.
 * </p>
 * 
 * @author Carsten Siedentop, August 2014
 * see https://github.com/rjo1970/dumbster.git
 */
public class MailWithPDFAttachmentTest_Dumbster192 {

  private SmtpServer server;
  
  @Before
  public void createEmptyMailStoreDirectory() throws Exception {
    ServerOptions options = new ServerOptions();
    options.port = SendMailHelper.SMTP_PORT;
    options.threaded = false;
    server = SmtpServerFactory.startServer(options);
  }

  @After
  public void teardown() {
    server.stop();
  }

  /**
   * This test invokes a business system which sends a mail with a PDF attachment.
   * After sending the mail the PDF file is validated using PDFUnit.
   */
  @Test
  public void verifyPDFReceivedByEmail() throws Exception {
    // Arrange:
    BusinessSystem myBusinessSystem = BusinessSystem.newInstance();
    
    // Act:
    myBusinessSystem.doSomethingImportant();
    myBusinessSystem.sendMailWithPDFAttachment();
    
    // Assert:
    String pdfFileName = myBusinessSystem.getAttachedPDFName();
    byte[] attachmentAsByteArray = ReceiveMailHelper.getInstance(server)
                                                    .getAttachmentFromLastMail(pdfFileName);
    DocumentValidator pdfDocument = AssertThat.document(attachmentAsByteArray);
    pdfDocument.hasNumberOfPages(4);
    pdfDocument.restrictedTo(FIRST_PAGE)
               .hasText()
               .containing("This is a document that is used for unit tests of PDFUnit")
    ;
    pdfDocument.restrictedTo(EVERY_PAGE)
               .hasText()
               .containing("http://pdfunit.com")
    ;
  }

}
