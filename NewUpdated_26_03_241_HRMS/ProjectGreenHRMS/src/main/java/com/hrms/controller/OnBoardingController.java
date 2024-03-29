package com.hrms.controller;
 
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
 
import com.hrms.model.CareerOppEntity;
import com.hrms.model.OnBoardingEntity;
import com.hrms.model.RecruitmentEntity;
import com.hrms.repository.OnBoardingRepository;
import com.hrms.repository.RecruitmentRepository;
import com.hrms.service.CareerOppService;
import com.hrms.service.OnBoardingService;
import com.hrms.service.RecruitmentService;
 
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
 
@Controller
@RequestMapping("/OnBoarding")
public class OnBoardingController {
 
	@Autowired
	OnBoardingService Onboardingservice;
 
	@Autowired
	RecruitmentService recservice;
 
	@Autowired
	OnBoardingRepository onBoardingRepository;
 
	@Value("${file.upload.path}")
	private String fileUploadPath;

 
	@RequestMapping
	public String getAllCandidateDetail(Model model) {
		System.out.println("geting JobCode");
 
		List<RecruitmentEntity> list = recservice.getAllRecruitment();
		model.addAttribute("career", list);
 
		return "OnBoarding";
	}
 
	@GetMapping(path = { "search/{jobCode}" })
	@ResponseBody
	public ResponseEntity<List<RecruitmentEntity>> getWithCandidateId(Model model, @PathVariable("jobCode") Optional<String> jobCode)
 
	{
		System.out.println("jobcodeWithCandidateId" + jobCode);
 
		List<RecruitmentEntity> Recruit = Onboardingservice.getAllCandidateId(jobCode.get());

		return ResponseEntity.ok(Recruit);
	}

	@GetMapping(path = { "searches/{candidateid}" })
	@ResponseBody
	public ResponseEntity<List<RecruitmentEntity>> getWithCandidateId1(Model model,
			@PathVariable("candidateid") Optional<Integer> candidateid)
 
	{
		System.out.println("jobcodeWithCandidateIdshowingfurther" + candidateid);
 
		List<RecruitmentEntity> Recruit1 = Onboardingservice.getWithinCandidateId(candidateid.get());
 
		return ResponseEntity.ok(Recruit1);
	}

 
	
 
	@GetMapping("/EmpCreation")
	public String getEmployeeCreation(Model model) {
		// Set file paths in the OnBoardingEntity
		OnBoardingEntity onBoardingEntity = new OnBoardingEntity();
 
		OnBoardingEntity savedEntity = onBoardingRepository.save(onBoardingEntity);
		Integer empId = savedEntity.getEmployeeId();
		String employeeCode= "C0" + empId;
		// Pass the generated ID to the view
 
		onBoardingEntity.setEmployeeId(empId);
		onBoardingEntity.setEmployeeCode(employeeCode);
		//onBoardingEntity.setEmployeeCode(empId);
		model.addAttribute("OnBoard", onBoardingEntity);
		model.addAttribute("OnBoardlatest", onBoardingEntity);// Assuming OnBoardingEntity is your form model
		return "EmployeeCreation";
	}
 
	@PostMapping("/upload")
	public ResponseEntity<String> handleFileUpload(
			@RequestParam("employeeId") String employeeCode,
			@RequestParam("employeeId") Integer employeeId,
			@RequestParam("dateOfJoining") @DateTimeFormat(pattern= "yyyy-MM-dd") Date DateOfJoining,
			@RequestParam("level") String Level,
			@RequestParam("backgroundCheckStatus") String BackgroundCheckStatus,
			@RequestParam("probationPeriod") String ProbationPeriod, 
			@RequestParam("idProofpath") MultipartFile idProof,
			@RequestParam("photographPath") MultipartFile photograph,
			@RequestParam("relivingLetterPath") MultipartFile relivingLetter) {

		// Save files to the file system
		String idProofPath = saveFile(idProof, "idProof","C0"+employeeCode);
		String photographPath = saveFile(photograph, "photograph","C0"+employeeCode);
		String relivingLetterPath = saveFile(relivingLetter, "relivingLetter","C0"+employeeCode);

 
		// Set file paths in the OnBoardingEntity
		OnBoardingEntity onBoardingEntity = new OnBoardingEntity();
 
		onBoardingEntity.setEmployeeId(employeeId);
		onBoardingEntity.setEmployeeCode("C0"+employeeCode);
		onBoardingEntity.setDateOfJoining(DateOfJoining);
		onBoardingEntity.setLevel(Level);
		onBoardingEntity.setBackgroundCheckStatus(BackgroundCheckStatus);
		onBoardingEntity.setProbationPeriod(ProbationPeriod);
		onBoardingEntity.setIdProofpath(idProofPath);
		onBoardingEntity.setPhotographPath(photographPath);
		onBoardingEntity.setRelivingLetterPath(relivingLetterPath);
 
		// Save OnBoardingEntity to the database
		onBoardingRepository.save(onBoardingEntity);
 
		return ResponseEntity.ok("Files uploaded successfully!");
	}
 
 
	private String saveFile(MultipartFile file, String fileType, String employeeCode) {
	    String employeeFolderPath = fileUploadPath + File.separator + "Employee_" + employeeCode;
	    File employeeFolder = new File(employeeFolderPath);
	    if (!employeeFolder.exists()) {
	        employeeFolder.mkdirs(); // Create employee directory if it doesn't exist
	    }
	    // Dynamically create folder for the file type
	    String fileTypeFolder = employeeFolderPath + File.separator + fileType;
	    File fileTypeDir = new File(fileTypeFolder);
	    if (!fileTypeDir.exists()) {
	        fileTypeDir.mkdirs(); // Create folder for file type if it doesn't exist
	    }
	    String filePath = fileTypeFolder + File.separator + file.getOriginalFilename();
	    try {
	        // Create file within the employee ID directory
	        File newFile = new File(filePath);
	        newFile.createNewFile(); // Create the file
	        // Save file content
	        Files.copy(file.getInputStream(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return filePath;
	}
}
