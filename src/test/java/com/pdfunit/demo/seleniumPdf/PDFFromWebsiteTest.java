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
package com.pdfunit.demo.seleniumPdf;

import static com.pdfunit.Constants.FIRST_PAGE;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.pdfunit.AssertThat;
import com.pdfunit.errors.PDFUnitValidationException;
import com.pdfunit.validators.DocumentValidator;

/**
 * Example how to use PDFUnit.
 * <p>
 * This sample shows how to test a PDF document with Selenium and PDFUnit.
 * </p>
 * 
 * @author Carsten Siedentop, March 2012
 */
public class PDFFromWebsiteTest {

  private WebDriver driver;

  @Test
  public void verifyAuthor_PDFLoaded_ByURL() throws Exception {
    String pdfURL = "http://www.unicode.org/charts/PDF/U0000.pdf";
    URL url = new URL(pdfURL); 
    String expectedAuthor = "The Unicode Consortium";
    String expectedTitle  = "The Unicode Standard, Version 8.0";
    AssertThat.document(url)
              .hasAuthor().equalsTo(expectedAuthor)
              .hasTitle().equalsTo(expectedTitle)
    ;
  }

  @Test(expected=PDFUnitValidationException.class)
  public void verifyAuthor_PDFLoaded_ByURL_ExpectedToFail() throws Exception {
    String pdfURL = "http://www.unicode.org/charts/PDF/U0000.pdf";
    URL url = new URL(pdfURL); 
    String expectedAuthor = "wrong_author_intended";
    AssertThat.document(url)
              .hasAuthor()
              .equalsTo(expectedAuthor)
    ;
  }
  
  @Test
  public void verifyPDF_LoadedBySeleniumWebdriver() throws Exception {
    // arrange, navigate to web site:
    String startURL = "http://www.unicode.org/charts/";
    driver.get(startURL);
    WebElement element = driver.findElement(By.linkText("Basic Latin (ASCII)"));
    String hrefValue = element.getAttribute("href");
    
    // act, load PDF from web site:
    URL url = new URL(hrefValue); // If the link is dead, then a 'java.io.FileNotFoundException' will be thrown. 
    
    // assert:
    String expectedTitle  = "The Unicode Standard, Version 8.0";
    
    DocumentValidator documentValidator = AssertThat.document(url);
    
    documentValidator.hasTitle().equalsTo(expectedTitle);
    documentValidator.restrictedTo(FIRST_PAGE)
                     .hasText().containing("0000", "007F");
  }
  
  @Before
  public void createDriver() throws Exception {
    driver = new HtmlUnitDriver(); 
//  driver = new FirefoxDriver(); // Activate this to use Firefox
  }
  
  @After
  public void closeAll() throws Exception {
    driver.close();
  }

}
