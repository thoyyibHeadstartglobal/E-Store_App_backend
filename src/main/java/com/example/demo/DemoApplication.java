package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
@OpenAPIDefinition (info = @Info(title = "E-STORE API",version="2.0",
description="E-store app doc informations"))
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
//	public Docket apis() {
//		
//		return  
//				Docket(
//						
//	DocumentationType.SWAGGER_2)
//				.select().apis(
//						RequestHandlerSelectors.basePackage("com.example.demo"))
//				.build();
//	}
//
//	private Docket Docket(DocumentationType swagger2) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
