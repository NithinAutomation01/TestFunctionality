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

import static com.pdfunit.demo.databasePdf.util.Constants.PATH;

import java.io.FileInputStream;
import java.io.InputStream;

import org.dbunit.dataset.IDataSet;
import org.junit.Test;

import com.pdfunit.AssertThat;
import com.pdfunit.demo.databasePdf.util.DBHelper;
import com.pdfunit.demo.databasePdf.util.DBUnitUtils;

/**
 * This examples shows how to PDF documents, 
 * which are sotred into a database by a business process,
 * using PDFUnit.
 * 
 * @author Carsten Siedentop, Febrary 2013
 */
public class PDFInDatabaseTest extends AbstractDBUnitTest {

  private String initDataFilename = PATH + "blob_init.xml";

  /**
   * This tests validates a PDF document that a business program has stored
   * as a BLOB into a database.
   */
  @Test
  public void verifyPDFDataFromDatabase() throws Exception {
    // Arrange (continued):
    int userID = 4711;
    BusinessSystem myBusinessSystem = BusinessSystem.newInstance(userID);

    // Act:
    myBusinessSystem.doSomethingImportantAndWritePDFToDatabase();
    
    // Assert - compare the data of the DB with the data of the original file:
    String referencePdfName = myBusinessSystem.getPDFName();
    InputStream actualPdfFromDB = DBHelper.readPdfFromDB(userID);
    FileInputStream pdfReferenceFromFile = new FileInputStream(referencePdfName);

    AssertThat.document(actualPdfFromDB)
              .and(pdfReferenceFromFile)
              .haveSameText()
              .haveSameAppearance()
    ;

    actualPdfFromDB.close();
    pdfReferenceFromFile.close();
  }

  @Override // Arrange for all tests in this class:
  protected IDataSet setUpDataSet() throws Exception {
    IDataSet dataset = DBUnitUtils.readFlatDataSet(initDataFilename);
    return dataset;
  }

}
