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
:: Convert Unicode content of the input file to hex code.
::
:: Make sure, all the libraries named below can be found in the classpath!

@echo off
setlocal
set CLASSPATH=./../*;%CLASSPATH%

set TOOL=com.pdfunit.tools.ConvertUnicodeToHex
echo ************************************************************** 
echo * define the path to your text file inside this script
echo ************************************************************** 
set IN_FILE=./file-with-unicode-content_for-demo-only.txt
set OUT_DIR=./../tmp

java -Dfile.encoding=UTF-8 %TOOL%  %IN_FILE%  %OUT_DIR% 
echo look for '_file-with-unicode-content_for-demo-only.out.txt' in %OUT_DIR% 

endlocal
