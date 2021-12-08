package com.practice.properties.controller;

import cn.hutool.core.lang.Dict;
import com.practice.properties.property.DevProperty;
import com.practice.properties.property.ProdProperty;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: wbnn
 * @Date: 2021/12/08/
 * @Description:
 */
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
