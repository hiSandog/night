# night-夜幕

知道这个项目为什么起名夜幕吗？
因为这是我瞎起的。

### air-空气

提供最基础的model 和 service 的接口，打成jar包在另外两个项目里面调用


### wind-风

服务的提供者

* 基于 spring-boot
* 集成 mybatis 作为ORM框架
* 连接 mysql 和 mongoDB
* 通过 dubbo 和 zookeeper 暴露服务



### snow-雪

服务的消费者

* 基于 spring-boot
* 集成 Spring MVC 作为 MVC框架
* 通过 dubbo 和 zookeeper 消费服务