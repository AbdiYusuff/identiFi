package com.devmountain.identifiApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.devmountain.identifiApp.*")
@EntityScan("com.devmountain.identifiApp.*")
@EnableJpaRepositories(basePackages = "com.devmountain.identifiApp.repositories")
public class IdentifiAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdentifiAppApplication.class, args);
	}

}
