package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@ApiModel(description = "This is InitiateClaim Entiy")
public class InitiateClaim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer initiateClaimId;
	@Column
	private String patientName;
	@Column
	private String ailment;
	@Column
	private String treatmentPackageName;
	@Column
	private String insurerName;
	public Integer getInitiateClaimId() {
		return initiateClaimId;
	}
	public void setInitiateClaimId(Integer initiateClaimId) {
		this.initiateClaimId = initiateClaimId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getAilment() {
		return ailment;
	}
	public void setAilment(String ailment) {
		this.ailment = ailment;
	}
	public String getTreatmentPackageName() {
		return treatmentPackageName;
	}
	public void setTreatmentPackageName(String treatmentPackageName) {
		this.treatmentPackageName = treatmentPackageName;
	}
	public String getInsurerName() {
		return insurerName;
	}
	public void setInsurerName(String insurerName) {
		this.insurerName = insurerName;
	}
	public InitiateClaim(Integer initiateClaimId, String patientName, String ailment, String treatmentPackageName,
			String insurerName) {
		super();
		this.initiateClaimId = initiateClaimId;
		this.patientName = patientName;
		this.ailment = ailment;
		this.treatmentPackageName = treatmentPackageName;
		this.insurerName = insurerName;
	}
	
	public InitiateClaim() {
		super();
	}
	
}
