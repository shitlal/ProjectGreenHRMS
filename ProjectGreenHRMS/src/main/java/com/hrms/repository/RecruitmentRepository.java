package com.hrms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;

import com.hrms.model.CareerOppEntity;
import com.hrms.model.RecruitmentEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RecruitmentRepository extends JpaRepository<RecruitmentEntity, Integer>
{

	List<RecruitmentEntity> findByjobCode(String jobCode);
	RecruitmentEntity findBycandidateid(Integer candidateid);
	

}
