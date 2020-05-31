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
package com.pdfunit.demo.databasePdf.util;

import static com.pdfunit.demo.databasePdf.util.Constants.DEFAULT_DRIVERNAME;
import static com.pdfunit.demo.databasePdf.util.Constants.DEFAULT_PASSWORD;
import static com.pdfunit.demo.databasePdf.util.Constants.DEFAULT_SCHEMA;
import static com.pdfunit.demo.databasePdf.util.Constants.DEFAULT_URL;
import static com.pdfunit.demo.databasePdf.util.Constants.DEFAULT_USER;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

/**
 * Helper class for DB accesss.
 * 
 * @author Carsten Siedentop, Febrary 2013
 */
public class DBUnitUtils {

  private static void configureConnection(IDatabaseConnection con) throws SQLException {
    DatabaseConfig config = con.getConfig();
    config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());
    config.setProperty(DatabaseConfig.FEATURE_BATCHED_STATEMENTS, true);
  }
  
  public static synchronized IDatabaseTester getDefaultJdbcTester() throws Exception {
    JdbcDatabaseTester jdbcTest = new JdbcDatabaseTester(DEFAULT_DRIVERNAME, DEFAULT_URL, DEFAULT_USER, DEFAULT_PASSWORD, DEFAULT_SCHEMA);
    jdbcTest.setSetUpOperation(DatabaseOperation.REFRESH);
    jdbcTest.setTearDownOperation(DatabaseOperation.NONE);
    IDatabaseConnection con = jdbcTest.getConnection();
    configureConnection(con);
    return jdbcTest;
  }

  public static IDataSet readFlatDataSet(String fileName) throws MalformedURLException, DataSetException {
    FlatXmlDataSetBuilder dataSetBuilder = new FlatXmlDataSetBuilder();
    dataSetBuilder.setCaseSensitiveTableNames(false);
    dataSetBuilder.setColumnSensing(true);
    File file = new File(fileName);
    FlatXmlDataSet loadedDataSet = dataSetBuilder.build(file);
    return loadedDataSet;
  }

}
