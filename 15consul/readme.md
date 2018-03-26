服务注册(consul)

spring cloud consul 组件，它是一个提供服务发现和配置的工具。consul具有分布式、高可用、高扩展性。

consul 具有以下性质，服务发现：consul通过http 方式注册服务，并且服务与服务之间相互感应；服务健康监测；key/value 存储；多数据中心


遇到的问题：
又是坑人的版本问题，consul的0.9版本的path属性是这样的：health-check-path: ${management.contextPath}/health
而1.0版本的是这样的health-check-path: /health