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
import static org.junit.Assert.assertEquals;

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
public class Html2PDFTest_German {

  private WebDriver driver;
  private WebDriverWait webDriverWait;
  private long MAX_WAITTIME_10SECONDS = 10;

  @Test
  public void testHtml2PDFRenderer_WikipediaSeleniumGerman() throws Exception {
    String urlWikipediaSelenium = "http://de.wikipedia.org/wiki/Selenium";
    driver.get(urlWikipediaSelenium);
    String expectedTitle = "Selenium – Wikipedia";
    String actualTitle = driver.getTitle();
    System.out.println(actualTitle);
    ExpectedCondition<Boolean> pageIsLoaded = WaitHelper.createPageIsLoadedCondition(expectedTitle);
    webDriverWait.until(pageIsLoaded);

    String section1 = "Selenium Core";
    String section2 = "Selenium IDE";
    String section3 = "Selenium Remote Control (RC)";
    String section4 = "Selenium WebDriver";
    String section5 = "Selenium Grid";
    String section6 = "Literatur";
    String section7 = "Einzelnachweise";
    String section8 = "Weblinks";

    assertLinkPresent(section1);
    assertLinkPresent(section2);
    assertLinkPresent(section3);
    assertLinkPresent(section4);
    assertLinkPresent(section5);
    assertLinkPresent(section6);
    assertLinkPresent(section7);
    assertLinkPresent(section8);
    
    String linkName = "Als PDF herunterladen";
    URL url = loadPDF(linkName);
    
    AssertThat.document(url)
              .restrictedTo(ANY_PAGE)
              .hasText()
              .containing(section1, WhitespaceProcessing.IGNORE)
              .containing(section2, WhitespaceProcessing.IGNORE)
              .containing(section3, WhitespaceProcessing.IGNORE)
              .containing(section4, WhitespaceProcessing.IGNORE)
              .containing(section5, WhitespaceProcessing.IGNORE)
              .containing(section6, WhitespaceProcessing.IGNORE)
              .containing(section7, WhitespaceProcessing.IGNORE)
              .containing(section8, WhitespaceProcessing.IGNORE)
    ;
  }

  private void assertLinkPresent(String partOfLinkText) {
    driver.findElement(By.xpath("//a[./span = '" + partOfLinkText + "']"));
  }

  private URL loadPDF(String linkName_LoadAsPDF) throws Exception {
    driver.findElement(By.linkText(linkName_LoadAsPDF)).click();
    String expectedTitle = "Fertig erstellt \u2013 Wikipedia";
    ExpectedCondition<Boolean> pageIsLoaded = WaitHelper.createPageIsLoadedCondition(expectedTitle);
    webDriverWait.until(pageIsLoaded);
    assertEquals(expectedTitle, driver.getTitle());
    WebElement element = driver.findElement(By.linkText("Dokument herunterladen"));
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
//  driver = new FirefoxDriver(); // Activate this to use Firefox
    webDriverWait = new WebDriverWait(driver, MAX_WAITTIME_10SECONDS); 
  }
  
}
