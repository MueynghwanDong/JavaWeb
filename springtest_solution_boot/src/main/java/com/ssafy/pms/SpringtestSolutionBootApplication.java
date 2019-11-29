package com.ssafy.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringtestSolutionBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtestSolutionBootApplication.class, args);
	}

}
