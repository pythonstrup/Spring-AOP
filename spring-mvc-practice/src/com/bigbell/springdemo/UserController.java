package com.bigbell.springdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	private Log logger = LogFactory.getLog(UserController.class);
	
	@RequestMapping(value="/create-user", method=RequestMethod.GET)
	public String showCreateUserPage(ModelMap model) {
		model.addAttribute("user", new User());
		return "user";
	}
	
	@RequestMapping(value="/create-user", method=RequestMethod.POST)
	public String addTodo(User user) {
		logger.info("User details " + user);
		return "redirect:list-users";
	}
	
	@RequestMapping(value="/list-users", method=RequestMethod.GET)
	public String showAllUsers() {
		return "list-users";
	}
}
