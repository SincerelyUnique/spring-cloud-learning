>service-ribbon是一个服务消费者，在工程的启动类中,通过@EnableDiscoveryClient向服务中心注册；并且向程序的ioc注入一个bean: restTemplate;并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。

1. 一个服务注册中心，eureka server,端口为8761
2. service-hi工程跑了两个实例，端口分别为8762,8763，分别向服务注册中心注册
3. sercvice-ribbon端口为8764,向服务注册中心注册
4. 当sercvice-ribbon通过restTemplate调用service-hi的hi接口时，因为用ribbon进行了负载均衡，会轮流的调用service-hi：8762和8763 两个端口的hi接口；