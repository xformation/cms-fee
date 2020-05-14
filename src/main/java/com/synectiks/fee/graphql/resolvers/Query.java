package com.synectiks.fee.graphql.resolvers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import com.synectiks.fee.business.service.CommonService;
import com.synectiks.fee.constant.CmsConstants;
import com.synectiks.fee.domain.Batch;
import com.synectiks.fee.domain.Branch;
import com.synectiks.fee.domain.Facility;
import com.synectiks.fee.domain.FeeCategory;
import com.synectiks.fee.domain.TransportRoute;
import com.synectiks.fee.domain.vo.CmsFeeCategory;
import com.synectiks.fee.domain.vo.CmsFeeDetails;
import com.synectiks.fee.domain.vo.CmsInvoice;
import com.synectiks.fee.domain.vo.FeeDataCache;
import com.synectiks.fee.domain.vo.FeeSetupDataCache;
import com.synectiks.fee.filter.invoice.InvoiceFilterProcessor;
import com.synectiks.fee.repository.FeeCategoryRepository;
import com.synectiks.fee.service.util.CommonUtil;
import com.synectiks.fee.service.util.DateFormatUtil;

/**
 * Query Resolver for Fee Queries
 *
 */
@Component
public class Query implements GraphQLQueryResolver {

	private final static Logger logger = LoggerFactory.getLogger(Query.class);
    
	
	@Autowired
	private InvoiceFilterProcessor invoiceFilterProcessor;
	
    @Autowired
    private CommonService commonService;
    
    @Autowired
    private FeeCategoryRepository feeCategoryRepository;
    
    public List<CmsInvoice> searchInvoiceOnType(String invoiceType, Long branchId, Long academicYearId) throws Exception{
        return Lists.newArrayList(invoiceFilterProcessor.searchInvoiceOnType(invoiceType, branchId, academicYearId));
    }

    public CmsInvoice getInvoiceData(Long branchId, Long academicYearId) {
        return invoiceFilterProcessor.getInvoiceData(branchId, academicYearId);
    }

    public FeeDataCache createFeeDataCache() throws Exception{
    	List<Branch> branchList = this.commonService.getAllBranches();
    	FeeDataCache cache = new FeeDataCache();
    	cache.setBranches(branchList);
    	return cache;
    }

    public FeeSetupDataCache createFeeSetupDataCache(Long branchId, Long academicYearId) {
    	try {
    		List<Batch> batchList = this.commonService.getAllBatches();

//        	List<CmsStudentTypeVo> studentTypeList = this.commonService.getAllStudentTypes();
//        	List<CmsGenderVo> genderList = this.commonService.getAllGenders();

        	FeeCategory f = new FeeCategory();
            f.setBranchId(branchId);
//            Example<FeeCategory> example = Example.of(f);
//            List<CmsFeeCategory> feeCategoryList =  this.commonService.getFeeCategoryForCriteria(null);
            List<FeeCategory> fcList = this.feeCategoryRepository.findAll(Example.of(f), Sort.by(Sort.Direction.DESC, "id"));
            List<CmsFeeCategory> cmsFcList = new ArrayList<>();
            for(FeeCategory ff: fcList) {
            	CmsFeeCategory cfc = CommonUtil.createCopyProperties(ff, CmsFeeCategory.class);
                if(ff.getStartDate() != null) {
                    cfc.setStrStartDate(DateFormatUtil.changeLocalDateFormat(ff.getStartDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
                    cfc.setStartDate(null);
                }
                if(ff.getEndDate() != null) {
                    cfc.setStrEndDate(DateFormatUtil.changeLocalDateFormat(ff.getEndDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
                    cfc.setEndDate(null);
                }
                if(ff.getCreatedOn() != null) {
                    cfc.setStrCreatedOn(DateFormatUtil.changeLocalDateFormat(ff.getCreatedOn(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
                    cfc.setCreatedOn(null);
                }
                if(ff.getUpdatedOn() != null) {
                    cfc.setStrUpdatedOn(DateFormatUtil.changeLocalDateFormat(ff.getUpdatedOn(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
                    cfc.setUpdatedOn(null);
                }
                cmsFcList.add(cfc);
            }
            
            List<CmsFeeDetails> feeDetailsList = this.commonService.getFeeDetailsList(fcList);
        	
            List<TransportRoute> transportRouteList = this.commonService.getTransportRoute(null);//this.transportRouteRepository.findAll();
            List<Facility> facilityList = this.commonService.getFacility(null);
            
            FeeSetupDataCache cache = new FeeSetupDataCache();
        	cache.setBatches(batchList);
        	
//        	cache.setStudentTypes(studentTypeList);
//        	cache.setGenders(genderList);
        	
        	cache.setFeeCategory(cmsFcList);
        	cache.setFeeDetails(feeDetailsList);
        	cache.setFacility(facilityList);
        	cache.setTransportRoute(transportRouteList);
        	return cache;
    	}catch(Exception e) {
    		logger.error("Exception : ",e);
    		return null;
    	}
    	
    }

}
