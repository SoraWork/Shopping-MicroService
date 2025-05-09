package com.hoaiphong.microservice.inventory;

import org.springframework.boot.SpringApplication;

public class TestInventorySercviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(InventorySercviceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
