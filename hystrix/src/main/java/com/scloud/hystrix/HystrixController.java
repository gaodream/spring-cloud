package com.scloud.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {
	
	@Autowired
	private HystrixService hystrixService;
	
	@GetMapping("/getInfo")
	public String getInfo(){
		return hystrixService.getInfo();
	}

}
