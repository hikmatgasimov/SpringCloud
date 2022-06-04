package com.microservicecloud.addressservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@ComponentScan({"com.microservicecloud.addressservice.controller", "com.microservicecloud.addressservice.service"})
@EntityScan("com.microservicecloud.addressservice.entity")
@EnableJpaRepositories("com.microservicecloud.addressservice.repo")
@EnableEurekaClient
public class AddressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressServiceApplication.class, args);
	}

}
