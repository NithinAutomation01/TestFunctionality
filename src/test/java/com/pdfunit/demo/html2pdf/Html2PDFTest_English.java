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
package com.pdfunit.demo.html2pdf;

import static com.pdfunit.Constants.ANY_PAGE;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pdfunit.AssertThat;
import com.pdfunit.WhitespaceProcessing;
import com.pdfunit.demo.html2pdf.util.WaitHelper;

/**
 * Example how to use PDFUnit.
 * <p>
 * This sample shows how to invoke an HTML page and then let it be rendered 
 * by the server to PDF and verify that content also appears in PDF.
 * </p>
 * 
 * @author Carsten Siedentop, February 2013
 */
public class Html2PDFTest_English {

  private WebDriver driver;
  private WebDriverWait webDriverWait;
  private long MAX_WAITTIME_10SECONDS = 10;

  @Test
  public void testHtml2PDFRenderer_WikipediaSeleniumEnglish() throws Exception {
    String urlWikipediaSelenium = "http://en.wikipedia.org/wiki/Selenium_(software)";
    driver.get(urlWikipediaSelenium);
    String expectedTitle = "Selenium (software) - Wikipedia, the free encyclopedia";
    ExpectedCondition<Boolean> pageIsLoaded = WaitHelper.createPageIsLoadedCondition(expectedTitle);
    webDriverWait.until(pageIsLoaded);
    
    String section1 = "History";
    String section2 = "Components";
    String section21 = "Selenium IDE";
    String section22 = "Selenium client API";
    String section23 = "Selenium Remote Control";
    String section24 = "Selenium WebDriver";
    String section25 = "Selenium Grid";
    String section3 = "The Selenium ecosystem";
    String section4 = "References";
    String section5 = "External links";

    assertLinkPresent(section1);
    assertLinkPresent(section2);
    assertLinkPresent(section21);
    assertLinkPresent(section22);
    assertLinkPresent(section23);
    assertLinkPresent(section24);
    assertLinkPresent(section25);
    assertLinkPresent(section3);
    assertLinkPresent(section4);
    assertLinkPresent(section5);
    
    String linkName = "Download as PDF";
    URL url = loadPDF(linkName);
    
    AssertThat.document(url)
              .restrictedTo(ANY_PAGE)
              .hasText()
              .containing(section1, WhitespaceProcessing.IGNORE)
              .containing(section2, WhitespaceProcessing.IGNORE)
              .containing(section21, WhitespaceProcessing.IGNORE)
              .containing(section22, WhitespaceProcessing.IGNORE)
              .containing(section23, WhitespaceProcessing.IGNORE)
              .containing(section24, WhitespaceProcessing.IGNORE)
              .containing(section25, WhitespaceProcessing.IGNORE)
              .containing(section3, WhitespaceProcessing.IGNORE)
              .containing(section4, WhitespaceProcessing.IGNORE)
              .containing(section5, WhitespaceProcessing.IGNORE)
    ;
  }

  private void assertLinkPresent(String partOfLinkText) {
    driver.findElement(By.xpath("//a[./span = '" + partOfLinkText + "']"));
  }

  private URL loadPDF(String linkName_LoadAsPDF) throws Exception {
    driver.findElement(By.linkText(linkName_LoadAsPDF)).click();
    String expectedTitle = "Rendering finished - Wikipedia, the free encyclopedia";
    ExpectedCondition<Boolean> pageIsLoaded = WaitHelper.createPageIsLoadedCondition(expectedTitle);
    webDriverWait.until(pageIsLoaded);
    WebElement element = driver.findElement(By.linkText("Download the file"));
    String hrefValue = element.getAttribute("href");
    URL url = new URL(hrefValue); 
    return url;
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }

  @Before
  public void createDriver() throws Exception {
    driver = new HtmlUnitDriver(); 
//    driver = new FirefoxDriver();  // Activate this line to use Firefox 
    webDriverWait = new WebDriverWait(driver, MAX_WAITTIME_10SECONDS); 
  }
  
}
