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

/**
 * Class with constants.
 * 
 * @author Carsten Siedentop, Febrary 2013
 */
public class Constants {

  public static final String PATH = "src/test/java/com/pdfunit/demo/databasePdf/util/";
  public static final String FILENAME_PDF = PATH + "exampleForDatabaseTest.pdf";

  public static final String HSQLDB_SERVER_DRIVERNAME = "org.hsqldb.jdbcDriver";
  public static final String HSQLDB_SERVER_URL = "jdbc:hsqldb:hsql://localhost/demodb";
  public static final String HSQLDB_SERVER_USER = "sa";
  public static final String HSQLDB_SERVER_PASSWORD = "";
  public static final String HSQLDB_SERVER_SCHEMA = "PUBLIC";
  
  public static final String DEFAULT_DRIVERNAME = HSQLDB_SERVER_DRIVERNAME;
  public static final String DEFAULT_URL = HSQLDB_SERVER_URL;
  public static final String DEFAULT_USER = HSQLDB_SERVER_USER;
  public static final String DEFAULT_PASSWORD = HSQLDB_SERVER_PASSWORD;
  public static final String DEFAULT_SCHEMA = HSQLDB_SERVER_SCHEMA;

}
