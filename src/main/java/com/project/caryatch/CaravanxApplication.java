package com.project.caryatch;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class,scanBasePackages = {"com.project.caryatch"})
@EnableJpaRepositories(basePackages = "com.project.caryatch.repository") // JPA repository paketlerinin bulunduğu dizin
@EntityScan(basePackages = "com.project.caryatch.domain") // Entity sınıflarının bulunduğu dizin
@OpenAPIDefinition(info = @Info(title = "CARAVANX"))
public class CaravanxApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaravanxApplication.class, args);
	}
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
