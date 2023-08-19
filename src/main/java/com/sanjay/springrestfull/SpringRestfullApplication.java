package com.sanjay.springrestfull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableScheduling
public class SpringRestfullApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringRestfullApplication.class);

	public static void main(String[] args) {
		logger.info("RestFull Application stated");
		SpringApplication.run(SpringRestfullApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
