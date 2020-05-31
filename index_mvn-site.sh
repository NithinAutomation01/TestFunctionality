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
# Starting the maven project site of this project with Firefox.
#
#
export CURRENT_DIR=$PWD

firefox $CURRENT_DIR/target/site/index.html

