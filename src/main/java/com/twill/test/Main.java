package com.twill.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("spring.jpa.generate-ddl","true");
        SpringApplication springApplication = new SpringApplication(Main.class);
        springApplication.setDefaultProperties(properties);
        springApplication.run(args);
    }
}
