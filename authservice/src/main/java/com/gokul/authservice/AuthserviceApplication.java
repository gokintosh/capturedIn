package com.gokul.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
//@EnableBinding(UserEventStream.class)
public class AuthserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthserviceApplication.class, args);
    }

}
