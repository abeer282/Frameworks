package com.abeer;

public class Person {
	private int id;
	private String fname;
	private String lname;
	private String address;
	private int age;
	private int phone;
	
	public Person() {
		super();
	}

	public int getId() {
		return id;
	}
	
	public Person(String fname, String lname, String address, int age, int phone) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.age = age;
		this.phone = phone;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}

}
