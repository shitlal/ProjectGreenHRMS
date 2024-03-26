
package com.hrms.model;

import java.util.Date;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.SequenceGenerator;

import jakarta.persistence.Table;

@Entity

@SequenceGenerator(name = "PG_ONBOARDING_DETAIL_SEQ", sequenceName = "PG_ONBOARDING_DETAIL_SEQ", allocationSize = 1)

@Table(name = "PG_ONBOARDING_DETAIL")

public class OnBoardingEntity {

	@Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PG_ONBOARDING_DETAIL_SEQ")

	@Column(name = "EMPLOYEEID")

	private Integer employeeId;

	@Column(name = "DATEOFJOINING")	

	private Date DateOfJoining;

	@Column(name = "EXPLEVEL")	

	private String Level;

	@Column(name = "BACKGROUNDCHECKSTATUS")

	private String BackgroundCheckStatus;

	@Column(name = "PROBATIONPERIODSTATUS")

	private String ProbationPeriod;

	@Column(name = "IDPROOF")

	private String IdProofpath;

	@Column(name = "PHOTOGRAPHLOCATION")

	private String photographPath;

	@Column(name = "RELANDEXPLETTERLOCATION")

	private String relivingLetterPath;

	@Column(name = "EMPLOYEE_CODE")

	private String employeeCode;
 
	public OnBoardingEntity() {

		super();

		// TODO Auto-generated constructor stub

	}
 
	public OnBoardingEntity(Integer employeeId, Date dateOfJoining, String level, String backgroundCheckStatus,

			String probationPeriod, String idProofpath, String photographPath, String relivingLetterPath,

			String employeeCode) {

		super();

		this.employeeId = employeeId;

		DateOfJoining = dateOfJoining;

		Level = level;

		BackgroundCheckStatus = backgroundCheckStatus;

		ProbationPeriod = probationPeriod;

		IdProofpath = idProofpath;

		this.photographPath = photographPath;

		this.relivingLetterPath = relivingLetterPath;

		this.employeeCode = employeeCode;

	}
 
	public Integer getEmployeeId() {

		return employeeId;

	}
 
	public void setEmployeeId(Integer employeeId) {

		this.employeeId = employeeId;

	}
 
	public Date getDateOfJoining() {

		return DateOfJoining;

	}
 
	public void setDateOfJoining(Date dateOfJoining) {

		DateOfJoining = dateOfJoining;

	}
 
	public String getLevel() {

		return Level;

	}
 
	public void setLevel(String level) {

		Level = level;

	}
 
	public String getBackgroundCheckStatus() {

		return BackgroundCheckStatus;

	}
 
	public void setBackgroundCheckStatus(String backgroundCheckStatus) {

		BackgroundCheckStatus = backgroundCheckStatus;

	}
 
	public String getProbationPeriod() {

		return ProbationPeriod;

	}
 
	public void setProbationPeriod(String probationPeriod) {

		ProbationPeriod = probationPeriod;

	}
 
	public String getIdProofpath() {

		return IdProofpath;

	}
 
	public void setIdProofpath(String idProofpath) {

		IdProofpath = idProofpath;

	}
 
	public String getPhotographPath() {

		return photographPath;

	}
 
	public void setPhotographPath(String photographPath) {

		this.photographPath = photographPath;

	}
 
	public String getRelivingLetterPath() {

		return relivingLetterPath;

	}
 
	public void setRelivingLetterPath(String relivingLetterPath) {

		this.relivingLetterPath = relivingLetterPath;

	}
 
	public String getEmployeeCode() {

		return employeeCode;

	}
 
	public void setEmployeeCode(String employeeCode) {

		this.employeeCode = employeeCode;

	}
 
	@Override

	public String toString() {

		return "OnBoardingEntity [employeeId=" + employeeId + ", DateOfJoining=" + DateOfJoining + ", Level=" + Level

				+ ", BackgroundCheckStatus=" + BackgroundCheckStatus + ", ProbationPeriod=" + ProbationPeriod

				+ ", IdProofpath=" + IdProofpath + ", photographPath=" + photographPath + ", relivingLetterPath="

				+ relivingLetterPath + ", employeeCode=" + employeeCode + "]";

	}
 
	

}