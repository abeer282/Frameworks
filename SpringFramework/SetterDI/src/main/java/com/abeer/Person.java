package com.abeer;

public class Person {
	private int id;
	private String personName;
	private String favColor;
	private Address addr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersonName() {
		return personName;
	}


	public void setPersonName(String personName) {
		this.personName = personName;
	}


	public String getFavColor() {
		return favColor;
	}


	public void setFavColor(String favColor) {
		this.favColor = favColor;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	void display() {
		System.out.println("ID: "+id+", Name: "+personName+", Favorite color: "+ favColor+"\nAddress: "+addr.toString());
	}

}
