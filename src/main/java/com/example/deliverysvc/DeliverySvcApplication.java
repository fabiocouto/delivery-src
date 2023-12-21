package com.example.deliverysvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeliverySvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliverySvcApplication.class, args);
		System.out.println("Service Started!");
	}

}
