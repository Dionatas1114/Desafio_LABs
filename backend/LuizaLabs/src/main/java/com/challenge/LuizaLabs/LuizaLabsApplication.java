package com.challenge.LuizaLabs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class LuizaLabsApplication {
	private static final Logger logger = LoggerFactory.getLogger(LuizaLabsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LuizaLabsApplication.class, args);
		logger.info(
				"\n----------------------------------------------------------\n\t"
				+ "LuizaLabs API is running in default port: 8080"
				+ "\n----------------------------------------------------------"
		);
	}
}
