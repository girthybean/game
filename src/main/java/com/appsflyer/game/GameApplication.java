package com.appsflyer.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableConfigurationProperties
@SpringBootApplication
public class GameApplication {

    static void main(String[] args) {
        SpringApplication.run(GameApplication.class, args);
    }

}
