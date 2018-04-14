#!/bin/sh
# sh /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle/tengda/deployUserCenter.sh 
echo "start deploy userCenter"
cd /cygdrive/d/gitPro/pros/user-center &&
sed -i 's/192.168.8.31/172.31.147.122/g' src/main/resources/dev/jdbc.properties && sed -i 's/Root!111/123@QWErty/g' src/main/resources/dev/jdbc.properties  &&
sed -i 's/192.168.8.32/172.31.147.124/g' src/main/resources/dev/redis.properties && sed -i 's/6379/6000/g' src/main/resources/dev/redis.properties &&  sed -i 's/na#12%78P/123@QWErty/g' src/main/resources/dev/redis.properties  &&
gradle build -x test && cd /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle && gradle clean deployUserCenter  -DrealHost=' ' -DrealPassword='1FararFDe999()'