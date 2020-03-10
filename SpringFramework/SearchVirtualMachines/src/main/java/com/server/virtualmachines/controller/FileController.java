package com.server.virtualmachines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.server.virtualmachines.model.User;


//
@Controller
public class FileController {
//	@Autowired
//	FileService fService=new FileService();
	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("home","command",new User());
	}
}
