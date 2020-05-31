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
:: Author: Carsten Siedentop                                                 :
:: Date:   August 2013                                                       :
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::
:: Verify the installation of PDFUnit.
:: 

@echo off
setlocal

set CURRENTDIR=%~dp0
set PDFUNIT_HOME=%CURRENTDIR%/lib/pdfunit-2016.05_java-1.7

:: Change the installation directories depending on your situation:
set ANT_HOME=%PDFUNIT_HOME%/lib/ant-1.9.6
set ASPECTJ_HOME=%PDFUNIT_HOME%/lib/aspectj-1.8.7
set BOUNCYCASTLE_HOME=%PDFUNIT_HOME%/lib/bouncycastle-jdk15on-153
set COMMONSCOLLECTION_HOME=%PDFUNIT_HOME%/lib/commons-collections4-4.1
set COMMONSLOGGING_HOME=%PDFUNIT_HOME%/lib/commons-logging-1.2
set DBUNIT_HOME=%CURRENTDIR%/lib/dbunit-2.5.2
set DUMSTER1902_HOME=%CURRENTDIR%/lib/dumbster_fork-1.9.0.2
set HSQLDB_HOME=%CURRENTDIR%/lib/hsqldb-2.3.4
set HTMLUNIT_HOME=%CURRENTDIR%/lib/htmlunit-2.21
set JUNIT_HOME=%PDFUNIT_HOME%/lib/junit-4.12
set MAIL_HOME=%CURRENTDIR%/lib/javax-mail-api-1.5.5
set PDFBOX_HOME=%PDFUNIT_HOME%/lib/pdfbox-2.0.0
set POI_HOME=%PDFUNIT_HOME%/lib/poi-3.14
set POI_LIB_HOME=%PDFUNIT_HOME%/lib/poi-3.14/lib
set POI_OOXML_HOME=%PDFUNIT_HOME%/lib/poi-3.14/ooxml-lib
set SELENIUM_HOME=%CURRENTDIR%/lib/selenium-2.52.0
set SELENIUM_LIB_HOME=%CURRENTDIR%/lib/selenium-2.52.0/libs
set TESS4J_HOME=%PDFUNIT_HOME%/lib/tess4j-3.1.0
set VIP_HOME=%PDFUNIT_HOME%/lib/vip-1.0.0
set ZXING_HOME=%PDFUNIT_HOME%/lib/zxing-core-3.2.1

set CLASSPATH=
set CLASSPATH=%ANT_HOME%/*;%CLASSPATH%
set CLASSPATH=%ASPECTJ_HOME%/*;%CLASSPATH%
set CLASSPATH=%BOUNCYCASTLE_HOME%/*;%CLASSPATH%
set CLASSPATH=%COMMONSCOLLECTION_HOME%/*;%CLASSPATH%
set CLASSPATH=%COMMONSLOGGING_HOME%/*;%CLASSPATH%
set CLASSPATH=%DBUNIT_HOME%/*;%CLASSPATH%
set CLASSPATH=%DUMSTER1902_HOME%/*;%CLASSPATH%
set CLASSPATH=%HSQLDB_HOME%/*;%CLASSPATH%
set CLASSPATH=%HTMLUNIT_HOME%/lib/*;%CLASSPATH%
set CLASSPATH=%JUNIT_HOME%/*;%CLASSPATH%
set CLASSPATH=%MAIL_HOME%/*;%CLASSPATH%
set CLASSPATH=%PDFBOX_HOME%/*;%CLASSPATH%
set CLASSPATH=%POI_HOME%/*;%CLASSPATH%
set CLASSPATH=%POI_LIB_HOME%/*;%CLASSPATH%
set CLASSPATH=%POI_OOXML_HOME%/*;%CLASSPATH%
set CLASSPATH=%SELENIUM_HOME%/*;%CLASSPATH%
set CLASSPATH=%SELENIUM_LIB_HOME%/*;%CLASSPATH%
set CLASSPATH=%TESS4J_HOME%/*;%CLASSPATH%
set CLASSPATH=%TESS4J_HOME%/lib/*;%CLASSPATH%
set CLASSPATH=%VIP_HOME%/*;%CLASSPATH%
set CLASSPATH=%ZXING_HOME%/*;%CLASSPATH%

:: The folder of PDFUnit-Java:
set CLASSPATH=%PDFUNIT_HOME%;%CLASSPATH%
:: The JAR files of PDFUnit-Java:
set CLASSPATH=%PDFUNIT_HOME%/*;%CLASSPATH%

:: Run installation verification:
java org.verifyinstallation.VIPMain --in verifyInstallation.vip  --out verifyInstallation_result.html

endlocal