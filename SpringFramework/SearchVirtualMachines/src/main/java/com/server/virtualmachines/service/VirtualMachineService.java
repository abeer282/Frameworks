package com.server.virtualmachines.service;


import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.jcraft.jsch.JSchException;
import com.server.virtualmachines.dao.VirtualMachineDao;
import com.server.virtualmachines.model.File;
import com.server.virtualmachines.model.VirtualMachine;

@Service
public class VirtualMachineService {
	
	ApplicationContext conx = new ClassPathXmlApplicationContext("application.xml");
	VirtualMachineDao vmd=(VirtualMachineDao)conx.getBean("dbInfoVM");
	
	public List<VirtualMachine> getAll(){
		return vmd.getAll();
	}
	
	public void addVirtualMachine(VirtualMachine vm) {
		vmd.insertVirtualMachine(vm);
		
	}
	
	public List<File> getFilesFromRemoteVM(VirtualMachine vm){
		RemoteVirtualMachine rvm=new RemoteVirtualMachine(vm);
		try {
			return rvm.getFiles();
		} catch (JSchException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
