package com.hrms.model;
 
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
 
@Entity
@SequenceGenerator(name = "PG_CANDIDATE_DETAIL_SEQ", sequenceName = "PG_CANDIDATE_DETAIL_SEQ", allocationSize = 1)

@Table(name = "PG_CANDIDATE_DETAIL")

public class RecruitmentEntity {

	@Id

	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PG_CANDIDATE_DETAIL_SEQ")

	@Column(name = "CANDIDATEID")

	private Integer candidateid;
 
	@Column(name = "JOB_CODE")

	private String jobCode;
 
	@Column(name = "CANDIDATENAME")

	private String candidatename;
 
	@Column(name = "CURRENT_LOCATION")

	private String current_location;
 
	@Column(name = "CAND_EXPERIENCE")

	private String cand_experience;
 
	@Column(name = "LASTINTERVIEW_ROUND")

	private String lastinterview_round;
 
	@Column(name = "SELECTION_STATUS")

	private String selection_status;

	@Column(name = "INTRVIEWSTATUS1")

	private String Interviw_status1;
	
	
	@Column(name = "PHOTO")
	private String photo;
	
	@Column(name = "RESUME")
	private String resume;
	
	@Column(name = "CANDIDATE_EMAILID")
	private String candidate_emailid;
	
	@Column(name = "CANDIDATE_CONTACTNO")
	private String candidate_contactno;
	
	@Column(name = "ID_PROOF")
	private String id_proof;
	
	@Column(name = "ROUND_1")
	private String round_1;

	public RecruitmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecruitmentEntity(Integer candidateid, String jobCode, String candidatename, String current_location,
			String cand_experience, String lastinterview_round, String selection_status, String interviw_status1,
			String photo, String resume, String candidate_emailid, String candidate_contactno, String id_proof,String round_1 ) {
		super();
		this.candidateid = candidateid;
		this.jobCode = jobCode;
		this.candidatename = candidatename;
		this.current_location = current_location;
		this.cand_experience = cand_experience;
		this.lastinterview_round = lastinterview_round;
		this.selection_status = selection_status;
		Interviw_status1 = interviw_status1;
		this.photo = photo;
		this.resume = resume;
		this.candidate_emailid = candidate_emailid;
		this.candidate_contactno = candidate_contactno;
		this.id_proof = id_proof;
		this.round_1 = round_1;
	}

	public Integer getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(Integer candidateid) {
		this.candidateid = candidateid;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
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

	public String getCand_experience() {
		return cand_experience;
	}

	public void setCand_experience(String cand_experience) {
		this.cand_experience = cand_experience;
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

	public String getInterviw_status1() {
		return Interviw_status1;
	}

	public void setInterviw_status1(String interviw_status1) {
		Interviw_status1 = interviw_status1;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getCandidate_emailid() {
		return candidate_emailid;
	}

	public void setCandidate_emailid(String candidate_emailid) {
		this.candidate_emailid = candidate_emailid;
	}

	public String getCandidate_contactno() {
		return candidate_contactno;
	}

	public void setCandidate_contactno(String candidate_contactno) {
		this.candidate_contactno = candidate_contactno;
	}

	public String getId_proof() {
		return id_proof;
	}

	public void setId_proof(String id_proof) {
		this.id_proof = id_proof;
	}
	
	

	public String getRound_1() {
		return round_1;
	}

	public void setRound_1(String round_1) {
		this.round_1 = round_1;
	}

	@Override
	public String toString() {
		return "RecruitmentEntity [candidateid=" + candidateid + ", jobCode=" + jobCode + ", candidatename="
				+ candidatename + ", current_location=" + current_location + ", cand_experience=" + cand_experience
				+ ", lastinterview_round=" + lastinterview_round + ", selection_status=" + selection_status
				+ ", Interviw_status1=" + Interviw_status1 + ", photo=" + photo + ", resume=" + resume
				+ ", candidate_emailid=" + candidate_emailid + ", candidate_contactno=" + candidate_contactno
				+ ", id_proof=" + id_proof + ",round_1=" +round_1+" ]";
	}
	
 
 
}
