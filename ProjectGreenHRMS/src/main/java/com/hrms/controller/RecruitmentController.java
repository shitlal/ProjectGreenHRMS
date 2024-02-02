package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrms.model.CareerOppEntity;
import com.hrms.model.RecruitmentEntity;
import com.hrms.service.CareerOppService;
import com.hrms.service.RecruitmentService;

@Controller
@RequestMapping("/Recruitment")
public class RecruitmentController

{
	@Autowired
	CareerOppService service;

	@Autowired
	RecruitmentService recservice;

	@RequestMapping()
	public String getAllCareerOpp(Model model) {
//			System.out.println("getAllCareerOpp");

		List<CareerOppEntity> list = service.getAllCareerOpp();
		List<RecruitmentEntity> list1 = recservice.getAllRecruitment();
		int count = list.size();
		int count1 = list1.size();
		
		
		model.addAttribute("Recruit", list1);
		model.addAttribute("career", list);
		model.addAttribute("careercount",count);
		
		/* model.addAttribute("experience", count1); */
		model.addAttribute("Position", count);
		

		return "Recruitment";
	}

	public String getAllRecruitment(Model model) {
		/* System.out.println("getAllRecruitment"); */

		List<RecruitmentEntity> list = recservice.getAllRecruitment();
		int count = list.size();
		model.addAttribute("Recruit", list);
		model.addAttribute("Recruitcount", count);

		return "Recruitment";
	}

}
