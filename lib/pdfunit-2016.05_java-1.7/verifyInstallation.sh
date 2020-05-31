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
#
# Verify the installation of PDFUnit.
#
#
export PDFUNIT_HOME=$PWD
#
# Change the installation directories depending on your situation:
#
export ASPECTJ_HOME=$PDFUNIT_HOME/lib/aspectj-1.8.7
export BOUNCYCASTLE_HOME=$PDFUNIT_HOME/lib/bouncycastle-jdk15on-153
export COMMONSCOLLECTIONS_HOME=$PDFUNIT_HOME/lib/commons-collections4-4.1
export COMMONSLOGGING_HOME=$PDFUNIT_HOME/lib/commons-logging-1.2
export PDFBOX_HOME=$PWD/lib/pdfbox-2.0.0
export POI_HOME=$PDFUNIT_HOME/lib/poi-3.14
export TESS4J_HOME=$PDFUNIT_HOME/lib/tess4j-3.1.0
export VIP_HOME=$PWD/lib/vip-1.0.0
export ZXING_HOME=$PDFUNIT_HOME/lib/zxing-core-3.2.1
#
export CLASSPATH=
export CLASSPATH=$ASPECTJ_HOME/*:$CLASSPATH
export CLASSPATH=$BOUNCYCASTLE_HOME/*:$CLASSPATH
export CLASSPATH=$COMMONSCOLLECTIONS_HOME/*:$CLASSPATH
export CLASSPATH=$COMMONSLOGGING_HOME/*:$CLASSPATH
export CLASSPATH=$PDFBOX_HOME/*:$CLASSPATH
export CLASSPATH=$POI_HOME/*:$CLASSPATH
export CLASSPATH=$POI_HOME/lib/*:$CLASSPATH
export CLASSPATH=$POI_HOME/ooxml-lib/*:$CLASSPATH
export CLASSPATH=$TESS4J_HOME/*:$CLASSPATH
export CLASSPATH=$TESS4J_HOME/lib/*:$CLASSPATH
export CLASSPATH=$VIP_HOME/*:$CLASSPATH
export CLASSPATH=$ZXING_HOME/*:$CLASSPATH
#
# The folder of PDFUnit-Java:
export CLASSPATH=$PDFUNIT_HOME:$CLASSPATH
# The JAR files of PDFUnit-Java:
export CLASSPATH=$PDFUNIT_HOME/*:$CLASSPATH
#
# Run installation verification:
java org.verifyinstallation.VIPMain --in verifyInstallation.vip  --out verifyInstallation_result.html
