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
package com.pdfunit.demo.oldnames;

import static com.pdfunit.AbstractTest.PATH;
import static com.pdfunit.Constants.EVERY_PAGE;

import org.junit.Test;

import com.pdfunit.AssertThat;

/**
 * Example how to use PDFUnit.
 * <p>
 * This examples show how to verify that an expected text
 * is not present in the complete document.
 * </p>
 * 
 * @author Carsten Siedentop, February 2013
 */
public class NewCEOTests {

  @Test
  public void verifyOldCEONotPresent() throws Exception {
    String filename = PATH + "content/diverseContentOnMultiplePages.pdf";
    
    String oldCEO = "foo";
    
    AssertThat.document(filename)
              .restrictedTo(EVERY_PAGE)
              .hasText() 
              .notContaining(oldCEO) 
    ;
  }

}
