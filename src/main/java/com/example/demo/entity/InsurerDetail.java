package com.example.demo.entity;

import java.util.function.BooleanSupplier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@ApiModel(description = "This is InsurerDetail Entiy and it will give pre-defined insurer details")
public class InsurerDetail {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer insurerDetailId;
	@Column
	private String insurerName;
	@Column
	private String insurerPackageName;
	@Column
	private Double insuranceAmountLimit;
	@Column
	private Integer disbursementDuration;

	public InsurerDetail(Integer insurerDetailId, String insurerName, String insurerPackageName,
			Double insuranceAmountLimit, Integer disbursementDuration) {
		super();
		this.insurerDetailId = insurerDetailId;
		this.insurerName = insurerName;
		this.insurerPackageName = insurerPackageName;
		this.insuranceAmountLimit = insuranceAmountLimit;
		this.disbursementDuration = disbursementDuration;
	}

	public Integer getInsurerDetailId() {
		return insurerDetailId;
	}

	public void setInsurerDetailId(Integer insurerDetailId) {
		this.insurerDetailId = insurerDetailId;
	}

	public String getInsurerName() {
		return insurerName;
	}

	public void setInsurerName(String insurerName) {
		this.insurerName = insurerName;
	}

	public String getInsurerPackageName() {
		return insurerPackageName;
	}

	public void setInsurerPackageName(String insurerPackageName) {
		this.insurerPackageName = insurerPackageName;
	}

	public Double getInsuranceAmountLimit() {
		return insuranceAmountLimit;
	}

	public void setInsuranceAmountLimit(Double insuranceAmountLimit) {
		this.insuranceAmountLimit = insuranceAmountLimit;
	}

	public Integer getDisbursementDuration() {
		return disbursementDuration;
	}

	public void setDisbursementDuration(Integer disbursementDuration) {
		this.disbursementDuration = disbursementDuration;
	}

	public InsurerDetail() {
		super();
	}

	

}
