Docker是一个开源的引擎，可以轻松的为任何应用创建一个轻量级的、可移植的、自给自足的容器。开发者在笔记本上编译测试通过的容器可以批量地在生产环境中部署，
包括VMs（虚拟机）、bare metal、OpenStack 集群和其他的基础应用平台。 





Docker通常用于如下场景：

1. web应用的自动化打包和发布；
2. 自动化测试和持续集成、发布；
3. 在服务型环境中部署和调整数据库或其他的后台应用；
4. 从头编译或者扩展现有的OpenShift或Cloud Foundry平台来搭建自己的PaaS环境。





Docker 的优点

1、简化程序： 
Docker 让开发者可以打包他们的应用以及依赖包到一个可移植的容器中，然后发布到任何流行的 Linux 机器上，便可以实现虚拟化。Docker改变了虚拟化的方式，使开发者可以直接将自己的成果放入Docker中进行管理。方便快捷已经是 Docker的最大优势，过去需要用数天乃至数周的 任务，在Docker容器的处理下，只需要数秒就能完成。

2、避免选择恐惧症： 
如果你有选择恐惧症，还是资深患者。Docker 帮你 打包你的纠结！比如 Docker 镜像；Docker 镜像中包含了运行环境和配置，所以 Docker 可以简化部署多种应用实例工作。比如 Web 应用、后台应用、数据库应用、大数据应用比如 Hadoop 集群、消息队列等等都可以打包成一个镜像部署。

3、节省开支： 
一方面，云计算时代到来，使开发者不必为了追求效果而配置高额的硬件，Docker 改变了高性能必然高价格的思维定势。Docker 与云的结合，让云空间得到更充分的利用。不仅解决了硬件管理的问题，也改变了虚拟化的方式。




遇到的问题：注意，我是用xshell连接从搬瓦工购买的vps操作的，所以先从windows上建好项目，再打成tar.gz包放到vps服务器后操作的
1. docker在centos7上安装比较好，我之前从搬瓦工上购买的vps是centos6，32位的，好恶心，还好搬瓦工支持一键重装系统，然后我就改成centos7的了，进到centos7后还要装1.8版本的jdk，装3.0以上的maven，装docker，这是第一次装docker，还好比较简单，参照菜鸟教程一个命令就可以了
2. 问题：docker: No port specified: 8763:<empty> ， 注意这条命令：docker run -p 8763: 8763 -t space/service-rocket，可以看到在8763: 8763之间有空格，应该是没有的，去掉后就可以了
3. 执行docker run -p 8763:8763 -t jalen/demo-service-hi命令时报failed: port is already allocated.这个时候可以使用service docker stop关闭docker服务，然后使用service docker start重启，重启docker后注意相应的服务就都断开了
4. centos7想要使用netstat命令（我想使用netstat -ntulp|grep 8763查看端口占用的进程，然后杀死这个进程，重新启动这个这个端口的docker镜像），需要yum install net-tools，由于我重搬瓦工上购买的vps只有500M的运行内存，安装时出现内存不够现象，即[Errno 5] [Errno 12] Cannot allocate memory，这时关掉一下运行的服务再重现安装下就好了，我就是把docker关闭后安装的
5. 基本上我的tar.gz包移动到centos，我会使用chmod -R 777 改下权限，然后使用tar -zxvf xxx.tar.gz解压缩，然后使用mvn package测试下，再使用mvn package docker:build打成docker镜像
6. 启动docker时出现Cannot connect to the Docker daemon at unix:///var/run/docker.sock.这个异常，意思是docker没有启动，使用service docker start启动即可
7. 可以使用docker ps查看当前docker下运行的镜像服务
8. docker run -p 8761: 8761 -t jalen/demo-eureka-server和docker run -p 8763: 8763 -t jalen/demo-service-hi 这两个命令应该改为：docker run --name eureka-server -p 8761:8761 -t jalen/demo-eureka-server和docker run --link eureka-server:8761 -p 8763:8763 -t jalen/demo-service-hi，要不然会报错误：UnknownHostException: 和Cannot execute request on any known server



访问
http://184.170.223.6:8761/
http://184.170.223.6:8763/hi?name=jalen



参考：
最好看一下 https://yq.aliyun.com/articles/47344

eureka.instance.prefer-ip-address这条属性可以参考博客：http://www.itmuch.com/spring-cloud-code-read/spring-cloud-code-read-eureka-registry-ip/