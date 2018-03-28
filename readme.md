Spring Cloud学习Demo

>01service registry 服务发现示例，使用eureka

>02consumer rest ribbon 使用rest+ribbon方式进行服务间调用

>03consumer feign 使用feign方式进行服务间调用，区别于rest+ribbon

>04hystrix Spring Cloud断路器（网上也有叫熔断器）学习

>05zuul 使用zuul做路由转发和过滤器，主要是为了实现负载均衡

>06config 服务配置文件统一管理,支持配置服务放在配置服务的内存中（即本地），也支持放在远程Git仓库中,这里放在git中

>07config cluster 将服务配置中心做成一个微服务，将其集群化 （具体配置见00respo）

>08bus 该Bus将分布式的节点用轻量的消息代理连接起来。它可以用于广播配置文件的更改或者服务之间的通讯，也可以用于监控

>09sleuth 服务链路追踪trace,兼容zipkin

>10eureka server cluster 服务注册中心集群化

>11docker deploy 使用docker做镜像部署，需要将项目拿到linux环境

>12docker deploy compose 使用docker compose插件实现一件部署多个服务

>13hystrix dashboard 断路器仪表盘

>14hystrix turbine 聚合断路器仪表盘，可以在一个页面监视多个服务

>15consul 一个提供服务发现和配置的工具,有自己的客户端，与eureka功能基本相似


