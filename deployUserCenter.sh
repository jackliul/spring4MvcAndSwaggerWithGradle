#!/bin/sh
echo "start deploy userCenter"
cd /cygdrive/d/gitPro/pros/user-center && gradle build -Denv=pro && cd /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle && gradle clean deployUserCenter 