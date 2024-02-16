package com.hrms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrms.model.CareerOppEntity;
import com.hrms.model.RecruitmentEntity;
import com.hrms.repository.RecruitmentRepository;
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
	
	@Autowired
	RecruitmentRepository recrepo;

	@RequestMapping()
	public String getAllCareerOpp(Model model) {
//			System.out.println("getAllCareerOpp");

		List<CareerOppEntity> list = service.getAllCareerOpp();
		System.out.println(list);
		List<RecruitmentEntity> list1 = recservice.getAllRecruitment();
		int count = list.size();
		System.out.println(count);
		int count1 = list1.size();
		model.addAttribute("Recruit", list1);
		model.addAttribute("career", list);
		model.addAttribute("careercount",count);
		
		
		/* model.addAttribute("experience", count1); */
		/* model.addAttribute("Position",count); */
		

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
	
	
	@RequestMapping(path = "/show/{jobCode}",  method = RequestMethod.GET)
	public String getByJobCode(Model model, @PathVariable("jobCode") Optional<String> jobCode) 
							 
	{
		
		
		if (jobCode.isPresent()) 
		{
			
			System.out.println(jobCode);
			
			CareerOppEntity entity = recservice.getByJobCode(jobCode.get());
			 model.addAttribute("career", entity); 
			 
		    model.addAttribute("Position", entity.getPosition()); 
			model.addAttribute("Location", entity.getLocation()); 
			model.addAttribute("Description", entity.getDescription()); 
			model.addAttribute("Experience ", entity.getExperience()); 
				
		}
		
		return "Recruitment";
	}
	
	//Add New entry page

	@RequestMapping(path = "/addCandidates")
	public String createCandidateDetail(RecruitmentEntity candidatedetail)
	{
		System.out.println("CandidatesDetail ");
		
        recservice. createCandidateDetail(candidatedetail);
		
		return "Recruitment";
	}
	
	/*
	 * @PostMapping(path = {"/createCand"}) public String
	 * createCandidateDetail(Model model)
	 * 
	 * { System.out.println("createCand" );
	 * 
	 * {
	 * 
	 * model.addAttribute("Recruit", new RecruitmentEntity());
	 * 
	 * } return "AddCareerOpp"; }
	 */
	 @RequestMapping(path = {"/createCand"})
	public String createCandidateDetail(Model model)
							
	{
		
		System.out.println("createCand" );


               {
        RecruitmentEntity recopp=new RecruitmentEntity();
        RecruitmentEntity savedEntity=recrepo.save(recopp);
        Integer canId=savedEntity.getCandidateid();
            	   
        recopp.setCandidateid(canId);
        
	  model.addAttribute("Recruit", recopp);
	  
		}
		
		
		return "AddCareerOpp";
	
	}
	}
	






