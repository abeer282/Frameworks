package com.abeer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext conx = new ClassPathXmlApplicationContext("application.xml");
		
		DatabaseInfo di=(DatabaseInfo)conx.getBean("dbi");
		
		di.insertPerson(new Person("Soso","asd","adr2",33,21232)); //insert
		
		//delete
//		Person p=new Person();
//		p.setId(2);
//		di.deletePerson(p);
//		
//		int id = 3;
//		di.updatePerson(id, new Person("Momo","Aaa","add2r",63,363625));

	}

}