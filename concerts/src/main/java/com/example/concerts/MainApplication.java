package com.example.concerts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(MainApplication.class, args);
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://localhost:8080");
    }
}
