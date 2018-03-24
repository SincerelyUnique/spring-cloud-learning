
遇到的问题：

使用高版本的（sb2.0.0，sc Finchley.M8）启动访问时会报Unable to connect to Command Metric Stream
没办法，只好降低版本了，（sb1.5.2，sc Dalston.RC1）


步骤：

访问http://localhost:8761/
访问http://localhost:8762/hi?name=jalen
访问http://localhost:8762/hystrix.stream