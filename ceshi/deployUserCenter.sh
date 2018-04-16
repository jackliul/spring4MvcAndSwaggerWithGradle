#!/bin/sh
# sh /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle/ceshi/deployUserCenter.sh 
echo "start deploy userCenter"
cd /cygdrive/d/gitPro/pros/user-center &&
gradle build -Denv=test -x test && cd /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle && gradle clean deployUserCenter  -DrealHost='192.168.8.33' -DrealPassword='ItVm905-3'