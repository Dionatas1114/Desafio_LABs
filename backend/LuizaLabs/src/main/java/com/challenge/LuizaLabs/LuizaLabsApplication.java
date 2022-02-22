package com.challenge.LuizaLabs;

import com.sun.istack.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class LuizaLabsApplication {
	private static Logger logger = Logger.getLogger(LuizaLabsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LuizaLabsApplication.class, args);
		logger.info(
				"\n----------------------------------------------------------\n\t"
				+ "LuizaLabs API is running in default port: 8080"
				+ "\n----------------------------------------------------------"
		);
	}
}
