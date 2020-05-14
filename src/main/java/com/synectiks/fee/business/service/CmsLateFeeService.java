package com.synectiks.fee.business.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.synectiks.fee.domain.LateFee;
import com.synectiks.fee.repository.LateFeeRepository;

@Component
public class CmsLateFeeService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private LateFeeRepository lateFeeRepository;
    
    public List<LateFee> getLateFeeListOnFilterCriteria(Map<String, String> criteriaMap){
    	LateFee dd = new LateFee();
    	boolean isFilter = false;
    	if(criteriaMap.get("id") != null) {
    		dd.setId(Long.parseLong(criteriaMap.get("id")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("isAutoLateFee") != null) {
    		dd.setIsAutoLateFee(criteriaMap.get("isAutoLateFee"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("lateFeeDays") != null) {
    		dd.setLateFeeDays(Long.parseLong(criteriaMap.get("lateFeeDays")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("chargeType") != null) {
    		dd.setChargeType(criteriaMap.get("chargeType"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("fixedCharges") != null) {
    		dd.setFixedCharges(Long.parseLong(criteriaMap.get("fixedCharges")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("percentCharges") != null) {
    		dd.setPercentCharges(criteriaMap.get("percentCharges"));
    		isFilter = true;
    	}
    	
    	if(criteriaMap.get("lateFeeFrequency") != null) {
    		dd.setLateFeeFrequency(criteriaMap.get("lateFeeFrequency"));
    		isFilter = true;
    	}
    	
    	if(criteriaMap.get("lateFeeRepeatDays") != null) {
    		dd.setLateFeeRepeatDays(Long.parseLong(criteriaMap.get("lateFeeRepeatDays")));
    		isFilter = true;
    	}
    	
    	if(criteriaMap.get("academicYearId") != null) {
    		dd.setBranchId(Long.parseLong(criteriaMap.get("academicYearId")));
    		isFilter = true;
    	}
    	
    	if(criteriaMap.get("termId") != null) {
    		dd.setBranchId(Long.parseLong(criteriaMap.get("termId")));
    		isFilter = true;
    	}
    	
    	if(criteriaMap.get("branchId") != null) {
    		dd.setBranchId(Long.parseLong(criteriaMap.get("branchId")));
    		isFilter = true;
    	}
    	
    	List<LateFee> list = null;
    	if(isFilter) {
    		list = this.lateFeeRepository.findAll(Example.of(dd), Sort.by(Direction.DESC, "id"));
    	}else {
    		list = this.lateFeeRepository.findAll(Sort.by(Direction.DESC, "id"));
    	}
        
    	Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
    	return list;
    }
    
    public List<LateFee> getLateFeeList(Long branchId) {
    	List<LateFee> list = null;
    	if(branchId != null) {
    		LateFee dd = new LateFee();
    		dd.setBranchId(branchId);
    		list = this.lateFeeRepository.findAll(Example.of(dd));
    	}else {
    		list = this.lateFeeRepository.findAll();
    	}
        Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }
    
    public LateFee getLateFee(Long id){
    	Optional<LateFee> br = this.lateFeeRepository.findById(id);
    	if(br.isPresent()) {
    		logger.debug("LateFee object found for the given id. "+id);
    		return br.get();
    	}
    	logger.debug("LateFee object not found for the given id. "+id+". Returning null");
        return null;
    }
    
}
