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
# Starting the database HSQLDB (server mode).
#
 
export CURRENT_DIR=$PWD
export HSQLDB_HOME=$CURRENT_DIR/lib/hsqldb-2.3.4

java -cp $HSQLDB_HOME/hsqldb.jar org.hsqldb.server.Server -database.0 file:$CURRENT_DIR/dbdata/demodb -dbname.0 demodb
