package com.hrms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PG_CANDIDATE_DETAIL")
public class RecruitmentEntity 
{
	@Id
	/* @GeneratedValue(strategy = GenerationType.AUTO) */
	private Integer candidateid;

	

	@Column(name = "CANDIDATENAME")
	private String candidatename;

	@Column(name = "CURRENT_LOCATION")
	private String current_location;

	@Column(name = "EXPERIENCE")
	private String experience;

	@Column(name = "LASTINTERVIEW_ROUND")
	private String lastinterview_round;

	@Column(name = "SELECTION_STATUS")
	private String selection_status;

	public Integer getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(Integer candidateid) {
		this.candidateid = candidateid;
	}

	public String getCandidatename() {
		return candidatename;
	}

	public void setCandidatename(String candidatename) {
		this.candidatename = candidatename;
	}

	public String getCurrent_location() {
		return current_location;
	}

	public void setCurrent_location(String current_location) {
		this.current_location = current_location;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getLastinterview_round() {
		return lastinterview_round;
	}

	public void setLastinterview_round(String lastinterview_round) {
		this.lastinterview_round = lastinterview_round;
	}

	public String getSelection_status() {
		return selection_status;
	}

	public void setSelection_status(String selection_status) {
		this.selection_status = selection_status;
	}

	@Override
	public String toString() {
		return "RecruitmentEntity [candidateid=" + candidateid + ", candidatename=" + candidatename
				+ ", current_location=" + current_location + ", experience=" + experience + ", lastinterview_round="
				+ lastinterview_round + ", selection_status=" + selection_status + "]";
	}

	
}



