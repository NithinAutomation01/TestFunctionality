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
package com.pdfunit.demo.cacheddocument;

import static com.pdfunit.AbstractTest.PATH;

import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pdfunit.AssertThat;
import com.pdfunit.DateResolution;
import com.pdfunit.util.DateHelper;
import com.pdfunit.validators.DocumentValidator;

/**
 * This sample shows how to cache a test document for many tests.
 * 
 * @author Carsten Siedentop, February 2013
 */
public class CachedDocumentTestDemo {

  private static DocumentValidator document;

  @BeforeClass  // test document will be cached for many tests
  public static void loadTestDocument() throws Exception {
    String filename = PATH + "content/diverseContentOnMultiplePages.pdf";
    document = AssertThat.document(filename);
  }
  
  @Test
  public void testNumberBookmarks() throws Exception {
    document.hasNumberOfBookmarks(4);
  }

  @Test
  public void testCreationDate() throws Exception {
    Calendar expectedCreationDate = DateHelper.getCalendar("27.10.2013", "dd.MM.yyyy");
    document.hasCreationDate().equalsTo(expectedCreationDate, DateResolution.DATE);
  }
  
  @Test
  public void testNoModificationDate() throws Exception {
    document.hasNoModificationDate();
  }
  
  @Test  // bad designed test
  public void testAll() throws Exception {
    Calendar expectedCreationDate = DateHelper.getCalendar("27.10.2013", "dd.MM.yyyy");
    document.hasNumberOfBookmarks(4)
            .hasCreationDate().equalsTo(expectedCreationDate, DateResolution.DATE)
            .hasNoModificationDate()
    ;
  }
  
}
