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
# Extract all images of a PDF document into a PNG file for each image.
#
# Make sure, all the libraries named below can be found in the classpath!
#
export CLASSPATH=$PWD/../*:$CLASSPATH
export CLASSPATH=$PWD/../lib/pdfbox-2.0.0/*:$CLASSPATH
#
export TOOL=com.pdfunit.tools.ExtractImages
export OUT_DIR=$PWD/../tmp
echo ************************************************************** 
echo * define the path to your PDF inside this script
echo ************************************************************** 
export IN_FILE=$PWD/../docs/pdfunit-2016.05_presentation.pdf
export PASSWD=
#
java $TOOL  $IN_FILE  $OUT_DIR  $PASSWD

echo image files with the extension '.out.png' have been created in $OUT_DIR
