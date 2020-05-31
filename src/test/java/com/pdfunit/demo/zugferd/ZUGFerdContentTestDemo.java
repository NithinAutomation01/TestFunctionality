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
package com.pdfunit.demo.zugferd;

import static com.pdfunit.AbstractTest.PATH;
import static com.pdfunit.Constants.FIRST_PAGE;

import org.junit.Test;

import com.pdfunit.AssertThat;
import com.pdfunit.filter.region.PageRegion;
import com.pdfunit.xml.XMLNode;

/**
 * This example shows, how to use PDFUnit to validate ZUGFeRD data.
 * 
 * @author Carsten Siedentop, April 2016
 * @since 2016.05
 */
public class ZUGFerdContentTestDemo {

  /**
   * This test validates that the value of the IBANID of the ZUGFeRD data
   * inside the PDF will be the same, as the IBAN of the visible content.
   * <p>
   * All strings will internally be processed with WhitespaceProcessing.IGNORE,
   * because the formatting inside XML and on the PDF page is different.
   * </p>
   */
  @Test
  public void validateBasicEinfach_iban() throws Exception {
    String filename = PATH + "zugferd10/ZUGFeRD_1p0_BASIC_Einfach.pdf";
    
    XMLNode nodeIBAN = new XMLNode("ram:IBANID");
    PageRegion regionIBAN = createRegionIBAN();
    
    AssertThat.document(filename)
              .restrictedTo(FIRST_PAGE)
              .restrictedTo(regionIBAN)
              .hasText()
              .containingZugferdData(nodeIBAN)
    ;
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // Private method:
  //////////////////////////////////////////////////////////////////////////////
  
  private PageRegion createRegionIBAN() {
    int ibanUpperLeftX  =  80;  // in millimeter
    int ibanUpperLeftY  = 175;
    int ibanWidth       =  60;
    int ibanHeight      =   9;
    PageRegion region = new PageRegion(ibanUpperLeftX, ibanUpperLeftY, ibanWidth, ibanHeight);
    return region;
  }
  
}
