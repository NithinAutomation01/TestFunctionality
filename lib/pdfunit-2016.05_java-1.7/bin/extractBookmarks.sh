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
# Extract bookmarks from a PDF document into an XML file.
#
# Make sure, all the libraries named below can be found in the classpath!
#
export CLASSPATH=$PWD/../*:$CLASSPATH
export CLASSPATH=$PWD/../../pdfbox-2.0.0/*:$CLASSPATH
export CLASSPATH=$PWD/../lib/bouncycastle-jdk15on-153/*:$CLASSPATH
#
export TOOL=com.pdfunit.tools.ExtractBookmarks
export OUT_DIR=$PWD/../tmp
echo ************************************************************** 
echo * define the path to your PDF inside this script
echo ************************************************************** 
export IN_FILE=$PWD/../docs/pdfunit-2016.05_presentation.pdf
export PASSWD=
#
java $TOOL  $IN_FILE  $OUT_DIR  $PASSWD
#
