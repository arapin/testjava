package com.michael.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 */
@EnableFeignClients
@SpringBootApplication
public class MichaelApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MichaelApiApplication.class,args);
    }
}
