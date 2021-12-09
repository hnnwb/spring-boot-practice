## spring-boot 通过actuator监控项目运行情况

### 端点暴露地址

将项目运行起来之后，会在**控制台**里查看所有可以访问的端口信息

1. 打开浏览器，访问：http://localhost:16803/sys/actuator/mappings ，输入用户名(hnnwb)密码(hnnwb)即可看到所有的mapping信息
2. 访问：http://localhost:16803/sys/actuator/beans ，输入用户名(hnnwb)密码(hnnwb)即可看到所有 Spring 管理的Bean
3. 其余可访问的路径，参见文档

### 参考

- actuator文档：https://docs.spring.io/spring-boot/docs/2.0.5.RELEASE/reference/htmlsingle/#production-ready
- 具体可以访问哪些路径，参考: https://docs.spring.io/spring-boot/docs/2.0.5.RELEASE/reference/htmlsingle/#production-ready-endpoints
