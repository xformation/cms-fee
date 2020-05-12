package com.synectiks.fee.graphql.resolvers;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.synectiks.fee.business.service.CommonService;
import com.synectiks.fee.constant.CmsConstants;
import com.synectiks.fee.domain.Branch;
import com.synectiks.fee.domain.DueDate;
import com.synectiks.fee.domain.Facility;
import com.synectiks.fee.domain.FeeCategory;
import com.synectiks.fee.domain.FeeDetails;
import com.synectiks.fee.domain.LateFee;
import com.synectiks.fee.domain.PaymentRemainder;
import com.synectiks.fee.domain.TransportRoute;
import com.synectiks.fee.domain.vo.CmsFeeCategory;
import com.synectiks.fee.domain.vo.CmsFeeDetails;
import com.synectiks.fee.domain.vo.CmsFeeSettingsVo;
import com.synectiks.fee.domain.vo.QueryResult;
import com.synectiks.fee.filter.invoice.InvoiceFilterProcessor;
import com.synectiks.fee.graphql.types.duedate.AbstractDueDatePayload;
import com.synectiks.fee.graphql.types.duedate.AddDueDateInput;
import com.synectiks.fee.graphql.types.duedate.AddDueDatePayload;
import com.synectiks.fee.graphql.types.duedate.UpdateDueDateInput;
import com.synectiks.fee.graphql.types.duedate.UpdateDueDatePayload;
import com.synectiks.fee.graphql.types.feecategory.AddFeeCategoryInput;
import com.synectiks.fee.graphql.types.feecategory.UpdateFeeCategoryInput;
import com.synectiks.fee.graphql.types.feedetails.AddFeeDetailsInput;
import com.synectiks.fee.graphql.types.latefee.AbstractLateFeePayload;
import com.synectiks.fee.graphql.types.latefee.AddLateFeeInput;
import com.synectiks.fee.graphql.types.latefee.AddLateFeePayload;
import com.synectiks.fee.graphql.types.latefee.UpdateLateFeeInput;
import com.synectiks.fee.graphql.types.latefee.UpdateLateFeePayload;
import com.synectiks.fee.graphql.types.paymentremainder.AbstractPaymentRemainderPayload;
import com.synectiks.fee.graphql.types.paymentremainder.AddPaymentRemainderInput;
import com.synectiks.fee.graphql.types.paymentremainder.AddPaymentRemainderPayload;
import com.synectiks.fee.graphql.types.paymentremainder.UpdatePaymentRemainderInput;
import com.synectiks.fee.graphql.types.paymentremainder.UpdatePaymentRemainderPayload;
import com.synectiks.fee.repository.DueDateRepository;
import com.synectiks.fee.repository.FeeCategoryRepository;
import com.synectiks.fee.repository.FeeDetailsRepository;
import com.synectiks.fee.repository.InvoiceRepository;
import com.synectiks.fee.repository.LateFeeRepository;
import com.synectiks.fee.repository.PaymentRemainderRepository;
import com.synectiks.fee.service.util.CommonUtil;
import com.synectiks.fee.service.util.DateFormatUtil;



@Component
public class Mutation implements GraphQLMutationResolver {

    private final static Logger logger = LoggerFactory.getLogger(Mutation.class);

    @Autowired
    CommonService commonService;


    @Autowired
    private FeeCategoryRepository feeCategoryRepository;

    @Autowired
    private FeeDetailsRepository feeDetailsRepository;

    @Autowired
    private DueDateRepository dueDateRepository;
    
    @Autowired
    private PaymentRemainderRepository paymentRemainderRepository;
    
    @Autowired
    private LateFeeRepository lateFeeRepository;
    
    @Autowired
    private InvoiceRepository invoiceRepository;
    
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private InvoiceFilterProcessor invoiceFilterProcessor;

