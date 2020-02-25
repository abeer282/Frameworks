package com.abeer;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext conx = new ClassPathXmlApplicationContext("application.xml");
		
		DatabaseInfo di=(DatabaseInfo)conx.getBean("dbi");
		
		List<Person> list=di.getAll();
		for (int i=0;i<list.size();i++) {
			System.out.println(list.get(i).disply());
		}
//		Iterator<Person> it=list.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next().disply());
//		}
		//di.insertPerson(new Person("Bobo","aaa","add2r",66,111111)); //insert
		
		//delete
//		Person p=new Person();
//		p.setId(2);
//		di.deletePerson(p);
		
//		int id = 3;
//		di.updatePerson(id, new Person("Momo","Aaa","add2r",63,363625));

	}

}