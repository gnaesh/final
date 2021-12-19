package com.capgemini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.controller.NGOController;


@SpringBootApplication
public class WomenEmpowermentApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(NGOController.class);


	public static void main(String[] args) {
		LOG.info("Start");
		SpringApplication.run(WomenEmpowermentApplication.class, args);
		LOG.info("End");
	}

}
