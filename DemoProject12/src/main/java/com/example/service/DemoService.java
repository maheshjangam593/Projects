package com.example.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.Demo1;
import com.example.controller.DemoDto;
import com.example.exception.DemoNotFoundException;
import com.example.repository.DemoRepo;

@Service
public class DemoService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private DemoRepo demoRepo;

	public DemoDto addDemo(DemoDto demo) {
		Demo1 map = mapper.map(demo, Demo1.class);
		Demo1 save = demoRepo.save(map);
		return mapper.map(save, DemoDto.class);
	}

	public DemoDto getDemo(Integer id) {

		Demo1 orElseThrow = demoRepo.findById(id).orElseThrow(() -> new DemoNotFoundException(id));
		return mapper.map(orElseThrow, DemoDto.class);

	}

}
