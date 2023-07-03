package com.paulina.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.paulina")
public class RestApiDemoProjectDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiDemoProjectDbApplication.class, args);
	}

}
