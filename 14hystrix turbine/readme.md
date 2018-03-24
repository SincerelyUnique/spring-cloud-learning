聚合断路器Dashboard

demo-server是注册中心，demo-service-hi和demo-service-lucy是将要监控的具体服务，service-turbine是监控集群中心
依次打开上面的服务

访问：http://localhost:8769/turbine.stream
访问：http://localhost:8762/hi?name=forezp
访问：http://localhost:8763/hi?name=forezp
访问：http://localhost:8763/hystrix，在stream的url地址输入http://localhost:8769/turbine.stream
进入后可以看到两个dashboard


说明：



1. 当我们有很多个服务的时候，这就需要聚合所以服务的Hystrix Dashboard的数据了。这就需要用到Spring Cloud的另一个组件了，即Hystrix Turbine。看单个的Hystrix Dashboard的数据并没有什么多大的价值，要想看这个系统的Hystrix Dashboard数据就需要用到Hystrix Turbine。Hystrix Turbine将每个服务Hystrix Dashboard数据进行了整合。Hystrix Turbine的使用非常简单，只需要引入相应的依赖和加上注解和配置就可以了。
2. 新版本里security.basic.enabled: false这个属性已不再使用
