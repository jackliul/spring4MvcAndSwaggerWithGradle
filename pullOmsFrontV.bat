echo "pull the newest resources" && if exist D:\gitPro\pros\oms-front_v rd /s /q "D:\gitPro\pros\oms-front_v"
cd D:\gitPro\pros\ &&  git clone git@192.168.8.20:oms-platform-front/oms-front_v.git &&  cd D:\gitPro\pros\oms-front_v && git checkout develop
