#!/bin/bash
#############################################################################
#                                                                           #
# VIP - Verify Installation Program                                         #
#                                                                           #
# Copyright (C) 2013 www.verify-installation.org                            #
#                                                                           #
# This file is part of the OpenSource Project VIP                           #
#                                                                           #
# Documentation_________: http://verify-installation.org/howto/             #
# Contact_______________: info@verify-installation.org                      #
#                                                                           #
#############################################################################
#
# Verifying the installation of VIP itself.
#
#############################################################################
#
# Change the installation directories to your situation:
export CLASSPATH=
export CLASSPATH=./vip-1.0.0.jar:$CLASSPATH

#
# Run installation verification:
java org.verifyinstallation.VIPMain --in vip-self.vip  --out vip-self.out.html

