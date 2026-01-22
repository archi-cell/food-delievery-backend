package com.fooddelivery.auth_service;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.fooddelivery.auth_service")
@EntityScan(basePackages = "com.fooddelivery.auth_service.entity")
@EnableJpaRepositories(basePackages = "com.fooddelivery.auth_service.repository")
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);

    }

    @Bean
    public CommandLineRunner checkDataSource(DataSource dataSource) {
        return args -> {
            System.out.println("👉 Connected to DB: " + dataSource.getConnection().getMetaData().getURL());
        };
    }

}
