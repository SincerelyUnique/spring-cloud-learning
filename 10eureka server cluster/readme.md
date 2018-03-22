高可用的服务注册中心
1. 前面的服务注册中心Eureka Server，其实只是是一个实例，当成千上万个服务向它注册的时候，它的负载是非常高的，这在生产环境上是不太合适的，所以我们需要将将Eureka Server集群化。
2. Eureka通过运行多个实例，使其更具有高可用性。事实上，这是它默认的熟性，你需要做的就是给对等的实例一个合法的关联serviceurl。


注意：
1. windows10系统hosts文件路径：C:\windows\system32\drivers\etc\hosts



遇到的问题：
com.netflix.discovery.shared.transport.TransportException: Cannot execute request on any known server

com.sun.jersey.api.client.ClientHandlerException: java.net.ConnectException: Connection refused: connect
Caused by: java.net.ConnectException: Connection refused: connect
这个问题是因为我使用idea自动创建cloud项目时使用的是sb2.0.0，sc是F版本，后来sb改成1.5.2，sc改成D版本就好了，service-hi也是一样的


说明：
1. 我们需要先修改下hosts文件，在里面添加
127.0.0.1 peer1
127.0.0.1 peer2

2. 项目码好后，先给demo-eureka-server打包，直接从终端mvn package即可，当然打包时可能会有些异常抛出，如上面的Cannot execute request on any known server异常
其实没有关系，估计是启动过程中需要向自己注册吧，但是自己还没启动好，会重试的，不影响，最后打包是成功的！

3. 打过包后，win+R启动cmd，启动俩cmd窗口，一个执行
>java -jar eureka-server-0.0.1-SNAPSHOT.jar - -spring.profiles.active=peer1
另一个cmd窗口执行
>java -jar eureka-server-0.0.1-SNAPSHOT.jar - -spring.profiles.active=peer2
然后就可以访问：http://localhost:8761/  ，从这里可以看到8761的注册中心，在DS Replicas下面可以看到peer2节点
然后再访问：http://localhost:8769/   ， 这是另一个对等的注册中心，在DS Replicas下面可以看到peer1节点

4. 启动service-hi服务，从idea里直接启动即可，在次刷新上面两个注册中心，都能看到这个服务注册进来