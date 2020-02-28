package com.abeer.management;

public class Person {
	private int id;
	private String fname;
	private String lname;
	private int age;
	private float height;
	private float weight;
	private String gender;
	private int phone;
	private String email;
	private String city;
	private String country;
	public Person() {
		super();
	}
	public Person(int id, String fname, String lname, int age, float height, float weight, String gender, int phone,
			String email, String city, String country) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.country = country;
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
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", height=" + height
				+ ", weight=" + weight + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", city="
				+ city + ", country=" + country + "]";
	}
}
