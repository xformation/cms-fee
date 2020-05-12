package com.synectiks.fee.domain.vo;

import java.util.List;

import com.synectiks.fee.domain.Batch;
import com.synectiks.fee.domain.Department;
import com.synectiks.fee.domain.Facility;
import com.synectiks.fee.domain.Student;
import com.synectiks.fee.domain.TransportRoute;

public class FeeSetupDataCache {

//	private List<Branch> branches;
	private List<Department> departments;
	private List<Batch> batches;
//	private List<Section> sections;
	private List<Student> studentTypes;
	private List<String> genders;
	
	private List<CmsFeeDetails> feeDetails;
	private List<CmsFeeCategory> feeCategory;
	private List<Facility> facility;
	private List<TransportRoute> transportRoute;
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	public List<Batch> getBatches() {
		return batches;
	}
	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}
	public List<Student> getStudentTypes() {
		return studentTypes;
	}
	public void setStudentTypes(List<Student> studentTypes) {
		this.studentTypes = studentTypes;
	}
	public List<String> getGenders() {
		return genders;
	}
	public void setGenders(List<String> genders) {
		this.genders = genders;
	}
	public List<CmsFeeDetails> getFeeDetails() {
		return feeDetails;
	}
	public void setFeeDetails(List<CmsFeeDetails> feeDetails) {
		this.feeDetails = feeDetails;
	}
	public List<CmsFeeCategory> getFeeCategory() {
		return feeCategory;
	}
	public void setFeeCategory(List<CmsFeeCategory> feeCategory) {
		this.feeCategory = feeCategory;
	}
	public List<Facility> getFacility() {
		return facility;
	}
	public void setFacility(List<Facility> facility) {
		this.facility = facility;
	}
	public List<TransportRoute> getTransportRoute() {
		return transportRoute;
	}
	public void setTransportRoute(List<TransportRoute> transportRoute) {
		this.transportRoute = transportRoute;
	}
	
	
}
