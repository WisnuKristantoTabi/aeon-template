package com.example.aeon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@Component
@EnableAutoConfiguration
@EnableJpaRepositories("com.example.aeon.*")
@ComponentScan(basePackages = { "com.example.aeon.*" })
@EntityScan("com.example.aeon.entity.Karyawan.java")
@SpringBootApplication
public class AeonApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeonApplication.class, args);
	}

}
