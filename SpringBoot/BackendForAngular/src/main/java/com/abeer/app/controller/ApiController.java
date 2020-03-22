package com.abeer.app.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {
	
	@RequestMapping("/api/getDate")
	@ResponseBody
	public String getDate() {
		return Calendar.getInstance().get(Calendar.DATE)+"";
	}
}
