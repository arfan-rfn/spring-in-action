package com.optimagrowth.license.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
@Profile("test")
public class TestDataLoader {

    @Autowired
    private DataSource dataSource;

    @Bean
    CommandLineRunner loadData() {
        return args -> {
            System.out.println("Loading test data...");
            ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(false, false, "UTF-8",
                new ClassPathResource("schema.sql"),
                new ClassPathResource("data.sql"));
            resourceDatabasePopulator.execute(dataSource);
            System.out.println("Test data loaded successfully!");
        };
    }
}