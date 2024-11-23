package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
@EntityScan("com.example.entity.*")
//@EnableJpaRepositories("com.example.java")
public class DaoOperationsBetweenTablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaoOperationsBetweenTablesApplication.class, args);
	}

}
