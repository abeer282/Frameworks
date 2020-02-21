package com.abeer;

public class Person {
	private int id;
	private String personName;
	
	public Person() {
		super();
	}
	
	public Person(int id) {
		super();
		this.id = id;
	}
	
	public Person(String personName) {
		super();
		this.personName = personName;
	}
	
	public Person(int id, String personName) {
		super();
		this.id = id;
		this.personName = personName;
	}
	
	void display() {
		System.out.println("ID: "+id+", Name: "+personName);
	}

}
