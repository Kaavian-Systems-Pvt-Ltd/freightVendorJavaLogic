package com.demo.freightvendor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FreightvendorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreightvendorApplication.class, args);
	}

}
