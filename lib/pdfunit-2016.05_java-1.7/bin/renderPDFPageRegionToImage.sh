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
# Render a part of a PDF page into an image file.
#
# Make sure, all the libraries named below can be found in the classpath!
#
export CLASSPATH=$PWD/../*:$CLASSPATH
export CLASSPATH=$PWD/../lib/aspectj-1.8.7/*:$CLASSPATH
export CLASSPATH=$PWD/../lib/commons-logging-1.2/*:$CLASSPATH
export CLASSPATH=$PWD/../lib/pdfbox-2.0.0/*:$CLASSPATH
export CLASSPATH=$PWD/../lib/pdfunit-2016.05/*:$CLASSPATH

export TOOL=com.pdfunit.tools.RenderPdfPageRegionToImage
export PAGENUMBER=1
export OUT_DIR=$PWD/../tmp
export IN_FILE=$PWD/../docs/pdfunit-2016.05_presentation.pdf
export PASSWD=

# All values must be Millimeter:
export UPPERLEFTX=45
export UPPERLEFTY=80
export WIDTH=190
export HEIGHT=20
export PAGEHEIGHT=210

java  $TOOL  $IN_FILE  $PAGENUMBER  $OUT_DIR  $UPPERLEFTX  $UPPERLEFTY  $WIDTH  $HEIGHT  $PAGEHEIGHT  $PASSWD
