package com.server.virtualmachines.service;

import com.jcraft.jsch.*;
import com.server.virtualmachines.model.File;
import com.server.virtualmachines.model.VirtualMachine;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class RemoteVirtualMachine {
	private VirtualMachine vm;
	private Channel channel;
    private JSch jsch;
    private Session session;
	public RemoteVirtualMachine(VirtualMachine vm) {
		super();
		this.vm = vm;
	}
	
	public ArrayList<File> getFiles() throws JSchException{
		InputStream inputStream = initializeConnection();
		ArrayList<ArrayList<String>> processedStream = readResposeStream(inputStream);
		 ArrayList<File>  filesList=parseLists(processedStream);
		return filesList;
	}
	
	private InputStream initializeConnection() throws JSchException {
		String myCommand = "hostname\n ls -lR --full-time --group-directories-first \n exit \n";
		InputStream inputStream=null;
		try {
			jsch=new JSch();
			session = jsch.getSession(this.vm.getUserName(),this.vm.getIP(), 22);
			session.setUserInfo(new RemoteVirtualMachineInformation(this.vm.getUserName(), this.vm.getPassword()));
	        session.connect();
	       	channel = session.openChannel("shell");
	       	channel.setInputStream(new ByteArrayInputStream(myCommand.getBytes(StandardCharsets.UTF_8)));
	        channel.setOutputStream(System.out);
	        inputStream = channel.getInputStream();
	        channel.connect();	       	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return inputStream;
	}
	
	private ArrayList<ArrayList<String>> readResposeStream(InputStream inputStream) {
        StringBuilder outBuff;
        outBuff = new StringBuilder();
        ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
        ArrayList<String> singleList = new ArrayList<String>();
        try {
            while (true) {                
                for (int c; ((c = inputStream.read()) >= 0);) {
                    outBuff.append((char) c);
                    if((char)c == ' '){
                        singleList.add((outBuff.toString()));
                        outBuff = new StringBuilder();
                    }if((char) c == '\n'){
                        String lastElem=outBuff.toString();
                       lastElem = lastElem.replace("\r\n","");
                        singleList.add((lastElem));
                        singleList.removeAll(Arrays.asList(" ", null));
                        listOLists.add(singleList);
                        outBuff = new StringBuilder();
                        singleList= new ArrayList<String>();
                    }
                }
            
                if (channel.isClosed()) {
                    if (inputStream.available() > 0) 
                    	continue;
                    //exitStatus = channel.getExitStatus();
                    break;
                }
                
            }//while (parser)
        }catch (IOException e) {
			e.printStackTrace();
		}
        return listOLists;
        
	}
	
	
	private  ArrayList<File> parseLists(ArrayList<ArrayList<String>> listOfLists){
		String LocationOfFile=".";
		ArrayList<File> listOfFiles=new ArrayList<File>();
        for(ArrayList<String> innerLs : listOfLists) {
	        if (innerLs.size()==1) {
	        	String potentialPath=innerLs.get(0);
	        	if(potentialPath.length()>0&&potentialPath.charAt(potentialPath.length()-1)==':') {
	        		LocationOfFile=potentialPath.substring(0, potentialPath.length()-1)+"/";
	        	}
	        }else if(innerLs.size()==9) {
	        		try {
	        			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	        			Date date=format.parse(innerLs.get(5).trim());
	        			File f1=new File(this.vm.getID(),innerLs.get(8),date,Integer.parseInt(innerLs.get(4).trim()),LocationOfFile);
	        			listOfFiles.add(f1);
	        		}catch(Exception e) {
	        			continue;
	        		}
	        }
         }//for
		return listOfFiles;//return the list of all files that have been parsed
	}
}
