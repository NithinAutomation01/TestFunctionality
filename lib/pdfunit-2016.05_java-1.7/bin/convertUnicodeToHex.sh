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
# Convert Unicode content of the input file to hex code.
#
# Make sure, all the libraries named below can be found in the classpath!
#
export CLASSPATH=$PWD/../*:$CLASSPATH

export TOOL=com.pdfunit.tools.ConvertUnicodeToHex
export OUT_DIR=$PWD/../tmp
echo ************************************************************** 
echo * define the path to your text file inside this script
echo ************************************************************** 
set IN_FILE=$PWD/file-with-unicode-content_for-demo-only.txt

java -Dfile.encoding=UTF-8 $TOOL $IN_FILE $OUT_DIR
echo look for '_file-with-unicode-content_for-demo-only.out.txt' in $OUT_DIR
