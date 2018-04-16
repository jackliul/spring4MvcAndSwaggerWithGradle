#!/bin/sh
# git pull
# sh /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle/tengda/deployOmsBack.sh
echo "start deploy omsBack"
cd /cygdrive/d/gitPro/pros/oms-back/oms-web && 
sed -i 's/192.168.8.31/172.31.147.122/g' src/main/resources/dev/jdbc.properties && sed -i 's/Root!111/123@QWErty/g' src/main/resources/dev/jdbc.properties  &&
sed -i 's/192.168.8.32/172.31.147.124/g' src/main/resources/dev/redis.properties && sed -i 's/6379/6000/g' src/main/resources/dev/redis.properties  &&  sed -i 's/na#12%78P/123@QWErty/g' src/main/resources/dev/redis.properties  &&
gradle build -x test && cd /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle && gradle clean deployOmsBack -DrealHost='47.89.10.238' -DrealPassword='FararFDe999()'