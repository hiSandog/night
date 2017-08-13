# wind-风

服务的提供者

* 基于 spring-boot
* 集成 mybatis 作为ORM框架
* 连接 mysql 和 mongoDB
* 通过 dubbo 和 zookeeper 暴露服务


### 目录结构

* conf 目录下，放的是本项目的配置，目前只有 mysql 配置
* mongo 目录下，放的是和 mongoDB 交互的 model，全部继承自 BaseMongoDo
* mybatis 目录下，放的是 mybatis 自动生成的 bean 和 mapper ，resouces 目录下的 mappers下的是 mybatis生成的 xml 文件
* tool目录下，放的是 mybatis 自动生成工具，配置好 config.xml,执行 run.sh 脚本，直接生成相应的 bean 、mapper 以及 xml 文件
* service 目录下，放的是项目提供出去的 service，通过 dubbo 注册在 zookeeper
* util 目录下， 放本项目用到的常量，自行封装的util


### 打包方式

* 执行 mvn clean package，在targe目录下生成一个 war 包
* 上传 war 至服务器，启动 
* 对，这个打包方式说的还是废话


### 规范

* 自定义 model ，均以 Do 为后缀
* 自定义 service， 均以 Impl 为后缀