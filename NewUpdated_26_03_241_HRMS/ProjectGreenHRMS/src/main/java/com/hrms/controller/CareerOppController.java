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
import com.hrms.model.RecruitmentEntity;
import com.hrms.model.CareerOppEntity;
import com.hrms.repository.CareerOppRepository;
import com.hrms.repository.RecruitmentRepository;
import com.hrms.service.CareerOppService;
import com.hrms.service.RecruitmentService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/Career")
public class CareerOppController {
	
	@Autowired
	CareerOppService service;
	
	@Autowired
	CareerOppRepository repo;

	@Autowired
	RecruitmentService recservice;
	
	@Autowired
	RecruitmentRepository recrepo;

	@RequestMapping
	public String getAllCareerOpp(Model model) 
	{	
		System.out.println("getAllCareerOpp");
		
		List<CareerOppEntity> list = service.getAllCareerOpp();
		int count=list.size();
		model.addAttribute("career", list);
		model.addAttribute("careercount", count);
		
		return "index1";
	}
	
//	@RequestMapping("/delete/{id}")
//	public String deleteJobByJobCode(Model model, @PathVariable("id") Integer id) {
//		
//		System.out.println("deleteJobByJobCode");
//		
//		service.deleteJobById(id);
//		return "redirect:/";
//		
//	}
	
	@GetMapping("/delete/{id}")
    public String deleteEntity(@PathVariable Integer id) {
		repo.deleteById(id);
        return "redirect:/Career";  // Redirect to the page showing the list of entities
    }

	@RequestMapping(path = "/createJobDetail")
	public String createOrUpdateJobDetail(CareerOppEntity jobdetail) 
	{
		System.out.println("createJobDetail ");
		
		service.createOrUpdateJobDetail(jobdetail);
		
		return "CloseAndRedirect";
	}
	@RequestMapping(path = {"/create", "/edit/{id}"})
	public String editJobById(Model model, @PathVariable("id") Optional<Integer> id) 
							 
	{String edit=null;
		
		System.out.println("editJobById" + id);
		if (id.isPresent()) {
			 edit="edit";
			CareerOppEntity entity = service.getJobById(id.get());
			model.addAttribute("career", entity);
			model.addAttribute("createupdateid", edit);
		} else {
			 edit="create";
			 CareerOppEntity careerOpp=new CareerOppEntity();
			 CareerOppEntity savedEntity = repo.save(careerOpp);
    Integer jobId=savedEntity.getId();
    String jobCode="C0"+jobId;
		        // Pass the generated ID to the view
		        
    careerOpp.setJobCode(jobCode);
			model.addAttribute("career", careerOpp);
			model.addAttribute("createupdateid", edit);
		}
		
		
		return "CreateCareerOpp";
	}
	
	 @RequestMapping(path = "/addCandidates")
	public String createCandidateDetail(RecruitmentEntity candidatedetail)
	{
		System.out.println("CandidatesDetail ");
		
//		service.createOrUpdateJobDetail(jobdetail);
		  recservice.createCandidateDetail(candidatedetail);
		
		return "CloseAndRedirect";
	}
	
	/*
	 * @RequestMapping(path = {"/createCand"}) public String
	 * createCandidateDetail(Model model)
	 * 
	 * {
	 * 
	 * System.out.println("createCand" );
	 * 
	 * { model.addAttribute("Recruit", new RecruitmentEntity()); }
	 * 
	 * return "AddCareerOpp"; }
	 */
	 

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
		 * String getJob = savedEntity.getJobCode(); String jobCode="1"+100;
		 * 
		 * recopp.setJobCode(jobCode);
		 */
        
        recopp.setCandidateid(candidateid);
        
	  model.addAttribute("Recruit", recopp);
	  
		}
				
		return "AddCareerOpp";
	
	}
}