
package com.example.demo.singletonandprototype;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class Prototype {

	String time = LocalDateTime.now().toString();
	int temp = new Random().nextInt(100);
	
	Random ran=new Random();

	public String getTimeDate() {
		return time + " " + temp;
	}

}
