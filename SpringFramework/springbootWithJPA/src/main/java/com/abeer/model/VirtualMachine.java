package com.abeer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vitualMachines")

public class VirtualMachine {
    private long id;
    private String ip;
    private String username;
    private String password;
	public VirtualMachine() {
		super();
	}
	public VirtualMachine(String ip, String username, String password) {
		super();
		this.ip = ip;
		this.username = username;
		this.password = password;
	}
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	 @Column(name = "ip", nullable = false)
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	 @Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	 @Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "VirtualMachine [id=" + id + ", ip=" + ip + ", username=" + username + ", password=" + password + "]";
	}
}
