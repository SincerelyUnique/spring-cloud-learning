##服务链路追踪(Spring Cloud Sleuth)
1. Spring Cloud Sleuth 主要功能就是在分布式系统中提供追踪解决方案，并且兼容支持了 zipkin，你只需要在pom文件中引入相应的依赖即可。
2. 微服务架构上通过业务来划分服务的，通过REST调用，对外暴露的一个接口，可能需要很多个服务协同才能完成这个接口功能，如果链路上任何一个服务出现问题或者网络超时，都会形成导致接口调用失败。随着业务的不断扩张，服务之间互相调用会越来越复杂。


##遇到的问题：
1. 在DemoApplication类中，因为属性注入在idea编辑器会出现警告，所以我习惯使用类的构造注入，而在使用构造注入时遇到org.springframework.beans.factory.UnsatisfiedDependencyException
最后找了半天原因，改成原来的属性注入就可以了。


##说明
zipkin-server是服务跟踪控制台，现在有3个服务：service-hi，service-miya，service-kiana，他们之间的调用会通过zipkin做服务链路追踪，最终的调用关系会展示到监控页面

访问：http://localhost:9411/；http://localhost:9411/dependency

访问：http://localhost:8988/hi           hi->miya->hi
访问：http://localhost:8989/miya 		 miya->hi
访问：http://localhost:8990/kiana 		 kiana->miya->hi
