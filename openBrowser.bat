
if ""%1"" == ""192.168.0.165"" (
	start http://192.168.0.165:9090
	echo off ping 0.0.0.0  -n 36 > null echo on
	
	start http://192.168.0.165:8081/spring4MvcAndSwaggerWithGradle/swagger-ui.html
	echo off ping 0.0.0.0  -n 36 > null echo on
	
	start http://192.168.0.165:80
)

if ""%1"" == ""192.168.0.166"" (
	start http://192.168.0.166:9090
	echo off ping 0.0.0.0  -n 36 > null echo on
	
	start http://192.168.0.166:8081/spring4MvcAndSwaggerWithGradle/swagger-ui.html
	echo off ping 0.0.0.0  -n 36 > null echo on
	
	start http://192.168.0.166:80
)