package com.practice.adminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer  //服务端注解
@SpringBootApplication
public class PracticeAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeAdminServerApplication.class, args);
    }

}
