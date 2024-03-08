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
		model.addAttribute("careercount",count);
		
		//Recruitment Data 
		List<RecruitmentEntity> list1 = recservice.getAllRecruitment();
		int count1 = list1.size();
		model.addAttribute("Recruit", list1);
		
		//OnBoarding data
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
	
	@GetMapping(path = { "getCandData/{jobCode}" })
	@ResponseBody
	    public ResponseEntity<List<RecruitmentEntity>> getCandidateData(Model model, @PathVariable("jobCode") String jobCode){
	        // Your logic to fetch table data based on the selected value of the first dropdown
		List<RecruitmentEntity> listCand = recservice.getAllRecruitmentByJobCode(jobCode);
		
	        return ResponseEntity.ok(listCand);
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
		return "Recruitment";
	
	}
	 
	 // Show data in interview Rounds
		
		/*
		 * @GetMapping(path = { "interview/{candidatename}" })
		 * 
		 * @ResponseBody public ResponseEntity<RecruitmentEntity>
		 * openInterviewBycandidatename(Model model, @PathVariable("candidatename")
		 * String candidatename) { // Your logic to fetch data based on the selected
		 * value RecruitmentEntity entity =
		 * recservice.openInterviewBycandidatename(candidatename); return
		 * ResponseEntity.ok(entity); }
		 */
	 
		@GetMapping("interview/{candidateid}")
	    @ResponseBody
	    public ResponseEntity<String> openInterviewBycandidatename(Model model, @PathVariable("candidateid") Integer candidateid) {
	        // Your logic to fetch additional information based on the selected entity ID
	        String candName = recservice.openInterviewBycandidatename(candidateid);
	        return ResponseEntity.ok(candName);
	    }

		//add interview Rounds	
		
		/*
		 * @RequestMapping(path = "/AddAssignee") public String
		 * createAssigneeDetail(RecruitmentEntity AssigneeDetail)
		 * 
		 * { recservice.createCandidateDetail(AssigneeDetail); return
		 * "CloseAndRedirect"; }
		 * 
		 * @RequestMapping(path = { "/CreateAssignee" })
		 * 
		 * public String AssigneeDetail(Model model, @PathVariable("candidateid")
		 * Optional<Integer> candidateid) { RecruitmentEntity recopps = new
		 * RecruitmentEntity(); RecruitmentEntity savedEntity = recrepo.save(recopps);
		 * model.addAttribute("Recruits", recopps);
		 * 
		 * return "Recruitment";
		 * 
		 * }
		 */
		
		@RequestMapping(path = "/AddAssignee")
		public String createAssigneeDetail(RecruitmentEntity Assignee) 
		{
			System.out.println("createAssigneeDetail ");
			
			recservice.createAssigneeDetail(Assignee);
			
			return "CloseAndRedirect";
		}
		
		@RequestMapping(path = {"UpdateAddAssignee/{candidateid}"})
		public String editAssigneeBycandidateid(Model model, @PathVariable("candidateid") Optional<Integer> candidateid) 
		 
		{
			
			System.out.println("editAssigneeBycandidateid" + candidateid);
			
				 //edit="create";
				 RecruitmentEntity recruitOpp=new RecruitmentEntity();
				 RecruitmentEntity savedEntity = recrepo.save(recruitOpp);
				 model.addAttribute("Recruit", recruitOpp);
				 model.addAttribute("Recruit", savedEntity);
						
			return "Recruitment";
		}
		 
}
 
	 
	/*
	 * @RequestMapping("/interview/{candidatename}") public String
	 * openInterviewBycandidatename(Model model, @PathVariable("candidatename")
	 * Optional<String> candidatename)
	 * 
	 * {
	 * 
	 * System.out.println("openInterviewBycandidatename" + candidatename); if
	 * (candidatename.isPresent()) {
	 * 
	 * RecruitmentEntity entity =
	 * recservice.openInterviewBycandidatename(candidatename.get());
	 * model.addAttribute("Recruit", entity); model.addAttribute("candidatename",
	 * entity.getCandidatename());
	 * 
	 * // System.out.println(entity.getCandidatename());
	 * 
	 * // Pass the Candidatenames to the view
	 * 
	 * // RecruitmentEntity recopp = new RecruitmentEntity(); // //
	 * RecruitmentEntity savedEntity = recrepo.save(recopp); // String canName =
	 * savedEntity.getCandidatename(); // recopp.setCandidatename(canName); //
	 * model.addAttribute(" Recruit", recopp);
	 * 
	 * }
	 * 
	 * return "Recruitment"; }
	 */
	
	
	





