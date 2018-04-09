#!/bin/sh
echo "start deploy omsFrontV"
cd /cygdrive/d/gitPro/pros/oms-front_v && sed -i 's/localhost/47.106.123.189/g' config/index.js && npm install && npm run build && zip -r dist.zip dist && cd /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle && gradle clean delFrontZip