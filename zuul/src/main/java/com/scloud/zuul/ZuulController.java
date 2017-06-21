package com.scloud.zuul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZuulController {
	
	@RequestMapping("/index")  
    public Object index() {  
        return "index";  
    }  
      
    @RequestMapping("/home")  
    public Object home() {  
        return "home";  
    }  
}
