package com.order.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CrudzinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudzinApplication.class, args);
	}

}
