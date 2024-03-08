package com.hrms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hrms.model.User;
import com.hrms.service.UserService;

@Controller

public class LoginController {

	@Autowired
	UserService usrservice;
	
    @PostMapping("/login")
    public String home(Model model,User user) {
    	String password=user.getPassword();
    	String username=user.getUsername();
    	String errorMsg="Please provide the correct UserName and Password";
    	System.out.println("username: "+username +"password: "+password);
    	 String pass = usrservice.checkPassword(username);
    	 if(password.equals(pass)) {
    		 return "home";
    	 }
    	 
    	 model.addAttribute("userDetail", new User());
    	 model.addAttribute("errorMsg", errorMsg);
    	 return "login";
    }

    @GetMapping("/login")
    public String login(Model model) {
    	
    	model.addAttribute("userDetail", new User());
        return "login";
    }
}
