# snow-雪

服务的消费者

* 基于 spring-boot
* 集成 Spring MVC 作为 MVC框架
* 通过 dubbo 和 zookeeper 消费服务


### 目录结构

* controller 目录下，放的是 controller，对，没错，这是一句废话
* core 目录下，放的是自定义的异常和异常捕捉，这样可以保证返回给前端的字符串是我们定义的json，而不是直接崩溃
* model 目录下，放的是 model 的 Vo，可以根据前端需要对于原有的数据进行适当的修正，CommonResponse 是本MVC项目统一返回给前端的封装类，任何给前端的返回，都必须是 CommonResponse
* service 目录下，放的是项目用到的 service，通过 dubbo 框架调用 注册在 zookeeper 上的服务
* util 目录下， 放本项目用到的常量，自行封装的util


### 打包方式

* 执行 mvn clean package，在targe目录下生成一个 war 包
* 上传 war 至服务器，启动 
* 对，这个打包方式说的就是废话


### 规范

* 自定义 model ，均以 Vo 为后缀
* 自定义 service， 均以 Impl 为后缀