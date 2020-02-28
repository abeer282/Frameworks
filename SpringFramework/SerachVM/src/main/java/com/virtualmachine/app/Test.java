package com.virtualmachine.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test {

	public static void main(String[] args) {
		ApplicationContext conx = new ClassPathXmlApplicationContext("application.xml");
		
		VirtualMachineDao vmDao=(VirtualMachineDao)conx.getBean("dbi");
		vmDao.insertVirtualMachine(new VirtualMachine("1.2.3.6", "awesome user", "password123"));
	}

}
