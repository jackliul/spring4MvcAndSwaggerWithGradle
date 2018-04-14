#!/bin/sh
# && git pull 
# sh /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle/tengda/deployOmsFrontV.sh
echo "start deploy omsFrontV"
cd /cygdrive/d/gitPro/pros/oms-front_v && 
sed -i 's/192.168.8.33/47.89.10.238/g' src/utils/http.js && 
npm install && npm run build && zip -r dist.zip dist && 
cd /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle && gradle clean delFrontZip -DrealHost=' ' -DrealPassword='1FararFDe999()'