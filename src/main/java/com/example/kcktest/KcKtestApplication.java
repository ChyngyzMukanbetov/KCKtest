package com.example.kcktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class KcKtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(KcKtestApplication.class, args);
    }

}
