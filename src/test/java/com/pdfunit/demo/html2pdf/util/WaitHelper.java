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
package com.pdfunit.demo.html2pdf.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * A simple class to create Condition instances for Selenium tests. 
 *
 * @author Carsten Siedentop, February 2013
 */
public class WaitHelper {

  public static ExpectedCondition<Boolean> createPageIsLoadedCondition(final String expectedTitle) {
    ExpectedCondition<Boolean> pageLoaded = new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver driver) {
        String actualTitleLowerCase = driver.getTitle().toLowerCase().trim();
        String expectedTitleLowerCase = expectedTitle.toLowerCase().trim();
        boolean result = actualTitleLowerCase.startsWith(expectedTitleLowerCase);
        return result;
      }
    };
    return pageLoaded;
  }

  public static ExpectedCondition<Boolean> createElementIsLoadedCondition(final By expectedElement) {
    ExpectedCondition<Boolean> pageLoaded = new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver driver) {
        try {
          driver.findElement(expectedElement);
          return true;
        } catch (NoSuchElementException e) {
          return false;
        }
      }
    };
    return pageLoaded;
  }
  
}
