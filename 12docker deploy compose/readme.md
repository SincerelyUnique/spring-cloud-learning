前提：同上节一样需要打成tar.gz压缩吧拿到linux上操作，可以使用7z压缩工具，第一步打tar包，然后再打gzip包，就可以生成一个tar.gz包了



##步骤-采用docker-compose启动镜像：

1. 注意，这次项目中的Dockfile不是放在src/main/docker目录下了，而是移动到子项目的跟目录
2. 安装docker-compose
3. 根目录下执行/usr/local/bin/docker-compose up命令，此时会自动加载根目录下docker-compose.yml文件，并启动服务
4. 启动成功后访问http://184.170.223.6:8761/；http://184.170.223.6:8763/hi?name=jalen1即可看到结果




##步骤-采用docker-compose编排并启动镜像：
1. 直接执行# /usr/local/bin/docker-compose -f docker-compose.yml -f docker-compose-dev.yml up命令即可，注意这个执行方式使用ctrl+c退出会杀死镜像服务进程





##遇到的问题：
1. docker-compose: command not found，

安装docker-compose
```
# curl -L https://github.com/docker/compose/releases/download/1.1.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
# chmod +x /usr/local/bin/docker-compose
# sudo -i
# /usr/local/bin/docker-compose -f docker-compose.yml -f docker-compose-dev.yml up
```




2. Service "version" doesn't have any configuration options. All top level keys in your docker-compose.yml must map to a dictionary of configuration options，

在执行/usr/local/bin/docker-compose up命令时出现此异常，说明docker-compose版本过低
可以将上面的docker compose版本由1.1.0改为1.20.1，重新安装一下docker-compose。版本的话可以去https://github.com/docker/compose/releases 上查看



3. [root@host 12docker deploy compose]# /usr/local/bin/docker-compose -f docker-compose.yml -f docker-compose-dev.yml up
ERROR: build path /usr/local/mcchu/docker/12docker deploy compose/service-hi either does not exist, is not accessible, or is not a valid URL.
原来是我的docker-compose-dev.yml中build的名字错了，改成demo-eureka-server和demo-service-hi就好了



##注意

1. 在linux终端使用crtl+c并不会使docker已部署的服务断掉，需要手动执行service docker stop
2. 可以使用docker images或docker ps查看docker镜像
3. 查看当前linux可用的命令个数，跟linux发行版和装的软件有关。你可以切换到root用户，然后在命令行（bash）连续按TAB键，会显示“Display all xxxx possibilities? (y or n)”，其中xxxx就是可用的命令数。
