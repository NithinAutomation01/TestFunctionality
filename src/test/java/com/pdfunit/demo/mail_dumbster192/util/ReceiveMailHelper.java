/* ***************************************************************************
 *                                                                           *
 * PDFUnit - Automated PDF Tests                                             *
 *                                                                           *
 * Copyright (C) 2016 PDFUnit.com                                            *
 *                                                                           *
 * This file is part of the commercial library PDFUnit.                      *
 *                                                                           *
 * Legal information__: http://pdfunit.com/license/                          *
 * Manual_____________: http://pdfunit.com/en/download/index.html            *
 * Contact for license: license[at]pdfunit.com                               *
 *                                                                           *
 *************************************************************************** *
 * Author: Carsten Siedentop                                                 *
 *************************************************************************** */
package com.pdfunit.demo.mail_dumbster192.util;

import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.xml.bind.DatatypeConverter;

import com.dumbster.smtp.MailMessage;
import com.dumbster.smtp.SmtpServer;

/**
 * Helper class to extract parts of a multipart message.
 * This class is used in the context of unit tests.
 * 
 * <p>
 * This helper class is related to com.dumbster.smtp.SmtpMessage
 * of dumbster-1.9.0.2-SNAPSHOT.jar.
 * </p>
 * 
 * <p>
 * Currently only PDF attachments are extracted. Further
 * file formats can be implemented in the same way.
 * </p>
 * 
 * @author Carsten Siedentop, August 2014
 */
public class ReceiveMailHelper {

  private static final String BOUNDARY_PREFIX = "--=_Part";
  private static final int DEFAULT_SIZE = 100000;
  private List<String> mailContent;
  private static SmtpServer server;
  private static final int WAIT_TICKS         = 100000;
  
  public static ReceiveMailHelper getInstance(SmtpServer server) {
    ReceiveMailHelper.server = server;
    return new ReceiveMailHelper();
  }

  public byte[] getAttachmentFromLastMail(String filename) throws AttachmentNameNotFoundException {
    String messageWithAttachment = readLastMailFromServer();
    this.mailContent = splitMailMessage(messageWithAttachment);
    
    // find position for filename
    int indexToFilename = findPositionOfFilename(filename);
    int indexStartOfAttachmentContent = findStartPositionOfContent(indexToFilename);
    
    // find previous position of the boundary for this file
    String boundaryName = findBoundaryName(indexToFilename);
    
    // find the end position of the boundary
    int indexToBoundaryEnd = findLastPosition(indexStartOfAttachmentContent, boundaryName);
    
    // read the lines ...
    // ... and convert them from base64 into byte[]
    byte[] pdfByteArray = decodeBase64(indexStartOfAttachmentContent, indexToBoundaryEnd);
    return pdfByteArray;
  }
  
  private byte[] decodeBase64(int indexToFilename, int indexToBoundaryEnd) {
    StringBuffer buffer = new StringBuffer(DEFAULT_SIZE);
    for (int i = indexToFilename; i < indexToBoundaryEnd; i++) {
      String line = mailContent.get(i);
      buffer.append(line);
    }
    String base64String = buffer.toString();
    byte[] decodedData = DatatypeConverter.parseBase64Binary(base64String);
    return decodedData;
  }

  /**
   * Because the filename maybe splitted inside the mail message, this method checks
   * only for the last 12 characters. This kind of implementation is not intended for
   * production.
   */
  private int findPositionOfFilename(String filename) throws AttachmentNameNotFoundException {
    String filenameWithoutPath = new File(filename).getName();
    int filenameLength = filenameWithoutPath.length();
    String filenameLast12Characters = filenameWithoutPath.substring(filenameLength - 12);
    String regexForFilename = "^.*filename.*" + filenameLast12Characters + ".*";
    for (int i = 0; i < mailContent.size(); i++) {
      String line = mailContent.get(i);
      System.out.println(line);
      boolean lineFound = line.trim().matches(regexForFilename);
      if (lineFound) {
        return i;
      }
    }
    String message = "The filename '" + filename + "' could not be found in current message.";
    throw new AttachmentNameNotFoundException(message);
  }

  private String findBoundaryName(int indexToFilename) throws AttachmentNameNotFoundException {
    for (int i = indexToFilename; i >= 0; i--) {
      String line = mailContent.get(i);
      boolean lineFound = line.contains(BOUNDARY_PREFIX);
      if (lineFound) {
        return line;
      }
    }
    String message = "The token '" + BOUNDARY_PREFIX + "' could not be found in current message.";
    throw new AttachmentNameNotFoundException(message);
  }

  // The content begins after the next empty line.
  private int findStartPositionOfContent(int firstIndexOfFilename) throws AttachmentNameNotFoundException {
    for (int i = firstIndexOfFilename; i < mailContent.size(); i++) {
      String line = mailContent.get(i);
      boolean lineFound = line.isEmpty();
      if (lineFound) {
        return (i + 1);
      }
    }
    String message = "No empty line found after line '" + firstIndexOfFilename + "'.";
    throw new AttachmentNameNotFoundException(message);
  }

  private int findLastPosition(int startIndex, String boundaryName) throws AttachmentNameNotFoundException {
    for (int i = startIndex; i < mailContent.size(); i++) {
      String line = mailContent.get(i);
      boolean lineFound = line.contains(BOUNDARY_PREFIX);
      if (lineFound) {
        return i;
      }
    }
    String message = "The end token '" + boundaryName + "' could not be found in current message.";
    throw new AttachmentNameNotFoundException(message);
  }

  private static String readLastMailFromServer() {
    int oneMessage = 1;
    server.anticipateMessageCountFor(oneMessage, WAIT_TICKS);
    MailMessage receivedMessage = server.getMessage(0);
    String receivedMessageBody = receivedMessage.getBody();
    return receivedMessageBody;
  }

  private List<String> splitMailMessage(String messageWithAttachment) {
    String[] lines = messageWithAttachment.split("\n");
    List<String> linesAsList = new Vector<String>();
    for (int i = 0; i < lines.length; i++) {
      linesAsList.add(lines[i]);
      linesAsList.add("\n");
    }
    return linesAsList;
  }

}