package com.dh.serie;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableRabbit
@SpringBootApplication
@EnableMongoRepositories
public class SerieApplication {

    public static void main(String[] args) {
        SpringApplication.run(SerieApplication.class, args);
    }

}
