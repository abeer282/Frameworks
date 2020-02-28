package com.virtualmachine.app;

import java.text.DateFormat;
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
	
	VirtualMachineService vmService=new VirtualMachineService();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView addVM() {
		return new ModelAndView("addVM","command",new VirtualMachine());//command: brings attributes of the form tags of the html
	}
	
	@RequestMapping(value = "/addVM", method = RequestMethod.POST)
	public ModelAndView addVirtualMachine(@ModelAttribute("vm")VirtualMachine vm) {	
		System.out.println(vm.toString());
		return new ModelAndView("redirect:/viewVM");
	}
	@RequestMapping("/viewVM")
	public ModelAndView viewemp() {
		List<VirtualMachine>list=vmService.getAll();
		return new ModelAndView("viewVM","list",list);
	}

	
}
