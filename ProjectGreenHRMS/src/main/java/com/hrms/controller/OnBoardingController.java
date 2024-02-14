package com.hrms.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.model.CareerOppEntity;
import com.hrms.model.OnBoardingEntity;
import com.hrms.model.RecruitmentEntity;
import com.hrms.repository.RecruitmentRepository;
import com.hrms.service.CareerOppService;
import com.hrms.service.OnBoardingService;
import com.hrms.service.RecruitmentService;

@Controller
@RequestMapping("/OnBoarding")
public class OnBoardingController {

	@Autowired
	OnBoardingService Onboardingservice;

	@Autowired
	RecruitmentService recservice;

	/*
	 * @Value("${file.upload.path}") private String fileUploadPath;
	 */

	@RequestMapping
	public String getAllCandidateDetail(Model model) {
		System.out.println("geting JobCode");

		List<RecruitmentEntity> list = recservice.getAllRecruitment();
		model.addAttribute("career", list);

		return "OnBoarding";
	}

	@GetMapping(path = { "/search/{jobCode}" })
	public String getWithCandidateId(Model model, @PathVariable("jobCode") Optional<String> jobCode)

	{

		System.out.println("jobcodeWithCandidateId" + jobCode);
		if (jobCode.isPresent()) {

			
			  RecruitmentEntity entity =
			  Onboardingservice.getJobByCandidateId(jobCode.get());
			  model.addAttribute("Recruit", entity);
			 
			
			  List<RecruitmentEntity> list = recservice.getAllRecruitment();
			  model.addAttribute("career", list);
			 

		}

		return "OnBoarding";
	}

	@GetMapping("/EmpCreation")
	public String getEmployeeCreation() {
		return "EmployeeCreation";
	}

}