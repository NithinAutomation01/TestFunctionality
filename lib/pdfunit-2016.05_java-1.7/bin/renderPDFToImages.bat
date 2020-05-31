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
:: Render a complete PDF into image files. Each page as a file.
::
:: Make sure, all the libraries named below can be found in the classpath!

@echo off
setlocal

set CLASSPATH=./../*;%CLASSPATH%
set CLASSPATH=./../lib/pdfbox-2.0.0/*;%CLASSPATH%
set CLASSPATH=./../lib/bouncycastle-jdk15on-153/*;%CLASSPATH%

set TOOL=com.pdfunit.tools.RenderPdfToImages
set OUT_DIR=./../tmp
echo ************************************************************** 
echo * define the path to your PDF inside this script
echo ************************************************************** 
set IN_FILE=./../docs/pdfunit-2016.05_presentation.pdf
set PASSWD=

java  %TOOL%  %IN_FILE%  %OUT_DIR%  %PASSWD%
echo Each page of the PDF was rendered into a file with the prefix '_rendered_' in %OUT_DIR%.

endlocal
