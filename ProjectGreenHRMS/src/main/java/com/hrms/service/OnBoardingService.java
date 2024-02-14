package com.hrms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	OnBoardingRepository onboardRepository;
	
	public RecruitmentEntity getJobByCandidateId(String jodCode) 
	{
		System.out.println("getJobById");
		Optional<RecruitmentEntity> jobdetail = recrepository.findByjobCode(jodCode);
		
		if(jobdetail.isPresent()) {
			return jobdetail.get();
		}else {
			return null;
		}
	 
	}
	
	public List<OnBoardingEntity> getAllRecruitment() {
		List<OnBoardingEntity> result = (List<OnBoardingEntity>) onboardRepository.findAll();
		if (result.size() > 0) {
			return result;

		} else {
			return new ArrayList<OnBoardingEntity>();
		}
	}

	/*
	 * public void save(OnBoardingEntity list) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 */


}
