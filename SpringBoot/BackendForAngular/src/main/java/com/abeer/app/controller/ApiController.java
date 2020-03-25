package com.abeer.app.controller;

import java.security.Principal;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abeer.app.model.User;
import com.abeer.app.repository.UserRepository;

@RestController
public class ApiController {
	@Autowired
	UserRepository repo;
	@RequestMapping(value="/api/insertUser", produces="application/json")
	public Object insertUser() {
		User user=new User();
		user.setId(1);
		user.setName("Abeer");
		repo.save(user);
		return user;
	}

	@RequestMapping(value="/api/getUsername", produces="application/json")
	public Object getDate(Principal principal) {
		User user=new User();
		user.setId(1);
		user.setName(principal.getName());
		return user;
	}
}
