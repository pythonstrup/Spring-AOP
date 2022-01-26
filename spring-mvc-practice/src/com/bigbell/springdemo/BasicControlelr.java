package com.bigbell.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicControlelr {
	
	@RequestMapping(value="/welcome")
	@ResponseBody
	public String welcome() {
		return "Welcome to Spring MVC";
	}
}
