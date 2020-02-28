package com.virtualmachine.app;

import java.util.UUID;

public class VirtualMachine {
	private UUID ID;
	private String IP;
	private String userName;
	private String password_;
	public VirtualMachine() {	
	}
	public VirtualMachine(UUID iD, String iP, String userName, String password_) {
		super();
		ID = iD;
		IP = iP;
		this.userName = userName;
		this.password_ = password_;
	}
	public VirtualMachine(String ip,String username, String password_){
		this.ID = UUID.randomUUID();
		this.IP = ip;
		this.userName = username;
		this.password_ = password_;
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
		return this.password_;
	}
	public void setPassword(String password_) {
		this.password_ = password_;
	}	
}

