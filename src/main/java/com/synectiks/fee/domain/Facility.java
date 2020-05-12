package com.synectiks.fee.domain;
import java.io.Serializable;
import java.time.LocalDate;


public class Facility implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate suspandStartDate;
    private LocalDate suspandEndDate;
    private Long academicYearId;
    private Long branchId;
    private Long amount;
    private String branchName;
    private String academicYearDesc;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalDate getSuspandStartDate() {
		return suspandStartDate;
	}
	public void setSuspandStartDate(LocalDate suspandStartDate) {
		this.suspandStartDate = suspandStartDate;
	}
	public LocalDate getSuspandEndDate() {
		return suspandEndDate;
	}
	public void setSuspandEndDate(LocalDate suspandEndDate) {
		this.suspandEndDate = suspandEndDate;
	}
	public Long getAcademicYearId() {
		return academicYearId;
	}
	public void setAcademicYearId(Long academicYearId) {
		this.academicYearId = academicYearId;
	}
	public Long getBranchId() {
		return branchId;
	}
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAcademicYearDesc() {
		return academicYearDesc;
	}
	public void setAcademicYearDesc(String academicYearDesc) {
		this.academicYearDesc = academicYearDesc;
	}
	
    
    
}
