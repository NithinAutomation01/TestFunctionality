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
# Extract information about signatures and certificates from 
# a PDF document as XML.
#
# Make sure, all the libraries named below can be found in the classpath!
#
export CLASSPATH=$PWD/../*:$CLASSPATH
export CLASSPATH=$PWD/../../pdfbox-2.0.0/*:$CLASSPATH
export CLASSPATH=$PWD/../lib/bouncycastle-jdk15on-153/*:$CLASSPATH
#
export TOOL=com.pdfunit.tools.ExtractSignatureInfo
export OUT_DIR=$PWD/../tmp
echo ************************************************************** 
echo * define the path to your PDF inside this script
echo ************************************************************** 
export IN_FILE=$PWD/../example-files/helloWorld_signed.pdf
export PASSWD=
#
java $TOOL  $IN_FILE  $OUT_DIR  $PASSWD

echo a file with the prefix '_signatureinfo_' was created in $OUT_DIR.
