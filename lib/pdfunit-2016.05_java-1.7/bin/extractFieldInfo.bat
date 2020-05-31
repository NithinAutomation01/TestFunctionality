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
:: Extract formular fields from a PDF document into an XML file.
::
:: Make sure, all the libraries named below can be found in the classpath!

@echo off
setlocal
set CLASSPATH=./../*;%CLASSPATH%
set CLASSPATH=./../lib/aspectj-1.8.7/*;%CLASSPATH%
set CLASSPATH=./../lib/commons-logging-1.2/*;%CLASSPATH%
set CLASSPATH=./../lib/commons-collections4-4.1/*;%CLASSPATH%
set CLASSPATH=./../lib/pdfbox-2.0.0/*;%CLASSPATH%
set CLASSPATH=./../lib/bouncycastle-jdk15on-153/*;%CLASSPATH%

set TOOL=com.pdfunit.tools.ExtractFieldInfo
set OUT_DIR=./../tmp
echo ************************************************************** 
echo * define the path to your PDF inside this script
echo ************************************************************** 
set IN_FILE=./../example-files/javaScriptForFields.pdf
set PASSWD=

java  %TOOL%  %IN_FILE%  %OUT_DIR%  %PASSWD%
echo a file with the prefix '_fieldinfo_' was created in %OUT_DIR%

endlocal
