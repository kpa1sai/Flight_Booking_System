package com.example.OnlineFlight_Booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.controller","com.model","com.services","com.model.repo"})
@EntityScan(basePackages = "com.model")
@EnableSwagger2
public class OnlineFlightBookingApplication {

	
	@Bean
	public Docket myswaggerbean(){
	return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.controller")).build();
	}
	public static void main(String[] args) {
		SpringApplication.run(OnlineFlightBookingApplication.class, args);
	}

}
