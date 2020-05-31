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
:: Extract all images of a PDF document into a PNG file for each image.
::
:: Make sure, all the libraries named below can be found in the classpath!

@echo off
setlocal
set CLASSPATH=./../*;%CLASSPATH%
set CLASSPATH=./../lib/pdfbox-2.0.0/*;%CLASSPATH%

set TOOL=com.pdfunit.tools.ExtractImages
set OUT_DIR=./../tmp
echo ************************************************************** 
echo * define the path to your PDF inside this script
echo ************************************************************** 
set IN_FILE=./../docs/pdfunit-2016.05_presentation.pdf
set PASSWD=

java  %TOOL%  %IN_FILE%  %OUT_DIR%  %PASSWD%
echo image files with the extension '.out.png' have been created in %OUT_DIR%

endlocal
