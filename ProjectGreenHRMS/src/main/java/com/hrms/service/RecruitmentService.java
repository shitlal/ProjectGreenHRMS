package com.hrms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.model.CareerOppEntity;
import com.hrms.model.RecruitmentEntity;
import com.hrms.repository.CareerOppRepository;
import com.hrms.repository.RecruitmentRepository;

@Service
public class RecruitmentService 
{
	
	@Autowired
	RecruitmentRepository repository;
	
	@Autowired
	CareerOppRepository Crepository;
	

	public List<RecruitmentEntity> getAllRecruitment() {
		List<RecruitmentEntity> result = (List<RecruitmentEntity>) repository.findAll();
		if (result.size() > 0) {
			return result;

		} else {
			return new ArrayList<RecruitmentEntity>();
		}
	}

	public List<RecruitmentEntity> getAllRecruitmentByJobCode(String jobCode) {
		List<RecruitmentEntity> result =  repository.findByjobCode(jobCode);
		if (result.size() > 0) {
			return result;

		} else {
			return new ArrayList<RecruitmentEntity>();
		}
	}
	public CareerOppEntity getByJobCode(String jodCode){
		CareerOppEntity result = Crepository.findByjobCode(jodCode);
			return result;

		
	}
	//-----------------------------------------------

	public RecruitmentEntity createCandidateDetail(RecruitmentEntity Entity)
	{
		// TODO Auto-generated method stub
		System.out.println("createCandidateDetail");
		//if (Entity.getCandidateid() == null)
		{
			Entity = repository.save(Entity);
			
		
		}
		return Entity;
		
			
}
}
