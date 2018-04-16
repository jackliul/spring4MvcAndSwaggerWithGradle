#!/bin/sh
# && git pull 
# sh /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle/ceshi/deployOmsFrontV.sh
echo "start deploy omsFrontV"
cd /cygdrive/d/gitPro/pros/oms-front_v && 
npm install && npm run build && zip -r dist.zip dist && 
cd /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle && gradle clean delFrontZip -DrealHost='192.168.8.33' -DrealPassword='192.168.8.33'