package org.sample.park.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients(basePackages = "org.sample.park.client")
@ComponentScan(basePackages = "org.sample.park")
@EnableJpaRepositories(basePackages = "org.sample.park.repository")

public class CarParkApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarParkApplication.class, args);
    }
}