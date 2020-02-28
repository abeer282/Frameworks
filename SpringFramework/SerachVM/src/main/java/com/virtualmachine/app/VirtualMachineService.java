package com.virtualmachine.app;

import java.util.List;


public class VirtualMachineService {
	VirtualMachineDao vmd=new VirtualMachineDao();
	
	public List<VirtualMachine> getAll(){
		return new VirtualMachineDao().getAll();
	}
	
	
}