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
package com.pdfunit.demo.compare;

import static com.pdfunit.AbstractTest.PATH;

import org.junit.Test;

import com.pdfunit.AssertThat;

/**
 * Example how to use PDFUnit.
 * <p>
 * Each method has a short description.
 * </p>
 * 
 * @author Carsten Siedentop, September 2014
 * @since 2014.06
 */
public class CompareTestDemo {

  /**
   * This test compares two PDF documents under different aspects, 
   * but without date and time.
   */
  
  public void comparePDF_ManyWithoutDateTime() throws Exception {
    String filenameTest = PATH + "master/compareToMaster_copy.pdf";
    String filenameMaster = PATH + "master/compareToMaster.pdf";
    
    AssertThat.document(filenameTest)
              .and(filenameMaster)
              .haveSameAuthor()
              .haveSameFormat()
              .haveSameSubject()
              .haveSameTitle()
              .haveSameBookmarks()
              .haveSameProducer()
              .haveSameText()
              
    ;
  }
  
  /**
   * This test compares the formular fields of two documents.
   */
  @Test
  public void compareFieldsByAttributes() throws Exception {
    String filenameTest = PATH + "acrofields/simpleRegistrationForm.pdf";
    String filenameMaster = PATH + "acrofields/simpleRegistrationForm.pdf";
    
    AssertThat.document(filenameTest)
              .and(filenameMaster) 
              .haveSameFieldsByValue()
    ;
  }
  
}
