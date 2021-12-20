<h1 align="center">spring-boot-practice</h1>

## 项目简介

`spring-boot-practice` 是一个围绕springBoot相关的学习与实战项目,计划根据springBoot相关的框架进行实战练习，目前已完成 `1`个。

##开发环境

- JDK17
- Maven3.6+
- IntelliJ IDEA 2021.1.3+
- Mysql 5.8+

##运行方式
1.`git clone https://github.com/hnnwb/spring-boot-practice.git`
2. 使用 IDEA 打开 clone 下来的项目
3. 在 IDEA 中 Maven Projects 的面板导入项目根目录下 的 `pom.xml` 文件
4. 找到各个 Module 的 Application 类就可以运行各个 practice 了

## 各Module介绍


| Module名称                                                 | Module介绍                                                                                                            |
| ------------------------------------------------------------ | ----------------------------------------------------------------------------------------------------------------------- |
| [practice-helloWorld](./practice-helloworld)               | spring-boot的基本项目搭建helloWorld                                                                                   |
| [practice-properties](./practice-properties)               | spring-boot读取配置文件                                                                                               |
| [practice-actuator](./practice-actuator)                   | spring-boot 集成 spring-boot-starter-actuator 监控spring-boot的启动和运行状态                                         |
| [practice-admin-client](./practice-admin-client)           | spring-boot 集成spring-boot-admin 来可视化的监控 spring-boot 程序的运行状态，可以与 actuator 互相搭配使用，客户端示例 |
| [practice-admin-server](./practice-admin-server)           | spring-boot 集成spring-boot-admin 来可视化的监控 spring-boot 程序的运行状态，可以与 actuator 互相搭配使用，服务端示例 |
| [practice-logback](./practice-logback)                     | spring-boot 集成logback，记录程序运行过程中的日志。                                                                   |
| [practice-log-aop](./practice-log-aop)                     | spring-boot 使用AOP切面的方式记录 web 请求日志                                                                        |
| [practice-exception-handler](./practice-exception-handler) | spring-boot 统一异常处理，第一种返回统一的JSON格式，第二种统一跳转到异常页面                                          |
|                                                            |                                                                                                                       |
|                                                            |                                                                                                                       |
|                                                            |                                                                                                                       |
|                                                            |                                                                                                                       |
|                                                            |                                                                                                                       |
|                                                            |                                                                                                                       |
