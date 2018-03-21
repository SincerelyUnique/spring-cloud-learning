package com.example.config.client.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Value("${foo}")
	String foo;

	@RequestMapping("hi")
	public String hi(){
		return foo;
	}

	@Value("${democonfigclient.message}")
	String message;

	@RequestMapping("ha")
	public String ha(){
		return message;
	}
}
