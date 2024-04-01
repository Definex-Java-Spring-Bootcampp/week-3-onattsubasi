package com.dijitalmarketim.dijitalmarketdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DijitalmarketDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DijitalmarketDiscoveryApplication.class, args);
	}

}
