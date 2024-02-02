package com.hrms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.model.RecruitmentEntity;
import com.hrms.repository.RecruitmentRepository;

@Service
public class RecruitmentService 
{

	@Autowired
	RecruitmentRepository repository;

	public List<RecruitmentEntity> getAllRecruitment() {
		List<RecruitmentEntity> result = (List<RecruitmentEntity>) repository.findAll();
		if (result.size() > 0) {
			return result;

		} else {
			return new ArrayList<RecruitmentEntity>();
		}
	}

}
