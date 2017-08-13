# air-空气

提供最基础的model 和 service 的接口，打成jar包在另外两个项目里面调用


## 目录结构

* model 目录下，每个存在 mysql 里的数据，都必须继承自 BaseDto
* model 目录下，每个存在 mongoDB 里的数据，都必须继承自 BaseMongoDto
* service 目录下，对于每一个 model，定义一个 service 的接口


## 打包方式

1. 打开 pom 文件，项目的 version 按日期改掉，如 20170812-1127
2. 执行 mvn install ，在本地的 mvn 里就会有相应的版本的 air jar包
3. 在需要调用 air jar包的地方，改掉 air 的版本号


## 规范

* 自定义 model ，均以 Dto 为后缀