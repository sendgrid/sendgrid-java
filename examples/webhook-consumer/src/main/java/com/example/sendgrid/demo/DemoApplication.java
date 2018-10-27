package com.example.sendgrid.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        String port = System.getenv("PORT");
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", port != null ? port : "80"));
        app.run(args);
    }
}
