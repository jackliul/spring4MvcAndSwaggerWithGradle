#!/bin/sh
# sh /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle/tengda/deployFileServer.sh 
echo "start deploy fileServers"
cd /cygdrive/d/gitPro/pros/oms-back/file-server && 
gradle build -x test && cd /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle && gradle clean deployFileServer -DrealHost='' -DrealPassword='1FararFDe999()'