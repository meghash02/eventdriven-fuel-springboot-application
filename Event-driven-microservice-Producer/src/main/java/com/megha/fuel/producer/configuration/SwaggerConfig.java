package com.megha.fuel.producer.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Enables Swagger configuration for APi
 * 
 * @author Megha Sharma
 *
 */
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.megha.fuel.producer")).paths(regex("/api")).build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo("Event Driven Fuel Event Producer API",
				"This API allows lets you post eventType as true or false along with random city and random mileage details to queue "
						+ "and further details will consumed by Consumer service to calculate fuel amount got into the tank "
						+ "and price of fuel according to city.",
				"1.0", "Terms of Service", new Contact("Megha Sharma", "meghasharma2796@gmail.com", null), null, null,
				null);

		return apiInfo;
	}

}
