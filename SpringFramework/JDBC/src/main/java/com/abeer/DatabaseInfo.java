package com.abeer;

import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseInfo {
	private JdbcTemplate template;
	
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void insertPerson(Person p) {
		String insertionCommand="INSERT INTO person(fname,lname,address,age,phone)"
							+ " VALUES(\'"+p.getFname()+"\',\'"+p.getLname()+"\',\'"
							+p.getAddress()+"\',"+p.getAge()+","+p.getPhone()+")";
		template.update(insertionCommand);
	}
	public void updatePerson(int id,Person p) {
		String updateCommand="UPDATE person SET fname =\'"+p.getFname()+"\', lname =\'"+p.getLname()
								+"\', address =\'"+p.getAddress()+"\', age ="+p.getAge()+", phone ="+p.getPhone()
								+" WHERE id="+id;
		template.update(updateCommand);
	}
	public void deletePerson(Person p) {
		String deleteCommand="DELETE FROM person WHERE id="+p.getId();
		template.update(deleteCommand);
	}
}
