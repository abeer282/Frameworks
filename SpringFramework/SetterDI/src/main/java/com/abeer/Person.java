package com.abeer;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Person {
	private int id;
	private String personName;
	private String favColor;
	private Address addr;
	private List<String> nickNames;
	private Map<String,String> singers;

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
	
	public List<String> getNickNames() {
		return nickNames;
	}

	public void setNickNames(List<String> nickNames) {
		this.nickNames = nickNames;
	}

	public Map<String, String> getSingers() {
		return singers;
	}

	public void setSingers(Map<String, String> singers) {
		this.singers = singers;
	}

	void display() {
		System.out.println("ID: "+id+", Name: "+personName+", Favorite color: "+ favColor+"\nAddress: "+addr.toString());
		Iterator<String> it = nickNames.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		Set<Entry<String,String>> set=singers.entrySet();
		Iterator<Entry<String,String>> it1 = set.iterator();
		while(it1.hasNext()) {
			Entry<String,String> entry=it1.next();
			System.out.println("Key: "+entry.getKey()+", Value: "+entry.getValue());
		}
	}

}
