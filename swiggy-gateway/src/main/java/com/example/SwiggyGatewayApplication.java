package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// first using identity service we register a user and get a token
// then to authenticate every further request of same user we need to validate in gateway
// once it validates the token request goes to given controller/service
//so we need to add this filter before our username authentication filter
// to check the user identity for service under gateway routes
@SpringBootApplication
@EnableDiscoveryClient
public class SwiggyGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwiggyGatewayApplication.class, args);
	}

}
