1. 当服务实例很多时，都从配置中心读取文件，这时可以考虑将配置中心做成一个微服务，将其集群化，从而达到高可用。
2. eureka-server工程，用作服务注册中心。
3. spring.cloud.config.discovery.enabled 是从配置中心读取文件。
4. spring.cloud.config.discovery.serviceId 配置中心的servieId，即服务名。
5. 这时发现，在读取配置文件不再写ip地址，而是服务名，这时如果配置服务部署多份，通过负载均衡，从而高可用。

访问网址：http://localhost:8889/
访问http://localhost:8881/hi，http://localhost:8881/ha，

参考博客：http://blog.csdn.net/forezp/article/details/70037513