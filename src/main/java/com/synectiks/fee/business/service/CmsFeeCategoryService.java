package com.synectiks.fee.business.service;

import java.util.ArrayList;
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

import com.synectiks.fee.constant.CmsConstants;
import com.synectiks.fee.domain.FeeCategory;
import com.synectiks.fee.domain.vo.CmsFeeCategory;
import com.synectiks.fee.repository.FeeCategoryRepository;
import com.synectiks.fee.service.util.CommonUtil;
import com.synectiks.fee.service.util.DateFormatUtil;

@Component
public class CmsFeeCategoryService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private FeeCategoryRepository feeCategoryRepository;
    
    public List<FeeCategory> getFeeCategoryListOnFilterCriteria(Map<String, String> criteriaMap){
    	FeeCategory dd = new FeeCategory();
    	boolean isFilter = false;
    	if(criteriaMap.get("id") != null) {
    		dd.setId(Long.parseLong(criteriaMap.get("id")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("categoryName") != null) {
    		dd.setCategoryName(criteriaMap.get("categoryName"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("description") != null) {
    		dd.setDescription(criteriaMap.get("description"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("status") != null) {
    		dd.setStatus(criteriaMap.get("status"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("startDate") != null) {
    		dd.setStartDate(DateFormatUtil.convertStringToLocalDate(criteriaMap.get("startDate"), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
    		isFilter = true;
    	}
    	if(criteriaMap.get("endDate") != null) {
    		dd.setEndDate(DateFormatUtil.convertStringToLocalDate(criteriaMap.get("endDate"), CmsConstants.DATE_FORMAT_dd_MM_yyyy ));
    		isFilter = true;
    	}
    	if(criteriaMap.get("branchId") != null) {
    		dd.setBranchId(Long.parseLong(criteriaMap.get("branchId")));
    		isFilter = true;
    	}
    	
    	if(criteriaMap.get("createdBy") != null) {
    		dd.setCreatedBy(criteriaMap.get("createdBy"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("createdOn") != null) {
    		dd.setCreatedOn(DateFormatUtil.convertStringToLocalDate(criteriaMap.get("createdOn"), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
    		isFilter = true;
    	}
    	if(criteriaMap.get("updatedBy") != null) {
    		dd.setUpdatedBy(criteriaMap.get("updatedBy"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("updatedOn") != null) {
    		dd.setUpdatedOn(DateFormatUtil.convertStringToLocalDate(criteriaMap.get("updatedOn"), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
    		isFilter = true;
    	}
    	
    	List<FeeCategory> list = null;
    	if(isFilter) {
    		list = this.feeCategoryRepository.findAll(Example.of(dd), Sort.by(Direction.DESC, "id"));
    	}else {
    		list = this.feeCategoryRepository.findAll(Sort.by(Direction.DESC, "id"));
    	}
        
    	Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
    	return list;
    }
    
    public List<CmsFeeCategory> getCmsFeeCategoryListOnFilterCriteria(Map<String, String> criteriaMap){
    	List<FeeCategory> fcList =  this.getFeeCategoryListOnFilterCriteria(criteriaMap);
    	List<CmsFeeCategory> list = new ArrayList<>();
    	for(FeeCategory fc: fcList) {
    		CmsFeeCategory cfc = convertFeeCategoryToCmsFeeCategory(fc);
    		logger.debug("getCmsFeeCategoryListOnFilterCriteria() - CmsFeeCategory object : ",cfc);
    		list.add(cfc);
    	}
    	Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
    	return list;
    }
    
    public List<FeeCategory> getFeeCategoryList(Long branchId) {
    	List<FeeCategory> list = null;
    	if(branchId != null) {
    		FeeCategory dd = new FeeCategory();
    		dd.setBranchId(branchId);
    		list = this.feeCategoryRepository.findAll(Example.of(dd));
    	}else {
    		list = this.feeCategoryRepository.findAll();
    	}
        Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }
    
    public List<CmsFeeCategory> getCmsFeeCategoryList(Long branchId) {
    	List<FeeCategory> fcList = getFeeCategoryList(branchId);
    	List<CmsFeeCategory> list = new ArrayList<>();
    	for(FeeCategory fc: fcList) {
    		CmsFeeCategory cfc = convertFeeCategoryToCmsFeeCategory(fc);
    		logger.debug("getCmsFeeCategoryList() - CmsFeeCategory object : ",cfc);
        	list.add(cfc);
    	}
        Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }
    
    public FeeCategory getFeeCategory(Long id){
    	Optional<FeeCategory> br = this.feeCategoryRepository.findById(id);
    	if(br.isPresent()) {
    		logger.debug("FeeCategory object found for the given id. "+id);
    		return br.get();
    	}
    	logger.debug("FeeCategory object not found for the given id. "+id+". Returning null");
        return null;
    }
    
    public CmsFeeCategory getCmsFeeCategory(Long id){
    	FeeCategory fc = getFeeCategory(id);
    	CmsFeeCategory cfc = convertFeeCategoryToCmsFeeCategory(fc);
    	logger.debug("getCmsFeeCategory() - CmsFeeCategory object : ",cfc);
    	return cfc;
    }
    
    private CmsFeeCategory convertFeeCategoryToCmsFeeCategory(FeeCategory fc) {
    	if(fc != null) {
    		CmsFeeCategory cfc = CommonUtil.createCopyProperties(fc, CmsFeeCategory.class);
    		if(fc.getCreatedOn() != null) {
    			cfc.setStrCreatedOn(DateFormatUtil.changeLocalDateFormat(fc.getCreatedOn(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
    			cfc.setCreatedOn(null);
    		}
    		if(fc.getUpdatedOn() != null) {
    			cfc.setStrUpdatedOn(DateFormatUtil.changeLocalDateFormat(fc.getUpdatedOn(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
    			cfc.setUpdatedOn(null);
    		}
    		if(fc.getStartDate() != null) {
    			cfc.setStrStartDate(DateFormatUtil.changeLocalDateFormat(fc.getStartDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
    			cfc.setStartDate(null);
    		}
    		if(fc.getEndDate() != null) {
    			cfc.setStrEndDate(DateFormatUtil.changeLocalDateFormat(fc.getEndDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
    			cfc.setEndDate(null);
    		}
    		return cfc;
    	}
    	return null;
    }
}
