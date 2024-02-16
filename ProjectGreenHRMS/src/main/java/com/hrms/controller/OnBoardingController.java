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

import com.hrms.repository.OnBoardingRepository;

import com.hrms.repository.RecruitmentRepository;

import com.hrms.service.CareerOppService;

import com.hrms.service.OnBoardingService;

import com.hrms.service.RecruitmentService;
 
@Controller

@RequestMapping("/")

public class OnBoardingController {
 
	@Autowired

	OnBoardingService Onboardingservice;
 
	@Autowired

	RecruitmentService recservice;

	@Autowired

	OnBoardingRepository onBoardingRepository;
 
	/*

	 * @Value("${file.upload.path}") private String fileUploadPath;

	 */

	@RequestMapping("OnBoarding")

	public String getAllCandidateDetail(Model model) {

		System.out.println("geting JobCode");
 
		List<RecruitmentEntity> list = recservice.getAllRecruitment();

		model.addAttribute("career", list);
 
		return "OnBoarding";

	}
 
	@GetMapping(path = { "/search" })

	public String getWithCandidateId(Model model, @RequestParam String jobCode)
 
	{
 
		System.out.println("jobcodeWithCandidateId" + jobCode);

		
			RecruitmentEntity entity = Onboardingservice.getJobByCandidateId(jobCode);

			model.addAttribute("Recruit", entity);
 
			List<RecruitmentEntity> list = recservice.getAllRecruitment();

			model.addAttribute("career", list);
 
//			return RecruitmentEntity.ok(list);
		return "OnBoarding";

	}
 
	
	@GetMapping("EmpCreation")

	public String getEmployeeCreation() {

		return "EmployeeCreation";

	}
 
	/*

	 * @PostMapping("/upload") public ResponseEntity<String> handleFileUpload(

	 * 

	 * @RequestParam("idProof") MultipartFile idProof,

	 * 

	 * @RequestParam("photograph") MultipartFile photograph,

	 * 

	 * @RequestParam("relivingLetter") MultipartFile relivingLetter)

	 * 

	 * { // Save files to the file system

	 * 

	 * String idProofPath = saveFile(idProof, "idProof"); String photographPath =

	 * saveFile(photograph, "photograph"); String relivingLetterPath =

	 * saveFile(relivingLetter, "relivingLetter");

	 * 

	 * OnBoardingEntity list = new OnBoardingEntity();

	 * 

	 * list.setIdProofpath(idProofPath);; list.setPhotographPath(photographPath);

	 * list.setRelivingLetterPath(relivingLetterPath);

	 * 

	 * onBoardingRepository.save(list);

	 * 

	 * return ResponseEntity.ok("Files uploaded successfully!"); }

	 * 

	 * private String saveFile(MultipartFile file, String fileType) { String

	 * filePath = fileUploadPath + File.separator + fileType + File.separator

	 * +file.getOriginalFilename(); try { // Save the file to the specified path

	 * Files.copy(file.getInputStream(), Paths.get(filePath),

	 * StandardCopyOption.REPLACE_EXISTING); } catch (IOException e) {

	 * e.printStackTrace(); } return filePath; }

	 */
	
	
 
}