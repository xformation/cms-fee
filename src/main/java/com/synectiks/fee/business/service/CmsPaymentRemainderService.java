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

import com.synectiks.fee.domain.PaymentRemainder;
import com.synectiks.fee.repository.PaymentRemainderRepository;

@Component
public class CmsPaymentRemainderService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private PaymentRemainderRepository paymentRemainderRepository;
    
    public List<PaymentRemainder> getPaymentRemainderListOnFilterCriteria(Map<String, String> criteriaMap){
    	PaymentRemainder pr = new PaymentRemainder();
    	boolean isFilter = false;
    	if(criteriaMap.get("id") != null) {
    		pr.setId(Long.parseLong(criteriaMap.get("id")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("isAutoRemainder") != null) {
    		pr.setIsAutoRemainder(criteriaMap.get("isAutoRemainder"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("isFirstPaymentRemainder") != null) {
    		pr.setIsFirstPaymentRemainder(criteriaMap.get("isFirstPaymentRemainder"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("firstPaymentRemainderDays") != null) {
    		pr.setFirstPaymentRemainderDays(Long.parseLong(criteriaMap.get("firstPaymentRemainderDays")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("isSecondPaymentRemainder") != null) {
    		pr.setIsSecondPaymentRemainder(criteriaMap.get("isSecondPaymentRemainder"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("secondPaymentRemainderDays") != null) {
    		pr.setSecondPaymentRemainderDays(Long.parseLong(criteriaMap.get("secondPaymentRemainderDays")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("isOverDuePaymentRemainder") != null) {
    		pr.setIsOverDuePaymentRemainder(criteriaMap.get("isOverDuePaymentRemainder"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("overDuePaymentRemainderAfterDueDateOrUntilPaid") != null) {
    		pr.setOverDuePaymentRemainderAfterDueDateOrUntilPaid(criteriaMap.get("overDuePaymentRemainderAfterDueDateOrUntilPaid"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("overDuePaymentRemainderDays") != null) {
    		pr.setOverDuePaymentRemainderDays(Long.parseLong(criteriaMap.get("overDuePaymentRemainderDays")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("isRemainderRecipients") != null) {
    		pr.setIsRemainderRecipients(criteriaMap.get("isRemainderRecipients"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("remainderRecipients") != null) {
    		pr.setRemainderRecipients(criteriaMap.get("remainderRecipients"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("branchId") != null) {
    		pr.setBranchId(Long.parseLong(criteriaMap.get("branchId")));
    		isFilter = true;
    	}
    	
    	List<PaymentRemainder> list = null;
    	if(isFilter) {
    		list = this.paymentRemainderRepository.findAll(Example.of(pr), Sort.by(Direction.DESC, "id"));
    	}else {
    		list = this.paymentRemainderRepository.findAll(Sort.by(Direction.DESC, "id"));
    	}
        
    	Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
    	return list;
    }
    
    public List<PaymentRemainder> getPaymentRemainderList(Long branchId) {
    	List<PaymentRemainder> list = null;
    	if(branchId != null) {
    		PaymentRemainder pr = new PaymentRemainder();
    		pr.setBranchId(branchId);
    		list = this.paymentRemainderRepository.findAll(Example.of(pr));
    	}else {
    		list = this.paymentRemainderRepository.findAll();
    	}
        Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }
    
    public PaymentRemainder getPaymentRemainder(Long id){
    	Optional<PaymentRemainder> opr = this.paymentRemainderRepository.findById(id);
    	if(opr.isPresent()) {
    		logger.debug("PaymentRemainder object found for the given id. "+id);
    		return opr.get();
    	}
    	logger.debug("PaymentRemainder object not found for the given id. "+id+". Returning null");
        return null;
    }
    
}
