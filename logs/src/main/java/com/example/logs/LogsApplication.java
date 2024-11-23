package com.example.logs;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@SpringBootApplication
@RestController
@Slf4j
public class LogsApplication {

		Logger logger=LoggerFactory.getLogger(LogsApplication.class);

	@GetMapping("/logs")
	public ResponseEntity<String> getLogs()
	{
		ResponseEntity<String> hello_world = new ResponseEntity<>("Hello World", HttpStatus.ACCEPTED);

		logger.info(String.valueOf(hello_world));
		return hello_world;
	}

	public static void main(String[] args) {
		SpringApplication.run(LogsApplication.class, args);
	}

}
