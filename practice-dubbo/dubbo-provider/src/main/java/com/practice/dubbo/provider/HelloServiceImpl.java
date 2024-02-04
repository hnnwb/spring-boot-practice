package com.practice.dubbo.provider;

import com.practice.dubbo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author wb
 */
@Service
@Component
@Slf4j
public class HelloServiceImpl implements HelloService {
    /**
     * 问好
     *
     * @param name 姓名
     * @return 问好
     */
    @Override
    public String sayHello(String name) {
        log.info("someone is calling me......");
        return "say hello to: " + name;
    }
}