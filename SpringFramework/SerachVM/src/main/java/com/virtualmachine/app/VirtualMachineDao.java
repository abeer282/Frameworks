package com.virtualmachine.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;




public class VirtualMachineDao {
	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public List<VirtualMachine> getAll() {
		String readCommand="SELECT * FROM virtualmachine";
		return template.query(readCommand, new RowMapper<VirtualMachine>() {
			@Override
			public VirtualMachine mapRow(ResultSet rs, int rowNum) throws SQLException {
				UUID id=UUID.fromString(rs.getString(1));
				String ip=rs.getString(2);
				String userName=rs.getString(3);
				String password_=rs.getString(4);
				VirtualMachine vm=new VirtualMachine( id,  ip,  userName,  password_);
				return vm;
			}
		});
	}
	public void insertVirtualMachine(VirtualMachine vm) {
		String insertionCommand="INSERT INTO virtualmachine(id,ip,userName,password_)"
							+ " VALUES(\'"+vm.getID()+"\',\'"+vm.getIP()+"\',\'"
							+vm.getUserName()+"\',\'"+vm.getPassword()+"\')";
		template.update(insertionCommand);
	}
	public void updateVirtualMachine(UUID id, VirtualMachine vm) {
//		String updateCommand="UPDATE virtualMachine SET fname =\'"+p.getFname()+"\', lname =\'"+p.getLname()
//								+"\', address =\'"+p.getAddress()+"\', age ="+p.getAge()+", phone ="+p.getPhone()
//								+" WHERE id="+id;
//		template.update(updateCommand);
	}
	public void deleteVirtualMachine(VirtualMachine vm) {
		String deleteCommand="DELETE FROM virtualmachine WHERE id="+vm.getID();
		template.update(deleteCommand);
	}
	
}
