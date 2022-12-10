package com.soprasteria.springbatchjobrepoexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.soprasteria.springbatchjobrepoexample.repo.CustomerRepo;

@SpringBootApplication(scanBasePackageClasses = CustomerRepo.class)
public class SpringbatchjobrepoexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbatchjobrepoexampleApplication.class, args);
	}

}
