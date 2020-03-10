package com.server.virtualmachines.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.UUID; 


public class File {
	 	private UUID vmID;
	    private String fileName;
	    private Date creationDate;
	    private int fileSize;
	    private String fileLoc;

	    public File(UUID vmID, String fileName, Date date, int fileSize, String fileLoc){
	        this.vmID=vmID;
	        this.fileName=fileName;
	        this.fileSize=fileSize;
	        this.creationDate=date;
	        this.fileLoc=fileLoc;
	    }
	    public File(){
	    }
	    public void setVmID(UUID vmID){
	        this.vmID=vmID;
	    }
	    public void setFileName(String fileName){
	        this.fileName=fileName;
	    }
	    public void setFileSize(int fileSize){
	        this.fileSize=fileSize;
	    }
	    public void setCreationDate(String date){
	    	Date d1=new Date();
	    	try {
				d1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
	    	
	        this.creationDate=d1;
	    }
	    public void setFileLoc(String fileLoc) {
	          this.fileLoc=fileLoc;	
	    }
	    public UUID getVmID(){
	        return vmID;
	    }
	    
	    public String getFileName(){
	        return fileName;
	    }
	    
	    public int getFileSize(){
	        return fileSize;
	    }
	    
	    public Date getCreationDate(){
	        return creationDate;
	    }
	    public String getFileLoc() {
	          return fileLoc;
	    
	    }

}
