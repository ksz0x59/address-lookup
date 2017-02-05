package com.ma.de;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AddressLookupApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressLookupApplication.class, args);
	}
}
