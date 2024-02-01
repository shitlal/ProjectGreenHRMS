package com.hrms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrms.model.CareerOppEntity;
import com.hrms.service.CareerOppService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class CareerOppController {
	
	@Autowired
	CareerOppService service;

	@RequestMapping
	public String getAllCareerOpp(Model model) 
	{	
//		System.out.println("getAllCareerOpp");
		
		List<CareerOppEntity> list = service.getAllCareerOpp();
		int count=list.size();
		model.addAttribute("career", list);
		model.addAttribute("careercount", count);
		
		return "index1";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteJobByJobCode(Model model, @PathVariable("id") Integer id) {
		
		System.out.println("deleteJobByJobCode");
		
		service.deleteJobById(id);
		return "redirect:/";
		
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
			model.addAttribute("career", new CareerOppEntity());
			model.addAttribute("createupdateid", edit);
		}
		
		
		return "CreateCareerOpp";
	}
	
	@PostMapping(path = "/addCandidates")
	public String addCandidatesDetail(CareerOppEntity jobdetail)
	{
		System.out.println("addCandidatesDetail ");
		
//		service.createOrUpdateJobDetail(jobdetail);
		
		return "index1";
	}
	
	@RequestMapping(path = {"/createCand"})
	public String createCandidateDetail(Model model)
							
	{
		
		System.out.println("createCand" );
//		if (id.isPresent()) {
//			CareerOppEntity entity = service.getJobById(id.get());
//			model.addAttribute("career", entity);
//		} else {
			model.addAttribute("career", new CareerOppEntity());
//		}
		
		
		return "AddCareerOpp";
	}
	
}

