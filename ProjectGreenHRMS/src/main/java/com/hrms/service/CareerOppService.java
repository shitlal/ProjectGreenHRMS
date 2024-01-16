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

}
