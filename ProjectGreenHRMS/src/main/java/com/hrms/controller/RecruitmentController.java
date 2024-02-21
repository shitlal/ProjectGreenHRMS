package com.hrms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	@GetMapping(path = { "show/{jobCode}" })
    @ResponseBody
    public ResponseEntity<CareerOppEntity> getByJobCode(Model model, @PathVariable("jobCode") String jobCode) {
        // Your logic to fetch data based on the selected value
		CareerOppEntity entity = recservice.getByJobCode(jobCode);
		List<RecruitmentEntity> list = recservice.getAllRecruitmentByJobCode(jobCode);
		int count = list.size();
		model.addAttribute("Recruit1", list);
        return ResponseEntity.ok(entity);
    }
	
	//Add New entry page

	@RequestMapping(path = "/addCandidates")
	public String createCandidateDetail(RecruitmentEntity candidatedetail)
	{
		System.out.println("CandidatesDetail ");
		
        recservice. createCandidateDetail(candidatedetail);
		
		return "CloseAndRedirect";
	}
	
	
	 
	 @RequestMapping(path = {"/createCand"})
	public String createCandidateDetail(Model model)
							
	{
		System.out.println("createCand" );

               {
        RecruitmentEntity recopp=new RecruitmentEntity();
        RecruitmentEntity savedEntity=recrepo.save(recopp);
        Integer canId=savedEntity.getCandidateid();
        Integer  candidateid=20000+canId;
            	   
        recopp.setCandidateid(candidateid);
        
	  model.addAttribute("Recruit", recopp);
	  
		}
		return "AddCareerOpp";
	
	}
	}
	






