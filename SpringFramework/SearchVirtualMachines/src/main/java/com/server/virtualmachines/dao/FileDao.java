package com.server.virtualmachines.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.server.virtualmachines.model.File;
import com.server.virtualmachines.model.VirtualMachine;

public class FileDao {
	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	
	public void setTemplate(JdbcTemplate template0) {
		this.template = template0;
	}
	
	public List<File> getAll() {
		String readCommand="SELECT * FROM file;";
		
		return template.query(readCommand, new RowMapper<File>() {
			@Override
			public File mapRow(ResultSet rs, int rowNum) throws SQLException {
				UUID id = UUID.fromString(rs.getString(1));
				String name = rs.getString(2);
				Date date=new Date();
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(3));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				int size= rs.getInt(4);
				String location= rs.getString(5);
				File f = new File( id,  name,  date,  size, location);
				return f;
			}
		});
	}
	
	public void insertFile(File f) {
		Date date = f.getCreationDate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		String strDate = dateFormat.format(date);
		String insertionCommand="INSERT INTO file(vmID,name,creationDate,size,location)"
							+ " VALUES(\'"+f.getVmID()+"\',\'"+f.getFileName()+"\',\'"
							+strDate+"\',"+f.getFileSize()+",\'"+f.getFileLoc()+"\')";
		template.update(insertionCommand);
	}
	
	public void updateVirtualMachine(UUID id, VirtualMachine vm) {
		
	}
	public void deletePerson(File f) {
		String deleteCommand="DELETE FROM file WHERE vmID="+f.getVmID();
		template.update(deleteCommand);
	}
}
