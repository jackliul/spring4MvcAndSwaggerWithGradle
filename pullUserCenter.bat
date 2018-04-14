echo "pull the newest resources" && if exist D:\gitPro\pros\user-center rd /s /q "D:\gitPro\pros\user-center" 
cd D:\gitPro\pros\ &&  git clone git@192.168.8.20:user-platform/user-center.git &&  cd D:\gitPro\pros\user-center && git checkout develop
