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
public class RecruitmentService 
{
	
	@Autowired
	RecruitmentRepository repository;
	
	@Autowired
	CareerOppRepository Crepository;
	
	@Autowired
	OnBoardingRepository onBoardRepository;
	

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

	public String openInterviewBycandidatename(Integer candidateid)
	{
		RecruitmentEntity details = repository.findByCandidateid(candidateid) ;
		System.out.println(details);
		String candName=details.getCandidatename();
		System.out.println(candName);
        return candName;
    }
	
	public OnBoardingEntity getByEmployeeId(Integer employeeId) {
		// TODO Auto-generated method stub
		OnBoardingEntity details = onBoardRepository.findByEmployeeId(employeeId) ;
		
		
		return details;
	}

	public List<OnBoardingEntity> getAllOnboard()
	{
		// TODO Auto-generated method stub
		List<OnBoardingEntity> result = (List<OnBoardingEntity>) onBoardRepository.findAll();
		
		return result;
	}
	
	
//--------------Assign Candidate
	
	public RecruitmentEntity createAssigneeDetail(RecruitmentEntity entity)
	{
		// TODO Auto-generated method stub
		System.out.println("createAssigneeDetail");
	
			// update existing entry 
		RecruitmentEntity Assignee = (RecruitmentEntity) repository.findByCandidateid(entity.getCandidateid());
			
		Assignee.setAssignee1(entity.getAssignee1());
		Assignee.setInterviewdate1(entity.getInterviewdate1());
								
		Assignee = repository.save(Assignee);
				
				return Assignee;
				
		}

	
	

}






