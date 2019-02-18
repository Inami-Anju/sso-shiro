package com.example.ssoshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ssoshiro.dao")
public class SsoShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoShiroApplication.class, args);
    }

}
