package com.cts.shareprice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2

public class SharePriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharePriceApplication.class, args);
	}
	@Bean
    public Docket configureSwagger() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .paths(PathSelectors.ant("/SharePrice/**")) 
                .apis(RequestHandlerSelectors.basePackage("com.cts.shareprice.controller")).build()
                .apiInfo(apiInfo());
    }
 
    private ApiInfo apiInfo() {
        return new ApiInfo("DailySharePrice Api", "Sample API for DailySharePrice", "1.0", "path/to/terms",
                new Contact("InvestmentTracker", "http://www.google.com", "InvestmentTracker@gmail.com"), "API License",
                "http://www.google.com", Collections.emptyList());
    }

}
