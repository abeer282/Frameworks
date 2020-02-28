package com.abeer;

public class Person {
	private int id;
	private String fname;
	public Person() {
		super();
	}
	public Person(int id, String fname) {
		super();
		this.id = id;
		this.fname = fname;
	}
	public int getId() {
		return id;
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
	@Override
	public String toString() {
		return "Person [id=" + id + ", fname=" + fname + "]";
	}
}
