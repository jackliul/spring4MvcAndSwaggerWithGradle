#!/bin/sh
# sh /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle/ceshi/deployFileServer.sh 
echo "start deploy fileServers"
cd /cygdrive/d/gitPro/pros/oms-back/file-server && 
gradle build -Denv=test -x test && cd /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle && gradle clean deployFileServer -DrealHost='192.168.8.33' -DrealPassword='ItVm905-3'