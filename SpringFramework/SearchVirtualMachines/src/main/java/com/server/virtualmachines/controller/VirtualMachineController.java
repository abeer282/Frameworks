package com.server.virtualmachines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.server.virtualmachines.model.VirtualMachine;
import com.server.virtualmachines.service.FileService;
import com.server.virtualmachines.service.VirtualMachineService;

@Controller
public class VirtualMachineController {
	@Autowired
	VirtualMachineService vmService = new VirtualMachineService();
//	FileService fService = new FileService();

	@RequestMapping(value = "/addVM", method = RequestMethod.POST)
	public ModelAndView addVirtualMachine(@ModelAttribute("vm")VirtualMachine vm) {	
		vmService.addVirtualMachine(vm);
//		fService.addFiles(vmService.getFilesFromRemoteVM(vm));
		return new ModelAndView("redirect:/viewVM");
	}
	
	@RequestMapping("/viewVM")
	public ModelAndView viewemp() {
		List<VirtualMachine>list=vmService.getAll();
		return new ModelAndView("viewVM","list",list);
	}
		
	
}