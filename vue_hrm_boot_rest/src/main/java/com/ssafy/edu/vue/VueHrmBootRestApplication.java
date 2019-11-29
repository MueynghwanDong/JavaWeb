package com.ssafy.edu.vue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class VueHrmBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueHrmBootRestApplication.class, args);
	}
	
	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("hrm service").description("hrm을 위한 rest 서비스 제공!!").version("1.0")
				.build();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(metadata());
	}

}
