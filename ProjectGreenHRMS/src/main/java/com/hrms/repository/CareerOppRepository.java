package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.kotlin.CoroutineCrudRepository;
import org.springframework.stereotype.Repository;

import com.hrms.model.CareerOppEntity;

@Repository
public interface CareerOppRepository extends JpaRepository<CareerOppEntity, Integer>{

}
