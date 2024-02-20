package com.hrms.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.model.CareerOppEntity;
import com.hrms.model.OnBoardingEntity;
import com.hrms.model.RecruitmentEntity;
import com.hrms.repository.CareerOppRepository;
import com.hrms.repository.OnBoardingRepository;
import com.hrms.repository.RecruitmentRepository;

@Service
public class OnBoardingService {
	
	@Autowired
	RecruitmentRepository  recrepository;
	
	@Autowired
	OnBoardingRepository onBoardRepository;
	

	
	
	public List<OnBoardingEntity> getAllRecruitment() {
		List<OnBoardingEntity> result = (List<OnBoardingEntity>) onBoardRepository.findAll();
		if (result.size() > 0) {
			return result;

		} else {
			return new ArrayList<OnBoardingEntity>();
		}
	}

	public List<RecruitmentEntity> getAllCandidateId(String jodCode){
		List<RecruitmentEntity> result = recrepository.findByjobCode(jodCode);
		if (result.size() > 0) {
			return result;

		} else {
			return new ArrayList<RecruitmentEntity>();
		}

	}
	


}
