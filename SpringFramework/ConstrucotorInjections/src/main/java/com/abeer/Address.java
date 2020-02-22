package com.abeer;

public class Address {
	private String phone;
	private String email;
	private String country;
	private String city;
	public Address(String phone, String email, String country, String city) {
		super();
		this.phone = phone;
		this.email = email;
		this.country = country;
		this.city = city;
	}
	public String toString() {
		return "Phone: "+ phone+ ", Email: "+ email+", Country: "+ country+ ", City: "+ city;
	}
}