rem cd D:/openCodes/spring4MvcAndSwaggerWithGradle
echo "pull the newest resources" && if exist D:\gitPro\pros\oms-back rd /s /q "D:\gitPro\pros\oms-back" 
cd D:\gitPro\pros\ &&  git clone git@192.168.8.20:oms-platform-back/oms-back.git &&  cd D:\gitPro\pros\oms-back && git checkout develop
