package com.dlc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpkhApplication {

	@Autowired
	DataSource dataSource;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SimpkhApplication.class, args);
	}

}
