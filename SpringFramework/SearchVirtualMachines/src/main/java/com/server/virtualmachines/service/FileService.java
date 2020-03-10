package com.server.virtualmachines.service;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.server.virtualmachines.dao.FileDao;
import com.server.virtualmachines.model.File;


public class FileService {
	ApplicationContext conx = new ClassPathXmlApplicationContext("application.xml");
	FileDao fd=(FileDao)conx.getBean("dbInfoFile");
	
	public List<File> getAll(){
		return fd.getAll();
	}
	
	public void addFile(File f) {
		fd.insertFile(f);
	}
	
	public void addFiles(List<File> list) {
		for(File f: list) {
			addFile(f);
		}
	}
}
