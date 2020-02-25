package com.abeer.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AbeerController {
	@RequestMapping("/abeer")
	public ModelAndView abeer() {
		String msg="My name is beer, A beer!";
		return new ModelAndView("index2","msg",msg);// page attribute(in the page) variable
	}

}
