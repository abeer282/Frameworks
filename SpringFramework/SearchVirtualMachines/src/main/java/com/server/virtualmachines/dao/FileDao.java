package com.server.virtualmachines.dao;

import java.util.UUID;
import org.springframework.jdbc.core.JdbcTemplate;
import com.server.virtualmachines.model.File;
import com.server.virtualmachines.model.VirtualMachine;

public class FileDao {
	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void insertFile(File f) {
		String insertionCommand="INSERT INTO file(vmID,fileName,creationDate,fileSize,fileLoc)"
							+ " VALUES(\'"+f.getvmID()+"\',\'"+f.getfileName()+"\',\'"
							+f.getCreationDate()+"\',"+f.getfileSize()+",\'"+f.getfileLoc()+"\')";
		template.update(insertionCommand);
	}
	public void updateVirtualMachine(UUID id, VirtualMachine vm) {
//		String updateCommand="UPDATE person SET fname =\'"+p.getFname()+"\', lname =\'"+p.getLname()
//								+"\', address =\'"+p.getAddress()+"\', age ="+p.getAge()+", phone ="+p.getPhone()
//								+" WHERE id="+id;
//		template.update(updateCommand);
	}
	public void deletePerson(File f) {
		String deleteCommand="DELETE FROM person WHERE id="+f.getvmID();
		template.update(deleteCommand);
	}
}
