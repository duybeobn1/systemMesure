package org.sample.park.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.sample.park.repository")
public class CarParkApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarParkApplication.class, args);
    }
}
