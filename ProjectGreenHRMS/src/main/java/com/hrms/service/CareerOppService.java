package com.hrms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.model.CareerOppEntity;
import com.hrms.repository.CareerOppRepository;

@Service
public class CareerOppService {

	@Autowired
	CareerOppRepository repository;
	public List<CareerOppEntity> getAllCareerOpp()
	{
//		System.out.println("getAllCareerOpp");
		List<CareerOppEntity> result = (List<CareerOppEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<CareerOppEntity>();
		}
	}
	
	public void deleteJobById(Integer id) {
		System.out.println("deleteJobById");
		
		Optional<CareerOppEntity> jobdetail=repository.findById(id);
		
		if(jobdetail.isPresent()) {
			
			repository.deleteById(id);
		}else {
			System.out.println("No employee record exist for given id");
		}
	}
	
	public CareerOppEntity createOrUpdateJobDetail(CareerOppEntity entity) 
	{
		System.out.println("createOrUpdateJobDetail");
		// Create new entry 
		if(entity.getId()  == null) 
		{
			//entity.setId(8);
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			// update existing entry 
			Optional<CareerOppEntity> jobDetail = repository.findById(entity.getId());
			
			if(jobDetail.isPresent()) 
			{
				CareerOppEntity newEntity = jobDetail.get();
				newEntity.setJobCode(entity.getJobCode());
				newEntity.setPosition(entity.getPosition());
				newEntity.setLocation(entity.getLocation());
				newEntity.setDescription(entity.getDescription());
				newEntity.setExperience(entity.getExperience());
				
				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	}
	
	public CareerOppEntity getJobById(Integer id) 
	{
		System.out.println("getJobById");
		Optional<CareerOppEntity> jobdetail = repository.findById(id);
		
		if(jobdetail.isPresent()) {
			return jobdetail.get();
		}else {
			return null;
		}
	 
	}

}
