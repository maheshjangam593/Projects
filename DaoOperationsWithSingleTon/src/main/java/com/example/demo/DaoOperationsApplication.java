package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.singletonandprototype.SingleTon;

@SpringBootApplication
@RestController
/*
 * @Component
 * 
 * @RequestMapping(value="/time", method = RequestMethod.GET)
 * 
 * @ResponseBody
 */
public class DaoOperationsApplication {
	
	@Autowired
	public SingleTon singleTon;

	public static void main(String[] args) {
		SpringApplication.run(DaoOperationsApplication.class, args);
	}
	
	@GetMapping("/time")
	
	public String getTime()
	{
		return singleTon.getTime();
	}

}
