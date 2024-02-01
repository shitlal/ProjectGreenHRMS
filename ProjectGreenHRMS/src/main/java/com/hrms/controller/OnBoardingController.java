package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrms.model.CareerOppEntity;
import com.hrms.service.CareerOppService;

@Controller
@RequestMapping("/OnBoarding")
public class OnBoardingController {
	@Autowired
	CareerOppService service;
	@RequestMapping
	public String getAllCandidateDetail(Model model) 
	{	
		System.out.println("getAllCandidateDetail");
		List<CareerOppEntity> list = service.getAllCareerOpp();
		model.addAttribute("career", list);
			
		return "OnBoarding";
	}
	
	
	
}
