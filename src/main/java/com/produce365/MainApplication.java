package com.produce365;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MainApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
        
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_NAME", dotenv.get("DB_NAME"));
        System.setProperty("DB_PW", dotenv.get("DB_PW"));
        
        System.setProperty("S3_ACCESS", dotenv.get("S3_ACCESS"));
        System.setProperty("S3_SECRET", dotenv.get("S3_SECRET"));
        System.setProperty("S3_NAME", dotenv.get("S3_NAME"));
        System.setProperty("S3_REGION", dotenv.get("S3_REGION"));
        
		SpringApplication.run(MainApplication.class, args);
	}

}