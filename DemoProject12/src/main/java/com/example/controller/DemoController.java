package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.DemoService;

@RestController
public class DemoController {

	@Autowired
	private DemoService demoService;

	@PostMapping("/addDemo")
	public DemoDto addDemo(@RequestBody DemoDto demoDto) {
		return demoService.addDemo(demoDto);

	}

	@GetMapping("/getDemo/{id}")
	public DemoDto addDemo(@PathVariable Integer id) {
		return demoService.getDemo(id);

	}
}
