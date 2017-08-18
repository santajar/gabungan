package com.dlc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"id.go.kemsos.simpkh.domain"}) 
public class SimpkhApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SimpkhApplication.class, args);
	}

}
