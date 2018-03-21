在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），在Spring Cloud可以用RestTemplate+Ribbon和Feign来调用。为了保证其高可用，单个服务通常会集群部署。由于网络原因或者自身的原因，服务并不能保证100%可用，如果单个服务出现问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应。

为了解决这个问题，业界提出了断路器模型。

>Netflix has created a library called Hystrix that implements the circuit breaker pattern. In a microservice architecture it is common to have multiple layers of service calls.. —-摘自官网

Netflix开源了Hystrix组件，实现了断路器模式，SpringCloud对这一组件进行了整合。 在微服务架构中，一个请求需要调用多个服务是非常常见的

遇到的问题：
1. ribbon和feign的dashboard进入时Unable to connect to Command Metric Stream
这个在做时，因为我用的sb是2.0.0版本的，sc是F版本的，导致ribbon和feign的hystrix的dashboard总是Unable to connect to Command Metric Stream
后来我把ribbon和feign的sb和sc版本都降到1.5.2和D版本，然后可以了，这里我之前的server-hi服务还是用2.0.0和F新版本做的，server也是
2. feign断路器配置总是失效，访问8765时，一会成功，一会500
解决方式是在配置文件中添加一段配置feign:hystrix:enabled: true，之前因为输入时总是没有代码提示，还以为不存在这个属性，其实是有的

