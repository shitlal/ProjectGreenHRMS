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
//	public RecruitmentEntity openInterviewBycandidatename(String candidatename)
//	{
//		// TODO Auto-generated method stub
//		RecruitmentEntity details = repository.findBycandidatename(candidatename) ;
//		String candName=details.getCandidatename();
//		return details;
//	}
	public String openInterviewBycandidatename(Integer candidateid)
	{
		RecruitmentEntity details = repository.findBycandidateid(candidateid) ;
		String candName=details.getCandidatename();
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
	
	
//--------------
	public RecruitmentEntity createAssigneeDetail(RecruitmentEntity entity)
	{
		// TODO Auto-generated method stub
		System.out.println("createAssigneeDetail");
	
			// update existing entry 
			Optional<RecruitmentEntity> Detail = repository.findById(entity.getCandidateid());
			
			if(Detail.isPresent()) 
			{
				RecruitmentEntity newEntity = Detail.get();
				newEntity.setCandidatename(entity.getCandidatename());
				newEntity.setAssignee1(entity.getAssignee1());
				newEntity.setInterviewdate1(entity.getInterviewdate1());
				
				
				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
}
		
		
	
	
	/*
	 * public RecruitmentEntity createAssigneeDetail(RecruitmentEntity Entity) { //
	 * TODO Auto-generated method stub System.out.println("createCandidateDetail");
	 * //if (Entity.getCandidateid() == null) { Entity = repository.save(Entity);
	 * 
	 * } return Entity;
	 * 
	 * }
	 */

/*
 * public RecruitmentEntity openInterviewBycandidatename(String candidatename) {
 * // TODO Auto-generated method stub
 * System.out.println("openInterviewBycandidatename");
 * 
 * Optional<RecruitmentEntity> details =
 * repository.findBycandidatename(candidatename);
 * System.out.println("openInterviewBycandidatename22");
 * 
 * if(details.isPresent()) { return details.get(); } else {
 * 
 * return null; } }
 */


