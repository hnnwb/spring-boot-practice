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

| Module名称                                                               | Module介绍                                                                                                                                                   |
|------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [practice-helloWorld](./practice-helloworld)                           | spring-boot的基本项目搭建helloWorld                                                                                                                               |
| [practice-properties](./practice-properties)                           | spring-boot读取配置文件                                                                                                                                          |
| [practice-actuator](./practice-actuator)                               | spring-boot 集成 spring-boot-starter-actuator 监控spring-boot的启动和运行状态                                                                                          |
| [practice-admin-client](./practice-admin-client)                       | spring-boot 集成spring-boot-admin 来可视化的监控 spring-boot 程序的运行状态，可以与 actuator 互相搭配使用，客户端示例                                                                      |
| [practice-admin-server](./practice-admin-server)                       | spring-boot 集成spring-boot-admin 来可视化的监控 spring-boot 程序的运行状态，可以与 actuator 互相搭配使用，服务端示例                                                                      |
| [practice-logback](./practice-logback)                                 | spring-boot 集成logback，记录程序运行过程中的日志。                                                                                                                        |
| [practice-log-aop](./practice-log-aop)                                 | spring-boot 使用AOP切面的方式记录 web 请求日志                                                                                                                          |
| [practice-exception-handler](./practice-exception-handler)             | spring-boot 统一异常处理，第一种返回统一的JSON格式，第二种统一跳转到异常页面                                                                                                             |
| [practice-template-freemarker](./practice-template-freemarker)         | spring-boot 集成Freemarker 模板引擎                                                                                                                              |
| [practice-template-thymeleaf](./practice-template-thymeleaf)           | spring-boot 集成Thymeleaf 模板引擎                                                                                                                               |
| [practice-template-beetl](./practice-template-beetl)                   | spring-boot 集成Beetl 模板引擎                                                                                                                                   |
| [practice-template-enjoy](./practice-template-enjoy)                   | spring-boot 集成Enjoy 模板引擎                                                                                                                                   |
| [practice-orm-jdbcTemplate](./practice-orm-jdbcTemplate)               | spring-boot 集成jdbcTemplate操作数据库，并简易封装通用Dao层                                                                                                                |
| [practice-orm-jpa](./practice-orm-jpa)                                 | spring-boot 集成spring-boot-starter-data-jpa操作数据库                                                                                                            |
| [practice-orm-mybatis](./practice-orm-mybatis)                         | spring-boot 集成mybatis，使用mybatis-spring-boot-starter集成                                                                                                      |
| [practice-orm-mybatis-mapper-page](./practice-orm-mybatis-mapper-page) | spring-boot 集成通用Mapper和PageHelper,使用mapper-spring-boot-starter和pageHelper-spring-boot-starter集成                                                            |
| [practice-orm-mybatis-plus](./practice-orm-mybatis-plus)               | spring-boot 集成mybatis-plus,使用mybatis-plus-boot-starter集成，集成BaseMapper/BaseService/ActiveRecord操作数据库                                                        |
| [practice-orm-beetlsql](./practice-orm-beetlsql)                       | spring-boot 集成beetl-sql,使用beetl-framework-starter集成                                                                                                        |
| [practice-demo-upload](./practice-demo-upload)                         | spring-boot 文件上传示例，包含本地文件上传以及七牛云文件上传                                                                                                                       |
| [practice-cache-redis](./practice-cache-redis)                         | spring-boot 整合 redis，操作redis中的数据，并使用redis缓存数据                                                                                                              |
| [practice-cache-ehcache](./practice-cache-ehcache)                     | spring-boot 整合 ehcache，使用 ehcache 缓存数据                                                                                                                     |
| [practice-email](./practice-email)                                     | spring-boot 整合 email，包括发送简单文本邮件、HTML邮件（包括模板HTML邮件）、附件邮件、静态资源邮件                                                                                             |
| [practice-task](./practice-task)                                       | spring-boot 快速实现定时任务                                                                                                                                       |
| [practice-task-quartz](./practice-task-quartz)                         | spring-boot 整合 quartz，并实现对定时任务的管理，包括新增定时任务，删除定时任务，暂停定时任务，恢复定时任务，修改定时任务启动时间，以及定时任务列表查询，`提供前端页面`                                                             |
| [practice-task-xxl-job](./practice-task-xxl-job)                       | spring-boot 整合[xxl-job](http://www.xuxueli.com/xxl-job/en/#/)，并提供绕过 `xxl-job-admin` 对定时任务的管理的方法，包括定时任务列表，触发器列表，新增定时任务，删除定时任务，停止定时任务，启动定时任务，修改定时任务，手动触发定时任务 |
| [practice-swagger](./practice-swagger)                                 | spring-boot 集成原生的 `swagger` 用于统一管理、测试 API 接口                                                                                                               |
| [practice-swagger-beauty](./practice-swagger-beauty)                   | spring-boot 集成第三方 `swagger` [swagger-bootstrap-ui](https://github.com/xiaoymin/Swagger-Bootstrap-UI) 美化API文档样式，用于统一管理、测试 API 接口                            |
| [practice-rbac-security](./practice-rbac-security)                     | spring-boot 集成 spring security 完成基于RBAC权限模型的权限管理，支持自定义过滤请求，动态权限认证，使用 JWT 安全认证，支持在线人数统计，手动踢出用户等操作                                                           |
| [practice-rbac-shiro](./practice-rbac-shiro)                           | spring-boot 集成 shiro 实现权限管理<br /> <span style="color:pink;">待完成</span>                                                                                     |
| [practice-session](./practice-session)                                 | spring-boot 集成 Spring Session 实现Session共享、重启程序Session不失效                                                                                                   |
| [practice-oauth](./practice-oauth)                                     | spring-boot 实现oauth服务器功能，实现授权码机制                                                                                                                           |
| [practice-social](./practice-social)                                   | spring-boot 集成第三方登录，继承justauth-spring-boot-starter 实现QQ登录，github登录，微信登录，谷歌登录等等                                                                             |
| [practice-zookeeper](./practice-zookeeper)                             | spring-boot 集成 Zookeeper 结合AOP实现分布式锁                                                                                                                                              |
| [practice-mq-rabbitmq](./practice-mq-rabbitmq)                         | spring-boot 集成 RabbitMQ 实现基于直接队列模式、分列模式、主题模式、延迟队列的消息发送和接收                                                                                                                                                       |
| [practice-mq-kafka](./practice-mq-kafka)                               | spring-boot 集成 kafka实现消息的发送和接收                                                                                                                                                 |
| [practice-websocket](./practice-websocket)                             |      spring-boot 集成 websocket，后端主动推送前端服务器运行信息                                                                                                                                                      |
| [practice-websocket-socketio]  (./practice-websocket-socketio)         |      spring-boot 使用 netty-socketio 集成 websocket，实现一个简单的聊天室                                                                                                                                                      |
|                                                                        |                                                                                                                                                            |
