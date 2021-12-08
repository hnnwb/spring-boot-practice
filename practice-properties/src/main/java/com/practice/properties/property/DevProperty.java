package com.practice.properties.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: wbnn
 * @Date: 2021/12/08/
 * @Description: 开发配置
 */
@Data
@ConfigurationProperties(prefix = "developer")
@Component
public class DevProperty {

    private String name;
    private String website;
    private String qq;
    private String phoneNumber;

}
