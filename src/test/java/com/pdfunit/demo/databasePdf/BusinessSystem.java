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
package com.pdfunit.demo.databasePdf;

import static com.pdfunit.demo.databasePdf.util.Constants.FILENAME_PDF;

import com.pdfunit.demo.databasePdf.util.DBHelper;

/**
 * This class is a dummy for any business system.
 * It stores a PDF into a database.
 * 
 * @author Carsten Siedentop, Febrary 2013
 */
public class BusinessSystem {

  private static int userID;

  public static BusinessSystem newInstance(int userID) {
    BusinessSystem.userID = userID;
    return new BusinessSystem();
  }
  
  /**
   * This method simulates a business process which writes BLOB data into a database.
   */
  public void doSomethingImportantAndWritePDFToDatabase() throws Exception {
    // do some business staff ...
    DBHelper.insertPDFToDatabase(userID);
  }

  public String getPDFName() {
    return FILENAME_PDF;
  }

}
