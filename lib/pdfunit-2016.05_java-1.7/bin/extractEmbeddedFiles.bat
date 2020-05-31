::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::                                                                           :
:: PDFUnit - Automated PDF Tests                                             :
::                                                                           :
:: Copyright (C) 2016 PDFUnit.com                                            :
::                                                                           :
:: This file is part of the commercial library PDFUnit.                      :
::                                                                           :
:: Legal information__: http://pdfunit.com/en/licenseinfo.html               :
:: Manual_____________: http://pdfunit.com/en/download/index.html            :
:: Contact for license: license[at]pdfunit.com                               :
::                                                                           :
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::
:: Extract embedded files from a PDF document. Each in a separate file.
::
:: Make sure, all the libraries named below can be found in the classpath!

@echo off
setlocal
set CLASSPATH=./../*;%CLASSPATH%
set CLASSPATH=../../pdfbox-2.0.0/*;%CLASSPATH%
set CLASSPATH=./../lib/bouncycastle-jdk15on-153/*;%CLASSPATH%

set TOOL=com.pdfunit.tools.ExtractEmbeddedFiles
set OUT_DIR=./../tmp
echo ************************************************************** 
echo * define the path to your PDF inside this script
echo ************************************************************** 
set IN_FILE=./../example-files/umsatzsteuervoranmeldung-2010.pdf
set PASSWD=

java  %TOOL%  %IN_FILE%  %OUT_DIR%  %PASSWD%
echo Extracted files in '%OUT_DIR%' have the name prefix '_embedded-file.out...'.
echo If the PDF does not have embedded files, no files will be created.

endlocal
