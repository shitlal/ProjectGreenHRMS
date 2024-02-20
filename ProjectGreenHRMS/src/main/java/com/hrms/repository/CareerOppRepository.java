package com.hrms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.kotlin.CoroutineCrudRepository;
import org.springframework.stereotype.Repository;

import com.hrms.model.CareerOppEntity;

@Repository
public interface CareerOppRepository extends JpaRepository<CareerOppEntity, Integer>{
	CareerOppEntity findByjobCode(String jobCode);
}
