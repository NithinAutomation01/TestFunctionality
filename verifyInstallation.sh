#!/bin/bash
###############################################################################
#                                                                             #
# PDFUnit - Automated PDF Tests                                               #
#                                                                             #
# Copyright (C) 2016 PDFUnit.com                                              #
#                                                                             #
# This file is part of the commercial library PDFUnit.                        #
#                                                                             #
# Legal information__: http://pdfunit.com/en/licenseinfo.html                 #
# Manual_____________: http://pdfunit.com/en/download/index.html              #
# Contact for license: license[at]pdfunit.com                                 #
#                                                                             #
###############################################################################
# Author: Carsten Siedentop                                                   #
# Date:   August 2013                                                         #
###############################################################################
#
# Verify the installation of PDFUnit.
#
export PDFUNIT_HOME=$PWD/lib/pdfunit-2016.05_java-1.7
#
#
# Change the installation directories depending on your situation:
export ANT_HOME=$PDFUNIT_HOME/lib/ant-1.9.6
export ASPECTJ_HOME=$PDFUNIT_HOME/lib/aspectj-1.8.7
export BOUNCYCASTLE_HOME=$PDFUNIT_HOME/lib/bouncycastle-jdk15on-153
export COMMONSCOLLECTION_HOME=$PDFUNIT_HOME/lib/commons-collections4-4.1
export COMMONSLOGGING_HOME=$PDFUNIT_HOME/lib/commons-logging-1.2
export DBUNIT_HOME=$PWD/lib/dbunit-2.5.2
export DUMBSTER1902_HOME=$PWD/lib/dumbster_fork-1.9.0.2
export HSQLDB_HOME=$PWD/lib/hsqldb-2.3.4
export HTMLUNIT_HOME=$PWD/lib/htmlunit-2.21
export JUNIT_HOME=$PWD/lib/junit-4.12
export MAIL_HOME=$PWD/lib/javax-mail-api-1.5.5
export PDFBOX_HOME=$PDFUNIT_HOME/lib/pdfbox-2.0.0
export POI_HOME=$PDFUNIT_HOME/lib/poi-3.14
export POI_LIB_HOME=$PDFUNIT_HOME/lib/poi-3.14/lib
export POI_OOXML_HOME=$PDFUNIT_HOME/lib/poi-3.14/ooxml-lib
export SELENIUM_HOME=$PWD/lib/selenium-2.52.0
export SELENIUM_LIB_HOME=$PWD/lib/selenium-2.52.0/libs
export TESS4J_HOME=$PDFUNIT_HOME/lib/tess4j-3.1.0
export VIP_HOME=$PDFUNIT_HOME/lib/vip-1.0.0
export ZXING_HOME=$PDFUNIT_HOME/lib/zxing-core-3.2.1

export CLASSPATH=
export CLASSPATH=$ANT_HOME/*:$CLASSPATH
export CLASSPATH=$ASPECTJ_HOME/*:$CLASSPATH
export CLASSPATH=$BOUNCYCASTLE_HOME/*:$CLASSPATH
export CLASSPATH=$COMMONSCOLLECTION_HOME/*;$CLASSPATH
export CLASSPATH=$COMMONSLOGGING_HOME/*:$CLASSPATH
export CLASSPATH=$DBUNIT_HOME/*:$CLASSPATH
export CLASSPATH=$DUMSTER1902_HOME/*:$CLASSPATH
export CLASSPATH=$HSQLDB_HOME/*:$CLASSPATH
export CLASSPATH=$HTMLUNIT_HOME/*:$CLASSPATH
export CLASSPATH=$JUNIT_HOME/*:$CLASSPATH
export CLASSPATH=$MAIL_HOME/*:$CLASSPATH
export CLASSPATH=$PDFBOX_HOME/*:$CLASSPATH
export CLASSPATH=$POI_HOME/*:$CLASSPATH
export CLASSPATH=$POI_LIB_HOME/*:$CLASSPATH
export CLASSPATH=$POI_OOXML_HOME/*:$CLASSPATH
export CLASSPATH=$SELENIUM_HOME/*;$CLASSPATH
export CLASSPATH=$SELENIUM_LIB_HOME/*;$CLASSPATH
export CLASSPATH=$TESS4J_HOME/*;$CLASSPATH
export CLASSPATH=$TESS4J_HOME/lib/*;$CLASSPATH
export CLASSPATH=$VIP_HOME/*;$CLASSPATH
export CLASSPATH=$ZXING_HOME/*;$CLASSPATH

# The folder of PDFUnit-Java:
export CLASSPATH=$PDFUNIT_HOME:$CLASSPATH

# The JAR files of PDFUnit-Java:
export CLASSPATH=$PDFUNIT_HOME/*:$CLASSPATH


# Run installation verification:
java org.verifyinstallation.VIPMain --in verifyInstallation.vip  --out verifyInstallation_result.html
