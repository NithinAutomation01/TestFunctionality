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
package com.pdfunit.demo.excel;

import static com.pdfunit.AbstractTest.PATH;

import org.junit.Test;

import com.pdfunit.AssertThat;
import com.pdfunit.rules.PDFValidationConstraints;

/**
 * This example shows, how PDFUnit can use constraints, that are 
 * defined in Excel files.
 * 
 * @author Carsten Siedentop, April 2016
 * @since 2016.05
 */
public class ExcelRulesTestDemo {

  @Test
  public void din5008_Letter5Pages() throws Exception {
    String filename = PATH + "excel-constraints/din5008-formA_brief-hochkant_5-seiten.pdf";
    String rulesAsExcelFile = PATH + "../excel-constraints/din5008-formA_brief-hochkant.xls";
    PDFValidationConstraints excelRules = new PDFValidationConstraints(rulesAsExcelFile);
    AssertThat.document(filename)
              .compliesWith()
              .constraints(excelRules)
    ;
  }
  
}
