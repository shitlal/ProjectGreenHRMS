package com.hrms.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;

import com.hrms.model.RecruitmentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.kotlin.CoroutineCrudRepository;

@Repository
public interface RecruitmentRepository extends JpaRepository<RecruitmentEntity, Integer>
{

}
