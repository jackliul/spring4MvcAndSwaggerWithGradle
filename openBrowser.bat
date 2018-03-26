
start http://%1%:9090
echo off ping 0.0.0.0  -n 100 > null echo on

start http://%1%:8081/spring4MvcAndSwaggerWithGradle/swagger-ui.html
echo off ping 0.0.0.0  -n 100 > null echo on

start http://%1%:80