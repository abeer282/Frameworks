package com.server.virtualmachines.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.server.virtualmachines.model.VirtualMachine;



public class VirtualMachineDao {
	private JdbcTemplate template;
	
	public VirtualMachineDao() {
		super();
	}
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<VirtualMachine> getAll() {
		String readCommand="SELECT * FROM virtualmachine;";
		
		return template.query(readCommand, new RowMapper<VirtualMachine>() {
			@Override
			public VirtualMachine mapRow(ResultSet rs, int rowNum) throws SQLException {
				UUID id = UUID.fromString(rs.getString(1));
				String ip = rs.getString(2);
				String userName = rs.getString(3);
				String password= rs.getString(4);
				String path= rs.getString(5);
				VirtualMachine vm = new VirtualMachine( id,  ip,  userName,  password, path);
				return vm;
			}
		});
	}
	
	public void insertVirtualMachine(VirtualMachine vm) {
		String insertionCommand = "INSERT INTO virtualmachine(id, ip, userName, password, path)"
							+ " VALUES(\'"+vm.getID().toString()+"\',\'"+vm.getIP()+"\',\'"
							+vm.getUserName()+"\',\'"+vm.getPassword()+"\',\'"+vm.getPath()+"\');";
		template.update(insertionCommand);
	}
	
	public void updateVirtualMachine(UUID id, VirtualMachine vm) {
//		String updateCommand="UPDATE virtualMachine SET fname =\'"+p.getFname()+"\', lname =\'"+p.getLname()
//								+"\', address =\'"+p.getAddress()+"\', age ="+p.getAge()+", phone ="+p.getPhone()
//								+" WHERE id="+id;
//		template.update(updateCommand);
	}
	
	public void deleteVirtualMachine(VirtualMachine vm) {
		String deleteCommand="DELETE FROM virtualMachine WHERE id="+vm.getID();
		template.update(deleteCommand);
	}
}
