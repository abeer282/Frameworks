package com.abeer;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Person {
	private int id;
	private String personName;
	private List<String> nickNames;
	private Map<String,String> singers;
	
	public Person() {
		super();
	}
	

	public Person(int id, String personName, List<String> nickNames, Map<String, String> singers) {
		super();
		this.id = id;
		this.personName = personName;
		this.nickNames = nickNames;
		this.singers = singers;
	}



	void display() {
		System.out.println("ID: "+id+", Name: "+personName);
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
