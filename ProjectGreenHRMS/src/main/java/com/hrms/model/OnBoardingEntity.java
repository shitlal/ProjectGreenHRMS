package com.hrms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PG_ONBOARDING_DETAIL")
public class OnBoardingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEEID")
	private Long EmpolyeeId;

	@Column(name = "DATEOFJOINING")
	private Integer DateOfJoining;

	@Column(name = "CAND_EXPERIENCE")
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

	public OnBoardingEntity() {
		super();

	}

	public OnBoardingEntity(Long empolyeeId, Integer dateOfJoining, String level, String backgroundCheckStatus,
			String probationPeriod, String idProofpath, String photographPath, String relivingLetterPath) {
		super();
		EmpolyeeId = empolyeeId;
		DateOfJoining = dateOfJoining;
		Level = level;
		BackgroundCheckStatus = backgroundCheckStatus;
		ProbationPeriod = probationPeriod;
		this.IdProofpath = idProofpath;
		this.photographPath = photographPath;
		this.relivingLetterPath = relivingLetterPath;
	}

	public Long getEmpolyeeId() {
		return EmpolyeeId;
	}

	public void setEmpolyeeId(Long empolyeeId) {
		EmpolyeeId = empolyeeId;
	}

	public Integer getDateOfJoining() {
		return DateOfJoining;
	}

	public void setDateOfJoining(Integer dateOfJoining) {
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

	@Override
	public String toString() {
		return "OnBoardingEntity [EmpolyeeId=" + EmpolyeeId + ", DateOfJoining=" + DateOfJoining + ", Level=" + Level
				+ ", BackgroundCheckStatus=" + BackgroundCheckStatus + ", ProbationPeriod=" + ProbationPeriod
				+ ", IdProofpath=" + IdProofpath + ", photographPath=" + photographPath + ", relivingLetterPath="
				+ relivingLetterPath + "]";
	}

}
