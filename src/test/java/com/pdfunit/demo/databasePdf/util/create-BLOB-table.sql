--===========================================================================-
--                                                                           -
-- PDFUnit - Automated PDF Tests                                             -
--                                                                           -
-- Copyright (C) 2015 PDFUnit.com                                            -
--                                                                           -
-- This file is part of the commercial library PDFUnit.                      -
--                                                                           -
-- Legal information_____: http://pdfunit.com/license/                       -
-- Technical information_: http://pdfunit.com/howto/                         -
-- Contact for license___: license@pdfunit.com                               -
--                                                                           -
--===========================================================================-
-- Author: Carsten Siedentop                                                 -
--===========================================================================-

--
-- The table must exist befor the test starts
--
drop table blob_table;

CREATE TABLE blob_table (
    userID        INT            primary key
  , blob_column   BLOB
);
