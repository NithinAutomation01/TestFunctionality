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

import static com.pdfunit.demo.databasePdf.util.Constants.FILENAME_PDF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.dbunit.IDatabaseTester;

/**
 * This helper class provides methods to read and write to a
 * database. The class is used only for one special unit test.
 * 
 * @author Carsten Siedentop, Febrary 2013
 */
public class DBHelper {

  private static String tablename = "blob_table";
  private static String sqlSelect = "select blob_column from " + tablename + " where userID = %d";
  private static String sqlInsert = "update " + tablename + " set blob_column = ? where userID = %d";

  public static void insertPDFToDatabase(int userID) throws Exception {
    String insertPDF = String.format(sqlInsert, userID);
    IDatabaseTester jdbcTester = DBUnitUtils.getDefaultJdbcTester();

    Connection jdbcConnection = jdbcTester.getConnection().getConnection();
    PreparedStatement pstmt = jdbcConnection.prepareStatement(insertPDF);
    InputStream blobInputStream = new FileInputStream(FILENAME_PDF);
    pstmt.setBlob(1, blobInputStream);
    pstmt.execute();
    jdbcConnection.commit();
    pstmt.close();
  }

  public static InputStream readPdfFromDB(int userID) throws Exception {
    String selectPDF = String.format(sqlSelect, userID);
    IDatabaseTester jdbcTester = DBUnitUtils.getDefaultJdbcTester();
    Connection jdbcConnection = jdbcTester.getConnection().getConnection();
    Statement stmt = jdbcConnection.createStatement();
    ResultSet result = stmt.executeQuery(selectPDF);
    result.next();
    InputStream blobStream = result.getBinaryStream("blob_column");
    return blobStream;
  }


}
