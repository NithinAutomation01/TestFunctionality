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
package com.pdfunit;

import org.junit.Test;

import com.pdfunit.AssertThat;

/**
 * This class verifies the installation and writes a log to System.out.
 * 
 * @author Carsten Siedentop, April 2013
 */
public class _VerifyInstallation {

  @Test
  public void verifyInstallation() throws Exception {
    String verificationFile = "verifyInstallation.vip";
    AssertThat.installationIsClean(verificationFile);
  }
  
}
