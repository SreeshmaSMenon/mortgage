package com.ing.mortgage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mortgage")
public class Mortgage {

	@Id
	private Long id;
	private Double amount;
	private Integer tenure;
	private Long monthlyInstallment;
	private Integer rateOfInterest;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	public Long getMonthlyInstallment() {
		return monthlyInstallment;
	}
	public void setMonthlyInstallment(Long monthlyInstallment) {
		this.monthlyInstallment = monthlyInstallment;
	}
	public Integer getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(Integer rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	
	
}
