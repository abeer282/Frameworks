package com.abeer;

public class Person {
	private int id;
	private String personName;
	private Address address;
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
	
	public Person(int id, String personName, Address address) {
		super();
		this.id = id;
		this.personName = personName;
		this.address = address;
	}

	void display() {
		System.out.println("ID: "+id+", Name: "+personName+", Addr: "+address.toString());
	}

}
