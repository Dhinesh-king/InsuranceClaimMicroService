package com.example.demo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentPlan {
	private int treatmentPlanId;
	private String packageName;
	private String testDetails;
	private Double cost;
	private String specialist;
	private Date treatmentCommencementDate;
	private Date treatmentEndDate;

	public int getTreatmentPlanId() {
		return treatmentPlanId;
	}

	public void setTreatmentPlanId(int treatmentPlanId) {
		this.treatmentPlanId = treatmentPlanId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getTestDetails() {
		return testDetails;
	}

	public void setTestDetails(String testDetails) {
		this.testDetails = testDetails;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public Date getTreatmentCommencementDate() {
		return treatmentCommencementDate;
	}

	public void setTreatmentCommencementDate(Date treatmentCommencementDate) {
		this.treatmentCommencementDate = treatmentCommencementDate;
	}

	public Date getTreatmentEndDate() {
		return treatmentEndDate;
	}

	public void setTreatmentEndDate(Date treatmentEndDate) {
		this.treatmentEndDate = treatmentEndDate;
	}

}
