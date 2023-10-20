package com.exatech.hired_service_service;

import lombok.Builder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HiredServiceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiredServiceServiceApplication.class, args);
	}
  //NOS ayuda a comunicarnos con otro microservicios
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
