package com.abeer.management;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

public class DatabaseInfo {
	private JdbcTemplate template;
	
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void insertPerson(Person p) {
		String insertionCommand="INSERT INTO person(fname, lname, age, height, weight, gender, phone, email, city, country)"
									+ "	VALUES(\'"+p.getFname()+"\',\'"+p.getLname()+"\',"+p.getAge()+","+p.getHeight()+
									","+p.getWeight()+",\'"+p.getGender()+"\',"+p.getPhone()+",\'"+p.getEmail()+"\',\'"+"\',\'"+
									p.getCity()+"\',\'"+p.getCountry()+"\');";
		template.execute(insertionCommand);
	}
	public void updatePerson(int id,Person p) {
		String updateCommand="UPDATE person SET fname =\'"+p.getFname()+"\', lname =\'"+p.getLname()
								+"\', age ="+p.getAge()+", height ="+p.getHeight()+", height ="+p.getWeight()
								+", gender=\'"+p.getGender()+"\', phone="+p.getPhone()+", email=\'"+p.getEmail()
								+"\', city=\'"+p.getCity()+"\', country=\'"+p.getCountry()+"\' WHERE id="+id;
		template.update(updateCommand);
	}
	public void deletePerson(Person p) {
		String deleteCommand="DELETE FROM person WHERE id="+p.getId();
		template.update(deleteCommand);
	}
	
	public Person personById(int id) {
		String selectCommand="SELECT * FROM person where id=?";
		return template.queryForObject(selectCommand, new Object[] {id},new BeanPropertyRowMapper<Person>(Person.class));
	}
	public List<Person> viewAll(){
		String selectCommand="SELECT * FROM person";
		return template.query(selectCommand,new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person p=new Person();
				p.setId(rs.getInt(1));
				p.setFname(rs.getString(2));
				p.setLname(rs.getString(3));
				p.setAge(rs.getInt(4));
				p.setHeight(rs.getInt(5));
				p.setWeight(rs.getInt(6));
				p.setGender(rs.getString(7));
				p.setPhone(rs.getInt(8));
				p.setEmail(rs.getString(9));
				p.setCity(rs.getString(10));
				p.setCountry(rs.getString(11));
				return p;
			}
			
			
			
			
		});
	}
	
}
