#!/bin/sh
# git pull
# sh /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle/ceshi/deployOmsBack.sh
echo "start deploy omsBack"
cd /cygdrive/d/gitPro/pros/oms-back/oms-web && 
gradle build -Denv=test -x test && cd /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle && gradle clean deployOmsBack -DrealHost='192.168.8.33' -DrealPassword='ItVm905-3'