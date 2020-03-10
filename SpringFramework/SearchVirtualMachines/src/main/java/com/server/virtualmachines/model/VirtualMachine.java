package com.server.virtualmachines.model;


import java.util.UUID;

public class VirtualMachine {
	private UUID ID= UUID.randomUUID();;
	private String IP;
	private String userName;
	private String password;
	private String path;
	
	public VirtualMachine() {
		super();
	}
	
	public VirtualMachine(UUID iD, String iP, String userName, String password, String path) {
		super();
		ID = iD;
		IP = iP;
		this.userName = userName;
		this.password = password;
		this.path = path;
	}
	
	public VirtualMachine(String ip,String username, String password, String path){
		this.ID = UUID.randomUUID();
		this.IP = ip;
		this.userName = username;
		this.password = password;
		this.path = path;
	}
	
	public UUID getID() {
		return this.ID;
	}
	
	public void setID(UUID id) {
		this.ID = id;
	}
	
	public String getIP() {
		return this.IP;
	}
	
	public void setIP(String ip) {
		this.IP = ip;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String username) {
		this.userName = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password_) {
		this.password = password_;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "VirtualMachine [ID=" + ID + ", IP=" + IP + ", userName=" + userName + ", password=" + password
				+ ", path=" + path + "]";
	}
	
}

