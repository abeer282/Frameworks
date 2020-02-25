package com.abeer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class DatabaseInfo {
	private JdbcTemplate template;
	
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public Boolean insertPerson(Person p) {
		String insertionCommand="INSERT INTO person(fname,lname,address,age,phone) VALUES((?,?,?,?,?)";
		return template.execute(insertionCommand, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, p.getFname());
				ps.setString(1, p.getLname());
				ps.setString(1, p.getAddress());
				ps.setInt(1, p.getAge());
				ps.setInt(1, p.getPhone());
				return ps.execute();
			}
			
		});
	}
//	public void updatePerson(int id,Person p) {
//		String updateCommand="UPDATE person SET fname =\'"+p.getFname()+"\', lname =\'"+p.getLname()
//								+"\', address =\'"+p.getAddress()+"\', age ="+p.getAge()+", phone ="+p.getPhone()
//								+" WHERE id="+id;
//		template.update(updateCommand);
//	}
//	public void deletePerson(Person p) {
//		String deleteCommand="DELETE FROM person WHERE id="+p.getId();
//		template.update(deleteCommand);
//	}
}
