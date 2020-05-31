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
:: Render a part of a PDF page into an image file.
::
:: Make sure, all the libraries named below can be found in the classpath!

@echo off
setlocal
set CLASSPATH=./../*;%CLASSPATH%
set CLASSPATH=./../lib/aspectj-1.8.7/*;%CLASSPATH%
set CLASSPATH=./../lib/commons-logging-1.2/*;%CLASSPATH%
set CLASSPATH=./../lib/pdfbox-2.0.0/*;%CLASSPATH%
set CLASSPATH=./../lib/pdfunit-2016.05/*;%CLASSPATH%

set TOOL=com.pdfunit.tools.RenderPdfPageRegionToImage
set PAGENUMBER=1
set OUT_DIR=./../tmp
echo ************************************************************** 
echo * define the path to your PDF inside this script
echo ************************************************************** 
set IN_FILE=./../docs/pdfunit-2016.05_presentation.pdf
set PASSWD=

:: All values must be millimeter:
set UPPERLEFTX=45
set UPPERLEFTY=80
set WIDTH=190
set HEIGHT=20
set PAGEHEIGHT=210

java  %TOOL%  %IN_FILE%  %PAGENUMBER%  %OUT_DIR%  %UPPERLEFTX%  %UPPERLEFTY%  %WIDTH%  %HEIGHT%  %PAGEHEIGHT%  %PASSWD%
endlocal
