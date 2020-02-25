package com.abeer.myapp;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView personForm() {
		return new ModelAndView("personform","command",new Person());//command: brings attributes of the form tags of the html
	}
	
	@RequestMapping(value = "/addperson", method = RequestMethod.POST)
	public ModelAndView addPerson(@ModelAttribute("p")Person p) {
		System.out.println(p.toString());
		return new ModelAndView("redirect:/viewperson");
	}
	
	@RequestMapping("/viewperson")
	public ModelAndView viewemp() {
		List<Person>list=new ArrayList<Person>();
		list.add(new Person(1,"Zozo",45,"Italy"));
		list.add(new Person(2,"Bobo",34,"Spain"));
		list.add(new Person(3,"Mimi",12,"Cuba"));
		list.add(new Person(4,"Riri",78,"China"));
		return new ModelAndView("viewperson","list",list);
	}
	
}
