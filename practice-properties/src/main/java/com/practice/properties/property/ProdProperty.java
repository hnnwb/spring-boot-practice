package com.practice.properties.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther: wbnn
 * @Date: 2021/12/08/
 * @Description: 生产配置
 */
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
