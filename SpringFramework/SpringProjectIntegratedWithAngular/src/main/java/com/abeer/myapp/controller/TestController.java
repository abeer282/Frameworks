package com.abeer.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {
	
	@RequestMapping(method = RequestMethod.POST, value =  "/send")
	public void postData(@RequestParam  String data){
		String s="";
		s=data;
		System.out.println("\n\n\nLog:\n Data posted: "+s+"\n\n\n\n");
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/myData")
	public List<String> getData(){
		System.out.println("\n\n\nLog:\n Data request!\n\n\n\n");
		List<String> list=new ArrayList<String>();
		list.add("First Item");
		list.add("Second Item");
		list.add("Third Item");
		list.add("Last Item");
		return list;
	}
	
	

}
