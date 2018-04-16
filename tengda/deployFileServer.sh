#!/bin/sh
# sh /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle/tengda/deployFileServer.sh 
echo "start deploy fileServers"
cd /cygdrive/d/gitPro/pros/oms-back/file-server && 
sed -i 's/192.168.8.31/172.31.147.122/g' src/main/resources/test/jdbc.properties && sed -i 's/Root!111/123@QWErty/g' src/main/resources/test/jdbc.properties  &&
sed -i 's/192.168.8.32/172.31.147.124/g' src/main/resources/test/redis.properties && sed -i 's/6379/6000/g' src/main/resources/test/redis.properties  &&  sed -i 's/na#12%78P/123@QWErty/g' src/main/resources/test/redis.properties  &&
gradle build -Denv=test -x test && cd /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle && gradle clean deployFileServer -DrealHost='47.89.10.238' -DrealPassword='FararFDe999()'