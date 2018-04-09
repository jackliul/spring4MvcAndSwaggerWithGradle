#!/bin/sh
echo "start deploy omsBack"
cd /cygdrive/d/gitPro/pros/oms-back/oms-web  && gradle build -Denv=pro && cd /cygdrive/d/openCodes/spring4MvcAndSwaggerWithGradle && gradle clean deployOmsBack