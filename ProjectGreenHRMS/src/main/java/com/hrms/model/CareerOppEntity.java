package com.hrms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@SequenceGenerator(name = "pg_job_detail_SEQ", sequenceName = "pg_job_detail_SEQ", allocationSize = 1)

@Table(name="PG_JOB_DETAIL")

public class CareerOppEntity {
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pg_job_detail_SEQ")
	    private Integer id;
	    
	    @Column(name="JOB_CODE")
	    private String jobCode;
	    
	    @Column(name="POSITION")
	    private String position;
	    
	    @Column(name="DESCRIPTION")
	    private String description;
	    
	    @Column(name="LOCATION")
	    private String location;

	    @Column(name="EXPERIENCE")
	    private String experience;
	    
	    @Column(name="STATUS")
	    private String status;

	    public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getJobCode() {
			return jobCode;
		}


		public void setJobCode(String jobCode) {
			this.jobCode = jobCode;
		}


		public String getPosition() {
			return position;
		}


		public void setPosition(String position) {
			this.position = position;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getLocation() {
			return location;
		}


		public void setLocation(String location) {
			this.location = location;
		}


		public String getExperience() {
			return experience;
		}


		public void setExperience(String experience) {
			this.experience = experience;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		@Override
		public String toString() {
			return "CareerOppEntity [id=" + id + ", jobCode=" + jobCode + ", position=" + position + ", description="
					+ description + ", location=" + location + ", experience=" + experience + ", status=" + status
					+ "]";
		}


		
	    
	    
	    
}
