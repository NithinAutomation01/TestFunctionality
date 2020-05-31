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
package com.pdfunit.demo.newlogo;

import static com.pdfunit.AbstractTest.PATH;
import static com.pdfunit.Constants.EVERY_PAGE;
import static com.pdfunit.Constants.LAST_PAGE;
import static com.pdfunit.Constants.MILLIMETER;

import org.junit.Test;

import com.pdfunit.AssertThat;
import com.pdfunit.filter.page.PagesToUse;

/**
 * Example how to use PDFUnit.
 * <p>
 * Tests for the situation when two companies merge.
 * </p>
 * 
 * @author Carsten Siedentop, February 2013
 */
public class NewCompanyTests {

  /**
   * This example shows how to verify that a logo is visible on each page.
   */
  @Test
  public void verifyNewLogoOnEveryPage() throws Exception {
    String filename = PATH + "images/imagesWithSameImagesOnOnePage.pdf";
    String newLogoImage = PATH + "images/exported-image_ant-logo-PNG.png";
/*    String newLogoImage="C:\\Users\\user\\Pictures\\ant01.png";*/
    
    AssertThat.document(filename)
              .restrictedTo(EVERY_PAGE)
              .hasImage()
              .matching(newLogoImage)
    ; 
  }
  
  /**
   * This example shows how to verify that the new signature is used.
   */
  /*@Test  
  public void verifyNewSignatureOnLastPage() throws Exception {
    String filename = PATH + "images/imagesWithSameImagesOnOnePage.pdf";
    String newSignatureImage = PATH + "images/CEO-signature.png";

    AssertThat.document(filename)
              .restrictedTo(LAST_PAGE)
              .hasImage()
              .matching(newSignatureImage)
    ; 
  }

  *//**
   * This example verifies that a logo is on every page at the same position.
   *//*
  @Test  
  public void verifyLogoOnEachPage() throws Exception {
    String filename = PATH + "images/documentWithLogo.pdf";
    String logo = PATH + "images/logo.png";
    
    int upperLeftX = 135;
    int upperLeftY =  30;
    PagesToUse pages12 = PagesToUse.getPages(1);
    
    AssertThat.document(filename)
              .restrictedTo(pages12)
              .asRenderedPage()
              .isEqualToImage(upperLeftX, upperLeftY, MILLIMETER, logo)
    ;
  }*/

}
