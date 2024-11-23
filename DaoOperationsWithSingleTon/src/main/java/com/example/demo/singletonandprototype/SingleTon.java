package com.example.demo.singletonandprototype;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
public class SingleTon {
// this will return only one instance,
	/*
	 * 
	 * @Autowired public Prototype pt;
	 */
	// we can also use Object factory and Application context to get the prototype beans
	// this will provide new instance for every request
	@Lookup
	public Prototype getProtypeBean() {
		return null;
	}
	
	public String getTime()
	{
		return getProtypeBean().getTimeDate();
	}
	
}
