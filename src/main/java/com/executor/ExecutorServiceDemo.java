package com.executor;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Collections;



@SpringBootApplication
public class ExecutorServiceDemo {
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(ExecutorServiceDemo.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
    }

}