    //Needed
    public List<CmsFeeCategory> addFeeCategory(AddFeeCategoryInput addFeeCategoryInput) throws Exception {
        FeeCategory fc = CommonUtil.createCopyProperties(addFeeCategoryInput, FeeCategory.class);
        fc.setCreatedOn(LocalDate.now());
        fc.setStartDate(DateFormatUtil.convertLocalDateFromUtilDate(addFeeCategoryInput.getStartDate()));
        fc.setEndDate(DateFormatUtil.convertLocalDateFromUtilDate(addFeeCategoryInput.getEndDate()));
        Branch branch = new Branch();
        branch.setId(addFeeCategoryInput.getBranchId());
        fc.setBranchId(addFeeCategoryInput.getBranchId());
        fc = feeCategoryRepository.save(fc);

        FeeCategory f = new FeeCategory();
//        f.setBranch(branch);
        Example<FeeCategory> example = Example.of(f);
        List<FeeCategory> list = this.feeCategoryRepository.findAll(example, Sort.by(Direction.DESC, "id"));
        List<CmsFeeCategory> ls = new ArrayList<>();
        for(FeeCategory ff: list) {
        	CmsFeeCategory cfc = CommonUtil.createCopyProperties(ff, CmsFeeCategory.class);
//        	if(ff.getStartDate() != null) {
//        		cfc.setStrStartDate(DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_dd_MM_yyyy, CmsConstants.DATE_FORMAT_yyyy_MM_dd, DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_yyyy_MM_dd, DateFormatUtil.converUtilDateFromLocaDate(ff.getStartDate()))));
//        	}
//        	if(ff.getEndDate() != null) {
//        		cfc.setStrEndDate(DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_dd_MM_yyyy, CmsConstants.DATE_FORMAT_yyyy_MM_dd, DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_yyyy_MM_dd, DateFormatUtil.converUtilDateFromLocaDate(ff.getEndDate()))));
//        	}
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
            ls.add(cfc);
        }
        return ls;
    }

    //Needed
    public List<CmsFeeCategory> updateFeeCategory(UpdateFeeCategoryInput updateFeeCategoryInput) throws ParseException, Exception {
//        FeeCategory feeCategory = feeCategoryRepository.findById(updateFeeCategoryInput.getId()).get();
        FeeCategory fc = CommonUtil.createCopyProperties(updateFeeCategoryInput, FeeCategory.class);
        fc.setUpdatedOn(LocalDate.now());
        fc.setStartDate(DateFormatUtil.convertLocalDateFromUtilDate(updateFeeCategoryInput.getStartDate()));
        fc.setEndDate(DateFormatUtil.convertLocalDateFromUtilDate(updateFeeCategoryInput.getEndDate()));
//        Branch branch = new Branch();
//        branch.setId(updateFeeCategoryInput.getBranchId());
        fc.setBranchId(updateFeeCategoryInput.getBranchId());
        fc = feeCategoryRepository.save(fc);

        FeeCategory f = new FeeCategory();
//        f.setBranch(branch);
        Example<FeeCategory> example = Example.of(f);
        List<FeeCategory> list = this.feeCategoryRepository.findAll(example, Sort.by(Direction.DESC, "id"));
        List<CmsFeeCategory> ls = new ArrayList<>();
        for(FeeCategory ff: list) {
        	CmsFeeCategory cfc = CommonUtil.createCopyProperties(ff, CmsFeeCategory.class);
//        	if(ff.getStartDate() != null) {
//        		cfc.setStrStartDate(DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_dd_MM_yyyy, CmsConstants.DATE_FORMAT_yyyy_MM_dd, DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_yyyy_MM_dd, DateFormatUtil.converUtilDateFromLocaDate(ff.getStartDate()))));
//        	}
//        	if(ff.getEndDate() != null) {
//        		cfc.setStrEndDate(DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_dd_MM_yyyy, CmsConstants.DATE_FORMAT_yyyy_MM_dd, DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_yyyy_MM_dd, DateFormatUtil.converUtilDateFromLocaDate(ff.getEndDate()))));
//        	}
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
            ls.add(cfc);
        }
        return ls;

    }

