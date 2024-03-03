package com.project.caryatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.project.caryatch.repository") // JPA repository paketlerinin bulunduğu dizin
@EntityScan(basePackages = "com.project.caryatch.domain") // Entity sınıflarının bulunduğu dizin
public class CaravanxApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaravanxApplication.class, args);
	}

}
