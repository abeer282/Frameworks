package com.server.virtualmachines.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.server.virtualmachines.model.User;
import com.server.virtualmachines.model.VirtualMachine;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("home","command",new User());
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView user(@ModelAttribute("u")User u) {	
		if (u.equals(new User(111,"root","qwerty")))
			return new ModelAndView("addVM","command",new VirtualMachine());
		else
			return new ModelAndView("home","command",new User());
	}

	
}