    //Needed
    public CmsFeeDetails addFeeDetails(AddFeeDetailsInput addFeeDetailsInput) throws ParseException, Exception {

    	FeeCategory feeCategory = feeCategoryRepository.findById(addFeeDetailsInput.getFeeCategoryId()).get();

        Facility facility = null;
        if(addFeeDetailsInput.getFacilityId() != null) {
//        	facility = facilityRepository.findById(addFeeDetailsInput.getFacilityId()).get();
        	facility = this.commonService.getFacilityById(addFeeDetailsInput.getFacilityId());
        }

        TransportRoute transportRoute = null;
        if(addFeeDetailsInput.getTransportRouteId() != null) {
//        	transportRoute = transportRouteRepository.findById(addFeeDetailsInput.getTransportRouteId()).get();
        	transportRoute = this.commonService.getTransportRouteById(addFeeDetailsInput.getTransportRouteId());
        }

        FeeDetails feeDetails = CommonUtil.createCopyProperties(addFeeDetailsInput, FeeDetails.class);
        feeDetails.setFeeCategory(feeCategory);
        feeDetails.setBatchId(addFeeDetailsInput.getBatchId());

        feeDetails.setFacilityId(facility.getId());
        feeDetails.setTransportRouteId(transportRoute.getId());
        feeDetails.setDepartmentId(addFeeDetailsInput.getDepartmentId());
        feeDetails.createdOn(LocalDate.now());
        feeDetails.startDate(LocalDate.now());
        feeDetails = feeDetailsRepository.save(feeDetails);
        CmsFeeDetails cfd = CommonUtil.createCopyProperties(feeDetails, CmsFeeDetails.class);
        if(feeDetails.getStartDate() != null) {
        	cfd.setStrStartDate(DateFormatUtil.changeLocalDateFormat(feeDetails.getStartDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
        	cfd.setStartDate(null);
    	}
        if(feeDetails.getEndDate() != null) {
        	cfd.setStrEndDate(DateFormatUtil.changeLocalDateFormat(feeDetails.getEndDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
        	cfd.setEndDate(null);
    	}
    	if(feeDetails.getCreatedOn() != null) {
    		cfd.setStrCreatedOn(DateFormatUtil.changeLocalDateFormat(feeDetails.getCreatedOn(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
        	cfd.setCreatedOn(null);
    	}
    	if(feeDetails.getUpdatedOn() != null) {
    		cfd.setStrUpdatedOn(DateFormatUtil.changeLocalDateFormat(feeDetails.getUpdatedOn(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
        	cfd.setUpdatedOn(null);
    	}
        return cfd;
    }

    //Needed
    public AddDueDatePayload addDueDate(AddDueDateInput addDueDateInput) {
//        College college = collegeRepository.findById(addDueDateInput.getCollegeId()).get();
//        Branch branch = branchRepository.findById((addDueDateInput.getBranchId())).get();
        DueDate dueDate = new DueDate();
        dueDate.setPaymentMethod(addDueDateInput.getPaymentMethod());
        dueDate.setInstallments(addDueDateInput.getInstallments());
        dueDate.setDayDesc(addDueDateInput.getDayDesc());
        dueDate.setPaymentDay(addDueDateInput.getPaymentDay());
        dueDate.setFrequency(addDueDateInput.getFrequency());
        dueDate.setBranchId(addDueDateInput.getBranchId());
        dueDate = dueDateRepository.save(dueDate);
        return new AddDueDatePayload(dueDate);
    }

    //Needed
    public UpdateDueDatePayload updateDueDate(UpdateDueDateInput updateDueDateInput) {
        DueDate dueDate = dueDateRepository.findById(updateDueDateInput.getId()).get();
        if (updateDueDateInput.getPaymentMethod() != null) {
            dueDate.setPaymentMethod(updateDueDateInput.getPaymentMethod());
        }
        if (updateDueDateInput.getInstallments() != null) {
            dueDate.setInstallments(updateDueDateInput.getInstallments());
        }
        if (updateDueDateInput.getDayDesc() != null) {
            dueDate.setDayDesc(updateDueDateInput.getDayDesc());
        }
        if (updateDueDateInput.getPaymentDay() != null) {
            dueDate.setPaymentDay(updateDueDateInput.getPaymentDay());
        }
        if (updateDueDateInput.getFrequency() != null) {
            dueDate.setFrequency(updateDueDateInput.getFrequency());
        }

        if (updateDueDateInput.getBranchId() != null) {
//            Branch branch = branchRepository.findById(updateDueDateInput.getBranchId()).get();
            dueDate.setBranchId(updateDueDateInput.getBranchId());

        }
        dueDateRepository.save(dueDate);
        return new UpdateDueDatePayload(dueDate);
    }

    //Needed
    public AddLateFeePayload addLateFee(AddLateFeeInput addLateFeeInput) {
//        final College college = collegeRepository.findById(addLateFeeInput.getCollegeId()).get();
//        final Branch branch = branchRepository.findById(addLateFeeInput.getBranchId()).get();
        LateFee lateFee = CommonUtil.createCopyProperties(addLateFeeInput, LateFee.class);
//        lateFee.setCollegeId(addLateFeeInput.getCollegeId());
//        lateFee.setBranchId(addLateFeeInput.getBranchId());
        lateFee = lateFeeRepository.save(lateFee);
        return new AddLateFeePayload(lateFee);
    }

    // Needed
    public UpdateLateFeePayload updateLateFee(UpdateLateFeeInput updateLateFeeInput) {
        LateFee lateFee = CommonUtil.createCopyProperties(updateLateFeeInput, LateFee.class);

//        if (updateLateFeeInput.getCollegeId() != null) {
//            final College college = collegeRepository.findById(updateLateFeeInput.getCollegeId()).get();
//            lateFee.setCollegeId(updateLateFeeInput.getCollegeId());
//        }
//
//        if (updateLateFeeInput.getBranchId() != null) {
//            final Branch branch = branchRepository.findById(updateLateFeeInput.getBranchId()).get();
//            lateFee.setBranchId(updateLateFeeInput.getBranchId());
//        }
        lateFeeRepository.save(lateFee);
        return new UpdateLateFeePayload(lateFee);
    }

    //Needed
    public AddPaymentRemainderPayload addPaymentRemainder(AddPaymentRemainderInput addPaymentRemainderInput) {
//        final College college = collegeRepository.findById(addPaymentRemainderInput.getCollegeId()).get();
//        final Branch branch = branchRepository.findById(addPaymentRemainderInput.getBranchId()).get();
        PaymentRemainder pr = CommonUtil.createCopyProperties(addPaymentRemainderInput, PaymentRemainder.class);
//        pr.setCollegeId(addPaymentRemainderInput.getCollegeId());
        pr.setBranchId(addPaymentRemainderInput.getBranchId());
        pr = paymentRemainderRepository.save(pr);
        return new AddPaymentRemainderPayload(pr);
    }

    //Needed
    public UpdatePaymentRemainderPayload updatePaymentRemainder(UpdatePaymentRemainderInput updatePaymentRemainderInput) {
        PaymentRemainder pr = CommonUtil.createCopyProperties(updatePaymentRemainderInput, PaymentRemainder.class);

//        if (updatePaymentRemainderInput.getCollegeId() != null) {
//            final College college = collegeRepository.findById(updatePaymentRemainderInput.getCollegeId()).get();
//            pr.setCollegeId(updatePaymentRemainderInput.getCollegeId());
//        }
//        if (updatePaymentRemainderInput.getBranchId() != null) {
//            final Branch branch = branchRepository.findById(updatePaymentRemainderInput.getBranchId()).get();
//            pr.setBranchId(updatePaymentRemainderInput.getBranchId());
//        }
        paymentRemainderRepository.save(pr);
        return new UpdatePaymentRemainderPayload(pr);
    }

    //Needed
	@Transactional(propagation=Propagation.REQUIRED)
	public QueryResult saveDueDatePaymentRemLateFee(UpdateDueDateInput udd, UpdatePaymentRemainderInput upr, UpdateLateFeeInput ulf) {
		QueryResult qr = new QueryResult();
		qr.setStatusCode(0);
		qr.setStatusDesc("DueDateId: #ddid#, PaymentRemainderId: #prid#, LateFeeId: #lfid#");
		AbstractDueDatePayload ddpl = null;
		AbstractPaymentRemainderPayload prpl = null;
		AbstractLateFeePayload lfpl = null;
		try {
			if(udd.getId() == -1) {
				logger.debug("Its a new record for due date. Adding due date.");
				AddDueDateInput add = CommonUtil.createCopyProperties(udd, AddDueDateInput.class);
				add.setId(null);
				ddpl = addDueDate(add);
			}else {
				logger.debug("Its an existing record for due date. Updating due date.");
				ddpl = updateDueDate(udd);
			}

			if(upr.getId() == -1) {
				logger.debug("Its a new record for payment remainder. Adding payment remainder.");
				AddPaymentRemainderInput apr = CommonUtil.createCopyProperties(upr, AddPaymentRemainderInput.class);
				apr.setId(null);
				prpl = addPaymentRemainder(apr);
			}else {
				logger.debug("Its an existing record for payment remainder. Updating payment remainder.");
				prpl = updatePaymentRemainder(upr);
			}

			if(ulf.getId() == -1) {
				logger.debug("Its a new record for late fee. Adding late fee.");
				AddLateFeeInput alf = CommonUtil.createCopyProperties(ulf, AddLateFeeInput.class);
				alf.setId(null);
				lfpl = addLateFee(alf);
			}else {
				logger.debug("Its an existing record for late fee. Updating late fee.");
				lfpl = updateLateFee(ulf);
			}

			qr.setStatusDesc(qr.getStatusDesc().replaceAll("#ddid#", String.valueOf(ddpl.getDueDate().getId())));
			qr.setStatusDesc(qr.getStatusDesc().replaceAll("#prid#", String.valueOf(prpl.getPaymentRemainder().getId())));
			qr.setStatusDesc(qr.getStatusDesc().replaceAll("#lfid#", String.valueOf(lfpl.getLateFee().getId())));
		}catch(Exception e) {
			qr.setStatusCode(1);
			qr.setStatusDesc("Due to some error due date, payment remainder and late fee could not be saved");
		}
		logger.debug("Success message : "+qr.getStatusDesc());
		return qr;
	}

	//Needed
	public CmsFeeSettingsVo getFeeSettingData(Long branchId) {
		LateFee lf = new LateFee();
		PaymentRemainder pr = new PaymentRemainder();
//		Branch branch = new Branch();
//		branch.setId(branchId);

		lf.setBranchId(branchId);
		Example<LateFee> example = Example.of(lf);
		Optional<LateFee> olf = this.lateFeeRepository.findOne(example);
		CmsFeeSettingsVo vo = new CmsFeeSettingsVo();
		if(olf.isPresent()) {
			logger.debug("Getting data for late fee");
			vo = CommonUtil.createCopyProperties(olf.get(), CmsFeeSettingsVo.class);
			vo.setLateFeeId(olf.get().getId());
		}

		pr.setBranchId(branchId);
		Example<PaymentRemainder> exPr = Example.of(pr);
		Optional<PaymentRemainder> opr = this.paymentRemainderRepository.findOne(exPr);
		if(opr.isPresent()) {
			logger.debug("Getting data for payment remainder");
			vo.setPrId(opr.get().getId());
			vo.setIsAutoRemainder(opr.get().getIsAutoRemainder());
			vo.setIsFirstPaymentRemainder(opr.get().getIsFirstPaymentRemainder());
			vo.setFirstPaymentRemainderDays(opr.get().getFirstPaymentRemainderDays());
			vo.setIsSecondPaymentRemainder(opr.get().getIsSecondPaymentRemainder());
			vo.setSecondPaymentRemainderDays(opr.get().getSecondPaymentRemainderDays());
			vo.setIsOverDuePaymentRemainder(opr.get().getIsOverDuePaymentRemainder());
			vo.setOverDuePaymentRemainderAfterDueDateOrUntilPaid(opr.get().getOverDuePaymentRemainderAfterDueDateOrUntilPaid());
			vo.setOverDuePaymentRemainderDays(opr.get().getOverDuePaymentRemainderDays());
			vo.setIsRemainderRecipients(opr.get().getIsRemainderRecipients());
			vo.setRemainderRecipients(opr.get().getRemainderRecipients());
		}
		return vo;
	}
	

	//Needed
	public CmsFeeSettingsVo getFeeSettingDueDateData(Long branchId, String paymentType) {
//		Branch branch = new Branch();
//		branch.setId(branchId);
		DueDate dueDate = new DueDate();
		dueDate.setBranchId(branchId);
		dueDate.setPaymentMethod(paymentType);

		CmsFeeSettingsVo vo = new CmsFeeSettingsVo();
		Example<DueDate> example = Example.of(dueDate);
		Optional<DueDate> odd = this.dueDateRepository.findOne(example);
		if(odd.isPresent()) {
			logger.debug("Getting data for due date");
			vo = CommonUtil.createCopyProperties(odd.get(), CmsFeeSettingsVo.class);
			vo.setDueDateId(odd.get().getId());
		}
		return vo;
	}
    
}
