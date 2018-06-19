package com.fa.test.technique.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.fa.test.technique.app" })
public class TestTechniqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestTechniqueApplication.class, args);
	}

}
