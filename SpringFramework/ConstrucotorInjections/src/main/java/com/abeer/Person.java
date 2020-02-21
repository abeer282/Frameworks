package com.abeer;

import java.util.Iterator;
import java.util.List;

public class Person {
	private int id;
	private String personName;
	private List<String> nickNames;
	
	public Person() {
		super();
	}
	



	void display() {
		System.out.println("ID: "+id+", Name: "+personName);
		Iterator it = nickNames.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}




	public Person(int id, String personName, List<String> nickNames) {
		super();
		this.id = id;
		this.personName = personName;
		this.nickNames = nickNames;
	}

}
