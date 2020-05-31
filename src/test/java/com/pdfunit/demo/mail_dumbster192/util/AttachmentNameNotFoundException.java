/* ***************************************************************************
 *                                                                           *
 * PDFUnit - Automated PDF Tests                                             *
 *                                                                           *
 * Copyright (C) 2016 PDFUnit.com                                            *
 *                                                                           *
 * This file is part of the commercial library PDFUnit.                      *
 *                                                                           *
 * Legal information__: http://pdfunit.com/license/                          *
 * Manual_____________: http://pdfunit.com/en/download/index.html            *
 * Contact for license: license[at]pdfunit.com                               *
 *                                                                           *
 *************************************************************************** *
 * Author: Carsten Siedentop                                                 *
 *************************************************************************** */
package com.pdfunit.demo.mail_dumbster192.util;

/**
 * A simple class used in the context of unit tests.
 *
 * @author Carsten Siedentop, August 2014
 */
public class AttachmentNameNotFoundException extends Exception {
  
  private static final long serialVersionUID = 1L;

  public AttachmentNameNotFoundException(String message) {
    super(message);
  }
 
}
