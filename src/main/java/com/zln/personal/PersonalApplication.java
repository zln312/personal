package com.zln.personal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zln.personal.mapper")
public class PersonalApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonalApplication.class, args);
    }
}
