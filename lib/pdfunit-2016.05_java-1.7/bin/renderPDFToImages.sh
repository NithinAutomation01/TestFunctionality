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
# Render a complete PDF into image files. Each page as a file.
#
# Make sure, all the libraries named below can be found in the classpath!
#
export CLASSPATH=$PWD/../*:$CLASSPATH
export CLASSPATH=$PWD/../../pdfbox-2.0.0/*:$CLASSPATH
export CLASSPATH=$PWD/../lib/bouncycastle-jdk15on-153/*:$CLASSPATH

export TOOL=com.pdfunit.tools.RenderPdfToImages
export OUT_DIR=$PWD/../tmp
echo ************************************************************** 
echo * define the path to your PDF inside this script
echo ************************************************************** 
export IN_FILE=$PWD/../docs/pdfunit-2016.05_presentation.pdf
export PASSWD=

java  $TOOL  $IN_FILE  $OUT_DIR  $PASSWD

echo Each page of the PDF was rendered into a file with the prefix '_rendered_' in $OUT_DIR.
