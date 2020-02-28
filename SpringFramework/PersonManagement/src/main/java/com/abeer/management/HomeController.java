package com.abeer.management;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	DatabaseInfo di;
	@RequestMapping("/")
	public ModelAndView homeform() {
		return new ModelAndView("home","command",new Person()); //home is the main page /
	}
	@RequestMapping("/addperson")
	public ModelAndView showform() {
		return new ModelAndView("addperson","command",new Person()); //home is the main page /
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("p") Person p) {
		di.insertPerson(p);
		return new ModelAndView("redirect:/viewperson"); 
	}
	@RequestMapping("/viewperson")
	public ModelAndView viewemp() {
		List<Person> list=di.viewAll();
		return new ModelAndView("viewperson","list",list); 
	}
	
}
