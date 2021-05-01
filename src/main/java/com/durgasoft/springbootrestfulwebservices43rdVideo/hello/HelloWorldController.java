package com.durgasoft.springbootrestfulwebservices43rdVideo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class HelloWorldController {
	
	//GET
	//URI: /hello-world
	//URL:http://localhost:9090/hello-world
//	@RequestMapping(method = RequestMethod.GET,path="/hello-world")
	@GetMapping("/hello-world")
	public String helloWorld() {
		System.out.println("helloWorld method is calling....");
		return "Reshma is Afroz Lover";
		
	}
	
	@GetMapping("/hello-bean")
	public HelloBean helloWorldBean() {
		System.out.println("helloWorldBean method is calling....");
		return new HelloBean("Reshma Good Evening...");
	}

}
