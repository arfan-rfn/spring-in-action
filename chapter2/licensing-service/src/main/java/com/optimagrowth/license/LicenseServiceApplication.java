package com.optimagrowth.license;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.optimagrowth.license.model")
@EnableJpaRepositories("com.optimagrowth.license.repository")
public class LicenseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicenseServiceApplication.class, args);
	}

}
