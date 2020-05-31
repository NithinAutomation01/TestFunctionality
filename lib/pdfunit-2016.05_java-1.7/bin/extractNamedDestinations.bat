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
:: Extract information about named destinations in 
:: a PDF document into an XML file.
::
:: Make sure, all the libraries named below can be found in the classpath!

@echo off
setlocal
set CLASSPATH=./../*;%CLASSPATH%
set CLASSPATH=../../pdfbox-2.0.0/*;%CLASSPATH%
set CLASSPATH=./../lib/bouncycastle-jdk15on-153/*;%CLASSPATH%

set TOOL=com.pdfunit.tools.ExtractNamedDestinations
set OUT_DIR=./../tmp
echo ************************************************************** 
echo * define the path to your PDF inside this script
echo ************************************************************** 
set IN_FILE=./../example-files/bookmarksWithPdfOutline.pdf
set PASSWD=

java  %TOOL%  %IN_FILE%  %OUT_DIR%  %PASSWD%
echo a file with the prefix '_named-destinations_' was created in %OUT_DIR%

endlocal
