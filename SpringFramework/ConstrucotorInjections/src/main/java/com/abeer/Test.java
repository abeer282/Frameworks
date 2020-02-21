package com.abeer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext conx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person p=(Person)conx.getBean("p");
		p.display();
	}

}
