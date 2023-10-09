package com.example.microAnuncios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroAnunciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroAnunciosApplication.class, args);
	}

}
