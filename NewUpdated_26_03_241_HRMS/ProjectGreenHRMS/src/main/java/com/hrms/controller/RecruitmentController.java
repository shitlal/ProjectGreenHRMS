package com.hrms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrms.model.CareerOppEntity;
import com.hrms.model.OnBoardingEntity;
import com.hrms.model.RecruitmentEntity;
import com.hrms.repository.RecruitmentRepository;
import com.hrms.service.CareerOppService;
import com.hrms.service.OnBoardingService;
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

	@Autowired
	OnBoardingService Onboardingservice;
	
	
	@RequestMapping()
	public String getAllCareerOpp(Model model) {
//			System.out.println("getAllCareerOpp");

		List<CareerOppEntity> list = service.getAllCareerOpp();

		int count = list.size();
		model.addAttribute("career", list);
		model.addAttribute("careercount", count);

		// Recruitment Data
		List<RecruitmentEntity> list1 = recservice.getAllRecruitment();
		
		System.out.println(count);
		int count1 = list1.size();
		model.addAttribute("Recruit", list1);

		// OnBoarding data
		List<OnBoardingEntity> list2 = recservice.getAllOnboard();

		model.addAttribute("careers", list2);

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
        
		
		/*
		 * String getJob = savedEntity.getJobCode(); String jobCode = "10" + 100;
		 * 
		 * recopp.setJobCode(jobCode);
		 */
		       	   
        recopp.setCandidateid(candidateid);
        
	  model.addAttribute("Recruit", recopp);
	  
		}
		return "AddCareerOpp";
	
	}
	 
		@GetMapping(path = { "getCandData/{jobCode}" })
		@ResponseBody
		public ResponseEntity<List<RecruitmentEntity>> getCandidateData(Model model,
				@PathVariable("jobCode") String jobCode) {
			// Your logic to fetch table data based on the selected value of the first
			// dropdown
			List<RecruitmentEntity> listCand = recservice.getAllRecruitmentByJobCode(jobCode);

			return ResponseEntity.ok(listCand);
		}
	
		 
		// Show data in interview Rounds
		@GetMapping("interview/{candidateid}")
		@ResponseBody
		public ResponseEntity<String> openInterviewBycandidatename(Model model,
				@PathVariable("candidateid") Integer candidateid) 
		{
			// Your logic to fetch additional information based on the selected entity ID
			String candName = recservice.openInterviewBycandidatename(candidateid);
			return ResponseEntity.ok(candName);
			
		}
		
		@GetMapping("edit/{candidateid}")
	    public String editCandidate(@PathVariable Integer candidateid, Model model) {
			RecruitmentEntity entity = (RecruitmentEntity) recrepo.findByCandidateid(candidateid);
	                
	        model.addAttribute("Recruit", entity);
	        return "Recruitment"; // Thymeleaf template name
	    }
		
		
		//Based on Candidateid Update previous details
		
		 @RequestMapping("edits/{candidateid}")
		    public String updateCandidate(@PathVariable Integer candidateid, @ModelAttribute RecruitmentEntity updatedCandidate) {
			 RecruitmentEntity existingCandidate = (RecruitmentEntity) recrepo.findByCandidateid(candidateid);
			 
		           
		        // Update existingCandidate with data from updatedCandidate
		        // Save the updated candidate back to the repository
				
				   existingCandidate.setAssignee1(updatedCandidate.getAssignee1()); 
				  existingCandidate.setInterviewdate1(updatedCandidate.getInterviewdate1());
				 			 
			 recrepo.save(existingCandidate);
		        return "redirect:/RecruitmentEntity"; // Redirect to candidate list page
		    }
		
		 
		 
		/*
		 * // Save interview data
		 * 
		 * @RequestMapping(path = "/AddAssignee") public String
		 * createAssigneeDetail(RecruitmentEntity Assignee) {
		 * 
		 * System.out.println("createAssigneeDetail ");
		 * 
		 * recservice.createAssigneeDetail(Assignee);
		 * 
		 * return "CloseAndRedirect"; }
		 * 
		 * @GetMapping("saveinterview/{candidateid}")
		 * 
		 * @ResponseBody public ResponseEntity<RecruitmentEntity>
		 * saveInterviewBycandidatenames(Model model, @PathVariable("candidateid")
		 * RecruitmentEntity candidateid)
		 * 
		 * { RecruitmentEntity entity = recservice.createAssigneeDetail(candidateid);
		 * model.addAttribute("Recruit", entity);
		 * 
		 * return ResponseEntity.ok(entity);
		 * 
		 * }
		 */
	
}