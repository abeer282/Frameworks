package com.server.virtualmachines.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.server.virtualmachines.model.VirtualMachine;
import com.server.virtualmachines.service.VirtualMachineService;

@Controller
public class VirtualMachineController {
//	public static void main(String[] args) {
//		VirtualMachine vm = new VirtualMachine("12.96.111.56", "iamroot", "password123");
//		VirtualMachine vm1 = new VirtualMachine("96.5.123.99", "iamsomeone", "qwerty");
//		VirtualMachine vm2 = new VirtualMachine("202.14.156.33", "iamzozo", "123456789");
//		VirtualMachine vm3 = new VirtualMachine("35.212.67.251", "iamzizi", "football");
//		VirtualMachine vm4 = new VirtualMachine("12.127.95.227", "iamzaza", "zazathegreat");
//		VirtualMachineService vmd = new VirtualMachineService();

//		System.out.println(vm.getID());
//		System.out.println(vm.getID().toString());
//		vmd.addVirtualMachine(vm1);
//		vmd.addVirtualMachine(vm2);
//		vmd.addVirtualMachine(vm3);
//		vmd.addVirtualMachine(vm4);
//		List <VirtualMachine> list=vmd.getAll();
//		for (VirtualMachine vm : list) {
//			System.out.println(vm.toString());
//		}
		
//	}
	
	@Autowired
	VirtualMachineService vmService=new VirtualMachineService();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView addVM() {
		return new ModelAndView("addVM","command",new VirtualMachine());//command: brings attributes of the form tags of the html
		
	}
	
	@RequestMapping(value = "/addVM", method = RequestMethod.POST)
	public ModelAndView addVirtualMachine(@ModelAttribute("vm")VirtualMachine vm) {	
		System.out.println(vm.toString());
		vmService.addVirtualMachine(vm);
		return new ModelAndView("redirect:/viewVM");
	}
	@RequestMapping("/viewVM")
	public ModelAndView viewemp() {
//		List<VirtualMachine>list=new ArrayList<VirtualMachine>();
//		list.add(new VirtualMachine("12.33.22.33","Zozo","z0z0@"));
//		list.add(new VirtualMachine("23.33.44.22","Bobo","123@"));
//		list.add(new VirtualMachine("122.192.22.33","Riri","333333@"));
//		list.add(new VirtualMachine("13.33.22.33","Mimi","dsssar4@"));
//		list.add(new VirtualMachine("234.33.22.33","Kara","dfgs@434fddswa4ty"));
//		list.add(new VirtualMachine("12.33.22.33","Nono","aaaaaa@"));
		List<VirtualMachine>list=vmService.getAll();
		return new ModelAndView("viewVM","list",list);
	}
	

	

	
	
}