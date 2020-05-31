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

import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import com.pdfunit.demo.databasePdf.util.DBUnitUtils;

/**
 * Superclass for DB unittests holding setup() and tearDown() methods.
 * 
 * @author Carsten Siedentop, Febrary 2013
 */
public abstract class AbstractDBUnitTest {

  protected static IDatabaseTester jdbcTester;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    jdbcTester = DBUnitUtils.getDefaultJdbcTester();
    jdbcTester.setSetUpOperation(DatabaseOperation.REFRESH);
    jdbcTester.setTearDownOperation(DatabaseOperation.NONE);
  }

  @Before
  public void setUp() throws Exception {
    IDataSet dataset = setUpDataSet();
    jdbcTester.setDataSet(dataset);
    jdbcTester.onSetup();
  }

  @After
  public void tearDown() throws Exception {
    jdbcTester.onTearDown();
  }

  protected abstract IDataSet setUpDataSet() throws Exception;

}