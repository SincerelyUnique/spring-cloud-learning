
结构：Eureka注册中心，一个配置服务器，两个客户端服务读取配置服务器访问的git配置
1. Spring Cloud Bus 将分布式的节点用轻量的消息代理连接起来。它可以用于广播配置文件的更改或者服务之间的通讯，也可以用于监控。
2. 我们只需要在配置文件中配置 spring-cloud-starter-bus-amqp ；这就是说我们需要装rabbitMq：http://www.rabbitmq.com/
3. rabbitMq安装后默认启动，可以从进程中查看，默认端口为5672，用户名和密码默认都是guest
4. 依次启动服务，访问http://localhost:8881/hi ；http://localhost:8882/hi，然后修改仓库config-client-dev.properties配置，注意不要重启服务器
5. 使用postman等工具发送post请求：http://localhost:8881/bus/refresh，再次访问http://localhost:8881/hi ；http://localhost:8882/hi，可见数据已变化
6. 另外，/bus/refresh接口可以指定服务，即使用”destination”参数，比如 “/bus/refresh?destination=customers:**” 即刷新服务名为customers的所有服务，不管ip。
7. 说明：当git文件更改的时候，通过pc端用post向端口为8882的config-client发送请求/bus/refresh／；此时8882端口会发送一个消息，由消息总线向其他服务传递，从而使整个微服务集群都达到更新配置文件。
8. 注意在启动类加注解：@RefreshScope
