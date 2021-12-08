## spring-boot 读取配置文件参数

方式一：注解@Value的方式

```
@Data
@Component
public class ProdProperty {

    @Value("${application.name}")
    private String name;
    @Value("${application.version}")
    private String version;
    @Value("${application.date}")
    private String date;
}
```

方式二：使用bean，封装

```java
@Data
@ConfigurationProperties(prefix = "developer")
@Component
public class DevProperty {

    private String name;
    private String website;
    private String qq;
    private String phoneNumber;
}
```

方式三：使用Environment进行获取

```java
@RestController
public class ProfileController {

    private final DevProperty devProperty;

    private final ProdProperty prodProperty;

    @Resource
    Environment environment;

    public ProfileController(DevProperty devProperty, ProdProperty prodProperty) {
        this.devProperty = devProperty;
        this.prodProperty = prodProperty;
    }

    @GetMapping("/getProperties")
    public Dict getProperties(){
        Dict dict = Dict.create().set("devProperty", devProperty).set("prodProperty", prodProperty);
        dict.set("hnnwb",environment.getProperty("hnnwb.address"));
        return dict;
    }
}
```

**additional-spring-configuration-metadata.json**

用处：可以作为application.properties的提示信息，可以设置其默认值。

位置：resources/META-INF/additional-spring-configuration-metadata.json

示例：

- 二级标签properties为固定值
- name:属性名
- type:类型
- description:提示信息
- defaultValue：默认值

```
{
  "properties": [
    {
      "name": "xx.redisson.host",
      "type": "java.lang.String",
      "description": "redis的服务器地址",
      "defaultValue": "localhost"
    },{
      "name": "xx.redisson.port",
      "type": "java.lang.Integer",
      "description": "redis服务器的端口",
      "defaultValue": 6379
    }
  ]
}
```
