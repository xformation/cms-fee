package com.synectiks.fee.domain.vo;

import java.io.Serializable;
import java.time.LocalDate;

import com.synectiks.fee.domain.AcademicYear;
import com.synectiks.fee.domain.Branch;


public class CmsFacility implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate suspandStartDate;
    private LocalDate suspandEndDate;
    private AcademicYear academicYear;
    private Branch branch;

    private String strStartDate;
    private String strEndDate;
    private String strSuspandStartDate;
    private String strSuspandEndDate;
    private Long amount;
    
    private Long academicYearId;
    private Long branchId;
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
	public AcademicYear getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public String getStrStartDate() {
		return strStartDate;
	}
	public void setStrStartDate(String strStartDate) {
		this.strStartDate = strStartDate;
	}
	public String getStrEndDate() {
		return strEndDate;
	}
	public void setStrEndDate(String strEndDate) {
		this.strEndDate = strEndDate;
	}
	public String getStrSuspandStartDate() {
		return strSuspandStartDate;
	}
	public void setStrSuspandStartDate(String strSuspandStartDate) {
		this.strSuspandStartDate = strSuspandStartDate;
	}
	public String getStrSuspandEndDate() {
		return strSuspandEndDate;
	}
	public void setStrSuspandEndDate(String strSuspandEndDate) {
		this.strSuspandEndDate = strSuspandEndDate;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
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
    
	
}
