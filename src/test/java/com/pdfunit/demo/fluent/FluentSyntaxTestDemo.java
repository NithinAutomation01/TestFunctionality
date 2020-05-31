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
package com.pdfunit.demo.fluent;

import static com.pdfunit.AbstractTest.PATH;
import static com.pdfunit.Constants.FIRST_PAGE;

import org.junit.Test;

import com.pdfunit.AssertThat;
import com.pdfunit.filter.page.PagesToUse;
import com.pdfunit.filter.region.PageRegion;

/**
 * Example how to use PDFUnit.
 * <p>
 * This file demonstrates the fluent design of the API.
 * </p>
 * 
 * @author Carsten Siedentop, January 2011
 */
public class FluentSyntaxTestDemo {

  @Test
  public void hasTextOnSpecifiedPages_FirstPage() throws Exception {
    String filename = PATH + "content/diverseContentOnMultiplePages.pdf";

    AssertThat.document(filename)
              .restrictedTo(FIRST_PAGE)
              .hasText() 
              .startingWith("PDFUnit")
              .containing("Content on first page.") 
              .endingWith("Page # 1 of 4")
    ;
  }
    
  @Test
  public void hasTextOnSpecifiedPages_IndividualPages() throws Exception {
    String filename = PATH + "content/diverseContentOnMultiplePages.pdf";
    PagesToUse pages123 = PagesToUse.getPages(1, 2, 3);

    AssertThat.document(filename)
              .restrictedTo(pages123)
              .hasText() 
              .containing("Content on")
    ;
  }
    
  @Test 
  public void hasTextOnFirstPage() throws Exception {
    String filename = PATH + "content/documentForTextClipping.pdf";
    
    int upperLeftX  =  17;  // in millimeter
    int upperLeftY  =  46;
    int width       =  60;
    int height      =   9; 
    
    PageRegion pageRegion = new PageRegion(upperLeftX, upperLeftY, width, height);
    
    AssertThat.document(filename)
              .restrictedTo(FIRST_PAGE)
              .restrictedTo(pageRegion)
              .hasText()
              .endingWith("page.")
              .startingWith("Content")
    ;
  }

  @Test
  public void hasPermissions() throws Exception {
    String filename = PATH + "content/diverseContentOnMultiplePages.pdf";
    
    AssertThat.document(filename)
              .hasPermission()
              .toPrintInHighQuality(true)
              .toExtractContent(true)
    ;
  }
  
  @Test
  public void hasEmbeddedFiles() throws Exception {
    String filename = PATH + "embeddedfiles/kubrick_dvds.pdf";
    String embeddedFileName1 = PATH + "embeddedfiles/0048254.jpg";
    String embeddedFileName2 = PATH + "embeddedfiles/0049406.jpg";
    String embeddedFileName3 = PATH + "embeddedfiles/0050825.jpg";
    
    AssertThat.document(filename)
              .hasEmbeddedFile().withContent(embeddedFileName1)
              .hasEmbeddedFile().withContent(embeddedFileName2)
              .hasEmbeddedFile().withContent(embeddedFileName3)
    ;
  }

}
