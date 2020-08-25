package com.fh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AttendanceManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttendanceManagementApplication.class, args);
    }

}
