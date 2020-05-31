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
package com.pdfunit.demo.textoverflow;

import static com.pdfunit.AbstractTest.PATH;

import org.junit.Test;

import com.pdfunit.AssertThat;
import com.pdfunit.errors.PDFUnitValidationException;

/**
 * Example how to use PDFUnit.
 * <p>
 * Sometimes when you fill in a field with text,
 * you want to know whether the complete text fits into the field.
 * </p>
 * 
 * @author Carsten Siedentop, February 2013
 */
public class TextFitsInFieldTest {

  private String filename = PATH + "acrofields/fieldSizeAndText.pdf";
  private String fieldnameLeftAlign_Fitting = "Textfield, text inside, align left:";
  private String fieldnameLeftAlignMultiline_NotFitting = "Textfield, too much text, multiline:";

  @Test
  public void noTextOverflow_Field_AlignLeft() throws Exception {
    AssertThat.document(filename)
              .hasField(fieldnameLeftAlign_Fitting)
              .withoutTextOverflow()
    ;
  }
  
  @Test(expected=PDFUnitValidationException.class)
  public void noTextOverflow_Field_AlignMultiline_ButTextOverflowsViewport() throws Exception {
    AssertThat.document(filename)
              .hasField(fieldnameLeftAlignMultiline_NotFitting)
              .withoutTextOverflow()
    ;
  }
  
  @Test(expected=PDFUnitValidationException.class)
  public void noTextOverflow_AllFields_ButTextOverflowsViewport() throws Exception {
    AssertThat.document(filename)
              .hasFields()
              .allWithoutTextOverflow()
    ;
  }
    
}
