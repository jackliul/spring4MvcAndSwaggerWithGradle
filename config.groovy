environments {
    dev { // 开发环境
    	enableSwagger = true;
        database {
            driverClassName = 'com.mysql.jdbc.Driver'
            url = 'jdbc:mysql://localhost:3306/surveyDev?useUnicode=true&amp;characterEncoding=UTF-8'
            username = 'root'
            password = 'root'
        }
    }
    pro { // 生产环境
    	enableSwagger = false;
        database {
            driverClassName = 'com.mysql.jdbc.Driver'
            url = 'jdbc:mysql://localhost:3306/surveyPro?useUnicode=true&amp;characterEncoding=UTF-8'
            username = 'root'
            password = 'wxyz'
        }
    }
}