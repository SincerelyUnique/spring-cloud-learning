在分布式系统中，由于服务数量巨多，为了方便服务配置文件统一管理，实时更新，所以需要分布式配置中心组件。
在Spring Cloud中，有分布式配置中心组件spring cloud config ，它支持配置服务放在配置服务的内存中（即本地），
也支持放在远程Git仓库中。在spring cloud config 组件中，分两个角色，一是config server，二是config client。

说明：config-client从config-server获取了foo的属性，而config-server是从git仓库读取的,

这里我在尝试sb2.0.0和sc F版本时总报异常，所以版本降到sb1.5.2，sc降到C版本

config-server和config-client所用的版本保持一致

遇到的问题：
1. 启动之前的demo-server，发现没有config-server和config-client的注册信息
原因是没有在sb启动类上添加注解@EnableEurekaClient