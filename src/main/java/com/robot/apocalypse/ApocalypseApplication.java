package com.robot.apocalypse;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Survival APIs", version = "3.0", description = "Robot Apocalypse Survival APIs to save humankind."))
public class ApocalypseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApocalypseApplication.class, args);
	}

}
