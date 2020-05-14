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

import com.synectiks.fee.domain.DueDate;
import com.synectiks.fee.repository.DueDateRepository;

@Component
public class CmsDueDateService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private DueDateRepository dueDateRepository;
    
    public List<DueDate> getDueDateListOnFilterCriteria(Map<String, String> criteriaMap){
    	DueDate dd = new DueDate();
    	boolean isFilter = false;
    	if(criteriaMap.get("id") != null) {
    		dd.setId(Long.parseLong(criteriaMap.get("id")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("paymentMethod") != null) {
    		dd.setPaymentMethod(criteriaMap.get("paymentMethod"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("installments") != null) {
    		dd.setInstallments(Long.parseLong(criteriaMap.get("installments")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("dayDesc") != null) {
    		dd.setDayDesc(criteriaMap.get("dayDesc"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("paymentDay") != null) {
    		dd.setPaymentDay(Long.parseLong(criteriaMap.get("paymentDay")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("frequency") != null) {
    		dd.setFrequency(criteriaMap.get("frequency"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("branchId") != null) {
    		dd.setBranchId(Long.parseLong(criteriaMap.get("branchId")));
    		isFilter = true;
    	}
    	
    	List<DueDate> list = null;
    	if(isFilter) {
    		list = this.dueDateRepository.findAll(Example.of(dd), Sort.by(Direction.DESC, "id"));
    	}else {
    		list = this.dueDateRepository.findAll(Sort.by(Direction.DESC, "id"));
    	}
        
    	Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
    	return list;
    }
    
    public List<DueDate> getDueDateList(Long branchId) {
    	List<DueDate> list = null;
    	if(branchId != null) {
    		DueDate dd = new DueDate();
    		dd.setBranchId(branchId);
    		list = this.dueDateRepository.findAll(Example.of(dd));
    	}else {
    		list = this.dueDateRepository.findAll();
    	}
        Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }
    
    public DueDate getDueDate(Long id){
    	Optional<DueDate> br = this.dueDateRepository.findById(id);
    	if(br.isPresent()) {
    		logger.debug("DueDate object found for the given id. "+id);
    		return br.get();
    	}
    	logger.debug("DueDate object not found for the given id. "+id+". Returning null");
        return null;
    }
    
}
