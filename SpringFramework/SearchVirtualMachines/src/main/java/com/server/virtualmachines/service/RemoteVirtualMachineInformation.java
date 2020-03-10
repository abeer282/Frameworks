package com.server.virtualmachines.service;

import com.jcraft.jsch.UserInfo;

public class RemoteVirtualMachineInformation implements UserInfo{
	private String password;

	public RemoteVirtualMachineInformation (String userName, String password) {
        this.password = password;
    }
	@Override
	public String getPassphrase() {
		throw new UnsupportedOperationException("Not supported yet!");
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean promptPassword(String message) {
		return true;
	}

	@Override
	public boolean promptPassphrase(String message) {
		throw new UnsupportedOperationException("Not supported yet!");
	}

	@Override
	public boolean promptYesNo(String message) {
		return true;
	}

	@Override
	public void showMessage(String message) {
	}
	

}
