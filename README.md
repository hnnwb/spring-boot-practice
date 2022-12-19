<h1 align="center">spring-boot-practice</h1>

## 项目简介

`spring-boot-practice` 是一个围绕springBoot相关的学习与实战项目,计划根据springBoot相关的框架进行实战练习，目前已完成 `1`个。

##开发环境

- JDK17
- Maven3.6+
- Mysql 5.8+

##运行方式
1.`git clone https://github.com/hnnwb/spring-boot-practice.git`
2. 使用开发工具打开 clone 下来的项目
3. 在开发工具中 Maven Projects 的面板导入项目根目录下 的 `pom.xml` 文件
4. 找到各个 Module 的 Application 类就可以运行各个 practice 了

## 各Module介绍


| Module名称                                                             | Module介绍                                                                                                            |
| ---------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- |
| [practice-helloWorld](./practice-helloworld)                           | spring-boot的基本项目搭建helloWorld                                                                                   |
| [practice-properties](./practice-properties)                           | spring-boot读取配置文件                                                                                               |
| [practice-actuator](./practice-actuator)                               | spring-boot 集成 spring-boot-starter-actuator 监控spring-boot的启动和运行状态                                         |
| [practice-admin-client](./practice-admin-client)                       | spring-boot 集成spring-boot-admin 来可视化的监控 spring-boot 程序的运行状态，可以与 actuator 互相搭配使用，客户端示例 |
| [practice-admin-server](./practice-admin-server)                       | spring-boot 集成spring-boot-admin 来可视化的监控 spring-boot 程序的运行状态，可以与 actuator 互相搭配使用，服务端示例 |
| [practice-logback](./practice-logback)                                 | spring-boot 集成logback，记录程序运行过程中的日志。                                                                   |
| [practice-log-aop](./practice-log-aop)                                 | spring-boot 使用AOP切面的方式记录 web 请求日志                                                                        |
| [practice-exception-handler](./practice-exception-handler)             | spring-boot 统一异常处理，第一种返回统一的JSON格式，第二种统一跳转到异常页面                                          |
| [practice-template-freemarker](./practice-template-freemarker)         | spring-boot 集成Freemarker 模板引擎                                                                                   |
| [practice-template-thymeleaf](./practice-template-thymeleaf)           | spring-boot 集成Thymeleaf 模板引擎                                                                                    |
| [practice-template-beetl](./practice-template-beetl)                   | spring-boot 集成Beetl 模板引擎                                                                                        |
| [practice-template-enjoy](./practice-template-enjoy)                   | spring-boot 集成Enjoy 模板引擎                                                                                        |
| [practice-orm-jdbcTemplate](./practice-orm-jdbcTemplate)               | spring-boot 集成jdbcTemplate操作数据库，并简易封装通用Dao层                                                           |
| [practice-orm-jpa](./practice-orm-jpa)                                 | spring-boot 集成spring-boot-starter-data-jpa操作数据库                                                                |
| [practice-orm-mybatis](./practice-orm-mybatis)                         | spring-boot 集成mybatis，使用mybatis-spring-boot-starter集成                                                          |
| [practice-orm-mybatis-mapper-page](./practice-orm-mybatis-mapper-page) | spring-boot 集成通用Mapper和PageHelper,使用mapper-spring-boot-starter和pageHelper-spring-boot-starter集成             |
| [practice-orm-mybatis-plus](./practice-orm-mybatis-plus)               | spring-boot 集成mybatis-plus,使用mybatis-plus-boot-starter集成，集成BaseMapper/BaseService/ActiveRecord操作数据库     |
| [practice-orm-beetlsql](./practice-orm-beetlsql)                       | spring-boot 集成beetl-sql,使用beetl-framework-starter集成                                                             |
| [practice-demo-upload](./practice-demo-upload)                         | spring-boot 文件上传示例，包含本地文件上传以及七牛云文件上传                                                          |
| [practice-cache-redis](./practice-cache-redis)                         | spring-boot 整合 redis，操作redis中的数据，并使用redis缓存数据                                                        |
| [practice-cache-ehcache](./practice-cache-ehcache)                     | spring-boot 整合 ehcache，使用 ehcache 缓存数据                                                                       |
|                                                                        |                                                                                                                       |
|                                                                        |                                                                                                                       |
|                                                                        |                                                                                                                       |
