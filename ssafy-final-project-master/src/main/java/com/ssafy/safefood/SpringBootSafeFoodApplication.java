package com.ssafy.safefood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootSafeFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSafeFoodApplication.class, args);
	}

}
