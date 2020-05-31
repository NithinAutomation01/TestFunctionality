##############################################################################
#                                                                            #
#  PDFUnit - Automated PDF Tests                                             #
#                                                                            #
#  Copyright (C) 2016 PDFUnit.com                                            #
#                                                                            #
#  This file is part of the commercial library PDFUnit.                      #
#                                                                            #
#  Legal information__: http://pdfunit.com/en/licenseinfo.html               #
#  Manual_____________: http://pdfunit.com/en/download/index.html            #
#  Contact for license: license[at]pdfunit.com                               #
#                                                                            #
##############################################################################
#  Author: Carsten Siedentop                                                 #
############################################################################## 
 
The example in this folder implements the following scenario:

 - A business function writes a PDF into a database (as BLOB).
 - A test validates that this function works correct.
   The test reads the PDF and compares it with a master PDF,.
 - To be reproducible, the test has to reset the DB before every test.

Technical environment:
 - Any JDBC database has to be started. This test uses HSQLDB.
 - The table (see ./util/create-BLOB-table.sql) has to be created before the test.