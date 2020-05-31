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
package com.pdfunit.demo.multipledocuments;

import static com.pdfunit.AbstractTest.PATH;
import static com.pdfunit.Constants.FIRST_PAGE;

import java.util.List;
import java.util.Vector;

import org.junit.Test;

import com.pdfunit.AssertThat;
import com.pdfunit.validators.DocumentValidator;

/**
 * Example how to use PDFUnit.
 * Each method has a short description.
 * 
 * @author Carsten Siedentop, September 2014
 * @since 2014.06
 */
public class MultipleDocumentsTest {

  /**
   * This method shows how multiple documents can be tested with 
   * one test method.
   */
  @Test
  public void textInMultipleDocuments_handMade() throws Exception {
    String expectedDate = "28.09.2014";
    String expectedDocumentID = "XX-123";
    
    String fileName1 = PATH + "multipleDocuments/document_en.pdf";
    String fileName2 = PATH + "multipleDocuments/document_es.pdf";
    String fileName3 = PATH + "multipleDocuments/document_de.pdf";
    
    DocumentValidator validatorDocument1 = AssertThat.document(fileName1);
    DocumentValidator validatorDocument2 = AssertThat.document(fileName2);
    DocumentValidator validatorDocument3 = AssertThat.document(fileName3);

    List<DocumentValidator> allValidators = new Vector<DocumentValidator>();
    allValidators.add(validatorDocument1);
    allValidators.add(validatorDocument2);
    allValidators.add(validatorDocument3);
    
    for (DocumentValidator document : allValidators) {
      document.restrictedTo(FIRST_PAGE)
              .hasText()
              .containing(expectedDate)
              .containing(expectedDocumentID)
      ;
    }
  }
  
  @Test
  public void textInMultipleDocuments_simpler() throws Exception {
    String expectedDate = "28.09.2014";
    String expectedDocumentID = "XX-123";
    
    String fileName1 = PATH + "multipleDocuments/document_en.pdf";
    String fileName2 = PATH + "multipleDocuments/document_es.pdf";
    String fileName3 = PATH + "multipleDocuments/document_de.pdf";
    
    String fileNames[] = {fileName1, fileName2, fileName3};
    AssertThat.eachDocument(fileNames)
              .hasText()
              .containing(expectedDate)
              .containing(expectedDocumentID)
    ;
  }
  
}

