package com.abeer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;

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
	public List<Person> getAll() {
		String readCommand="SELECT * FROM person";
		System.out.println("11111");
		return template.query(readCommand, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println("*****"+(rowNum+1));
//				System.out.println(rs.getInt(rowNum+1));
//				System.out.println(rs.getString(rowNum+2)+rs.getString(rowNum+1).getClass().getName());
				int id=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				String address=rs.getString(4);
				int age=rs.getInt(5);
				int phone=rs.getInt(6);
				Person p=new Person( id,  fname,  lname,  address,  age,  phone);
//				p.setId(rs.getInt(1));
//				p.setFname(rs.getString(2));
//				p.setLname(rs.getString(3));
//				p.setAddress(rs.getString(4));
//				p.setAge(rs.getInt(5));
//				p.setPhone(rs.getInt(6));
				//System.out.println(p.disply());
				return p;
			}
			
		});
	}

}
