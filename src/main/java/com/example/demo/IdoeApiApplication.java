package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication(scanBasePackages = {"controller", "service", "com.example.demo"})
@EntityScan("entity")
@EnableJpaRepositories("repository")
public class IdoeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdoeApiApplication.class, args);
	}

}