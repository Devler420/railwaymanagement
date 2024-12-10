package com.boompanupong.railwaymanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Railway Management System API",
				version = "1.0",
				description = "API for managing trains, stations, and tickets in the railway system.",
				contact = @Contact(name = "Support Team", email = "boompanupong@gmail.com")
		),
		security = @SecurityRequirement(name = "basicAuth")
)
@SecuritySchemes({
		@SecurityScheme(
				name = "basicAuth",
				type = io.swagger.v3.oas.annotations.enums.SecuritySchemeType.HTTP,
				scheme = "basic"
		)
})
@SpringBootApplication
public class RailwaymanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RailwaymanagementApplication.class, args);
	}

}
