package com.synectiks.fee.business.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synectiks.fee.constant.CmsConstants;
import com.synectiks.fee.domain.AcademicYear;
import com.synectiks.fee.domain.Branch;
import com.synectiks.fee.domain.DueDate;
import com.synectiks.fee.domain.FeeCategory;
import com.synectiks.fee.domain.FeeDetails;
import com.synectiks.fee.domain.Invoice;
import com.synectiks.fee.domain.PaymentRemainder;
import com.synectiks.fee.domain.Student;
import com.synectiks.fee.domain.vo.CmsInvoice;
import com.synectiks.fee.graphql.types.invoice.AddInvoiceInput;
import com.synectiks.fee.graphql.types.invoice.AddInvoicePayload;
import com.synectiks.fee.repository.InvoiceRepository;
import com.synectiks.fee.service.util.CommonUtil;
import com.synectiks.fee.service.util.DateFormatUtil;

@Service
@Transactional
public class CmsInvoiceService {

	private final Logger logger = LoggerFactory.getLogger(CmsInvoiceService.class);

	@Autowired
	private InvoiceRepository invoiceRepository;

	@PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CommonService commonService;

    @Autowired
    private CmsFeeCategoryService cmsFeeCategoryService;

    @Autowired
    private CmsFeeDetailsService cmsFeeDetailsService;

    @Autowired
    private CmsDueDateService cmsDueDateService;

    @Autowired
    private CmsPaymentRemainderService cmsPaymentRemainderService;

    public List<Invoice> getInvoiceListOnFilterCriteria(Map<String, String> criteriaMap){
    	Invoice inv = new Invoice();
    	boolean isFilter = false;
    	if(criteriaMap.get("id") != null) {
    		inv.setId(Long.parseLong(criteriaMap.get("id")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("invoiceNumber") != null) {
    		inv.setInvoiceNumber(criteriaMap.get("invoiceNumber"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("amountPaid") != null) {
    		inv.setAmountPaid(Long.parseLong(criteriaMap.get("amountPaid")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("paymentDate") != null) {
    		inv.setPaymentDate(DateFormatUtil.convertStringToLocalDate(criteriaMap.get("paymentDate"), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
    		isFilter = true;
    	}
    	if(criteriaMap.get("nextPaymentDate") != null) {
    		inv.setNextPaymentDate(DateFormatUtil.convertStringToLocalDate(criteriaMap.get("nextPaymentDate"), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
    		isFilter = true;
    	}
    	if(criteriaMap.get("outStandingAmount") != null) {
    		inv.setOutStandingAmount(Long.parseLong(criteriaMap.get("outStandingAmount")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("modeOfPayment") != null) {
    		inv.setModeOfPayment(criteriaMap.get("modeOfPayment"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("chequeNumber") != null) {
    		inv.setChequeNumber(Long.parseLong(criteriaMap.get("chequeNumber")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("demandDraftNumber") != null) {
    		inv.setDemandDraftNumber(Long.parseLong(criteriaMap.get("demandDraftNumber")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("onlineTxnRefNumber") != null) {
    		inv.setOnlineTxnRefNumber(criteriaMap.get("onlineTxnRefNumber"));
    		isFilter = true;
    	}

    	if(criteriaMap.get("paymentStatus") != null) {
    		inv.setPaymentStatus(criteriaMap.get("paymentStatus"));
    		isFilter = true;
    	}

    	if(criteriaMap.get("comments") != null) {
    		inv.setComments(criteriaMap.get("comments"));
    		isFilter = true;
    	}

    	if(criteriaMap.get("updatedBy") != null) {
    		inv.setUpdatedBy(criteriaMap.get("updatedBy"));
    		isFilter = true;
    	}

    	if(criteriaMap.get("bank") != null) {
    		inv.setBank(criteriaMap.get("bank"));
    		isFilter = true;
    	}
    	if(criteriaMap.get("updatedOn") != null) {
    		inv.setUpdatedOn(DateFormatUtil.convertStringToLocalDate(criteriaMap.get("updatedOn"), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
    		isFilter = true;
    	}

    	if(criteriaMap.get("academicYearId") != null) {
    		inv.setAcademicYearId(Long.parseLong(criteriaMap.get("academicYearId")));
    		isFilter = true;
    	}

    	if(criteriaMap.get("branchId") != null) {
    		inv.setBranchId(Long.parseLong(criteriaMap.get("branchId")));
    		isFilter = true;
    	}

    	if(criteriaMap.get("departmentId") != null) {
    		inv.setDepartmentId(Long.parseLong(criteriaMap.get("departmentId")));
    		isFilter = true;
    	}
    	if(criteriaMap.get("studentId") != null) {
    		inv.setStudentId(Long.parseLong(criteriaMap.get("studentId")));
    		isFilter = true;
    	}

    	if(criteriaMap.get("feeCategoryId") != null) {
    		FeeCategory fc = this.cmsFeeCategoryService.getFeeCategory(Long.parseLong(criteriaMap.get("feeCategoryId")));
    		if(fc != null) {
    			inv.setFeeCategory(fc);
        		isFilter = true;
    		}
    	}

    	if(criteriaMap.get("feeDetailsId") != null) {
    		FeeDetails fd = this.cmsFeeDetailsService.getFeeDetails(Long.parseLong(criteriaMap.get("feeDetailsId")));
    		if(fd != null) {
    			inv.setFeeDetails(fd);
        		isFilter = true;
    		}
    	}

    	if(criteriaMap.get("dueDateId") != null) {
    		DueDate dd = this.cmsDueDateService.getDueDate(Long.parseLong(criteriaMap.get("dueDateId")));
    		if(dd != null) {
    			inv.setDueDate(dd);
        		isFilter = true;
    		}
    	}

    	if(criteriaMap.get("paymentRemainderId") != null) {
    		PaymentRemainder pr = this.cmsPaymentRemainderService.getPaymentRemainder(Long.parseLong(criteriaMap.get("paymentRemainderId")));
    		if(pr != null) {
    			inv.setPaymentRemainder(pr);
        		isFilter = true;
    		}
    	}

    	List<Invoice> list = null;
    	if(isFilter) {
    		logger.debug("Filter criteria object : ",inv);
    		list = this.invoiceRepository.findAll(Example.of(inv), Sort.by(Direction.DESC, "id"));
    	}else {
    		logger.debug("No filter criteria given");
    		list = this.invoiceRepository.findAll(Sort.by(Direction.DESC, "id"));
    	}

    	Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
    	return list;
    }

    public List<CmsInvoice> getCmsInvoiceListOnFilterCriteria(Map<String, String> criteriaMap){
    	List<Invoice> invList = getInvoiceListOnFilterCriteria(criteriaMap);
    	List<CmsInvoice> list = new ArrayList<>();
    	for(Invoice inv: invList) {
    		CmsInvoice cmsInv = convertInvoiceToCmsInvoice(inv);
    		list.add(cmsInv);
    	}
    	Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
    	return list;
    }

    public List<Invoice> getInvoiceList(Long branchId) {
    	List<Invoice> list = null;
    	if(branchId != null) {
    		Invoice dd = new Invoice();
    		dd.setBranchId(branchId);
    		list = this.invoiceRepository.findAll(Example.of(dd));
    		logger.debug("Invoice list found for the given branch id. "+branchId+". List : ",list);
    	}else {
    		list = this.invoiceRepository.findAll();
    	}
        Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }

    public List<CmsInvoice> getCmsInvoiceList(Long branchId) {
    	List<Invoice> invList = getInvoiceList(branchId);
    	List <CmsInvoice> list = new ArrayList<>();
    	for(Invoice inv: invList) {
    		CmsInvoice cinv = convertInvoiceToCmsInvoice(inv);
    		list.add(cinv);
    	}
    	Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }

    public Invoice getInvoice(Long id){
    	Optional<Invoice> inv = this.invoiceRepository.findById(id);
    	if(inv.isPresent()) {
    		logger.debug("Invoice object found for the given id. "+id);
    		return inv.get();
    	}
    	logger.debug("Invoice object not found for the given id. "+id+". Returning null");
        return null;
    }

    public CmsInvoice getCmsInvoice(Long id){
    	Invoice inv = getInvoice(id);
    	if(inv != null) {
    		CmsInvoice cinv = convertInvoiceToCmsInvoice(inv);
    		logger.debug("CmsInvoice object found for the given id. "+id);
    		return cinv;
    	}
    	logger.debug("CmsInvoice object not found for the given id. "+id+". Returning null");
        return null;
    }

    private CmsInvoice convertInvoiceToCmsInvoice(Invoice inv) {
    	if(inv != null) {
    		CmsInvoice cinv = CommonUtil.createCopyProperties(inv, CmsInvoice.class);
    		if(inv.getPaymentDate() != null) {
    			cinv.setStrPaymentDate(DateFormatUtil.changeLocalDateFormat(inv.getPaymentDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
    			cinv.setPaymentDate(null);
    		}
    		if(inv.getNextPaymentDate() != null) {
    			cinv.setStrNextPaymentDate(DateFormatUtil.changeLocalDateFormat(inv.getNextPaymentDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
    			cinv.setNextPaymentDate(null);
    		}
    		if(inv.getUpdatedOn() != null) {
    			cinv.setStrUpdatedOn(DateFormatUtil.changeLocalDateFormat(inv.getUpdatedOn(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
    			cinv.setUpdatedOn(null);
    		}
    		return cinv;
    	}
    	return null;
    }

	public Long getTotalInvoice(Long branchId, Long academicYearId) {
    	Long a = getTotalPaidInvoice(branchId, academicYearId);
    	Long b = getTotalUnPaidInvoice(branchId, academicYearId);
    	Long c = getTotalCanceledInvoice(branchId, academicYearId);
    	return a+b+c;
    }

    public Long getTotalPaidInvoice(Long branchId, Long academicYearId) {
    	Invoice inv = new Invoice();

//    	if(branchId != null) {
    	    //    		Branch branch = new Branch();
           //    		branch.setId(branchId);
//            Branch branch = this.commonService.getBranchById(inv.getBranchId());

//        }

//    	AcademicYear ac = new AcademicYear();
//    	ac.setId(academicYearId);
    	inv.setBranchId(branchId);
    	inv.setPaymentStatus("PAID");
    	inv.setAcademicYearId(academicYearId);
//        AcademicYear ac = this.commonService.getAcademicYearById(inv.getAcademicYearId());
    	Example<Invoice> example = Example.of(inv);
    	Long cnt = this.invoiceRepository.count(example);
    	return cnt;
    }

    public Long getTotalUnPaidInvoice(Long branchId, Long academicYearId) {
    	Invoice inv = new Invoice();

//    	if(branchId != null) {
//    		Branch branch = new Branch();
//    		branch.setId(branchId);
//            Branch branch = this.commonService.getBranchById(inv.getBranchId());

//    	}

//    	AcademicYear ac = new AcademicYear();
//    	ac.setId(academicYearId);

    	inv.setBranchId(branchId);
    	inv.setPaymentStatus("UNPAID");
//    	AcademicYear ac = this.commonService.getAcademicYearById(inv.getAcademicYearId());
    	inv.setAcademicYearId(academicYearId);
    	Example<Invoice> example = Example.of(inv);
    	Long cnt = this.invoiceRepository.count(example);
    	return cnt;
    }

    public Long getTotalCanceledInvoice(Long branchId, Long academicYearId) {
    	Invoice inv = new Invoice();

//    	if(branchId != null) {
//    		Branch branch = new Branch();
//    		branch.setId(branchId);
//            Branch branch = this.commonService.getBranchById(inv.getBranchId());

//    	}
//    	AcademicYear ac = new AcademicYear();
//    	ac.setId(academicYearId);

    	inv.setBranchId(branchId);
    	inv.setPaymentStatus("CANCELED");
//        AcademicYear ac = this.commonService.getAcademicYearById(inv.getAcademicYearId());
        inv.setAcademicYearId(academicYearId);
    	Example<Invoice> example = Example.of(inv);
    	Long cnt = this.invoiceRepository.count(example);
    	return cnt;
    }



    public List<CmsInvoice> searchInvoice(String invoiceNumber, Long studentId, Long collegeId, Long branchId, Long academicYearId) throws Exception {
    	Invoice inv = new Invoice();
//    	College college = new College();
//    	college.setId(collegeId);
//    	Branch branch = new Branch();
//    	branch.setId(branchId);
//    	AcademicYear ay  = new AcademicYear();
//    	ay.setId(academicYearId);

        Branch branch = this.commonService.getBranchById(inv.getBranchId());
        inv.setBranchId(branch.getId());
        AcademicYear ac = this.commonService.getAcademicYearById(inv.getAcademicYearId());
        inv.setAcademicYearId(ac.getId());

    	if(!CommonUtil.isNullOrEmpty(invoiceNumber)) {
    		inv.setInvoiceNumber(invoiceNumber);
    	}
    	if(studentId != null && studentId >= 0) {
    		Student student = new Student();
    		student.setId(studentId);
    		inv.setStudentId(student.getId());
    	}
    	Example<Invoice> example = Example.of(inv);
    	List<Invoice> list = this.invoiceRepository.findAll(example);
    	List<CmsInvoice> ls = new ArrayList<>();
    	for(Invoice temp: list) {
//            String stDt = DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_dd_MM_yyyy, temp.getPaymentDate());
            CmsInvoice ctm = CommonUtil.createCopyProperties(temp, CmsInvoice.class);
            ctm.setStrPaymentDate(DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_dd_MM_yyyy, CmsConstants.DATE_FORMAT_yyyy_MM_dd, DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_yyyy_MM_dd, DateFormatUtil.converUtilDateFromLocaDate(temp.getPaymentDate()))));
            ls.add(ctm);
        }
    	return ls;
    }

    public List<CmsInvoice> searchInvoiceOnType(String invoiceType, Long branchId, Long academicYearId) throws Exception {
    	Invoice inv = new Invoice();
//    	College college = new College();
//    	college.setId(collegeId);
//    	Branch branch = new Branch();
//    	branch.setId(branchId);
//    	AcademicYear ay  = new AcademicYear();
//    	ay.setId(academicYearId);

//        College college = this.commonService.getCollegeById(inv.getCollegeId());
//        inv.setCollegeId(collegeId);
//        Branch branch = this.commonService.getBranchById(inv.getBranchId());
        inv.setBranchId(branchId);
//        AcademicYear ac = this.commonService.getAcademicYearById(inv.getAcademicYearId());
        inv.setAcademicYearId(academicYearId);

    	if(!invoiceType.equalsIgnoreCase("TOTAL")) {
    		if(invoiceType.equalsIgnoreCase("PAID")) {
    			inv.setPaymentStatus("PAID");
    		}else if(invoiceType.equalsIgnoreCase("UNPAID")) {
    			inv.setPaymentStatus("UNPAID");
    		}else if(invoiceType.equalsIgnoreCase("CANCELED")) {
    			inv.setPaymentStatus("CANCELED");
    		}
    	}

    	Example<Invoice> example = Example.of(inv);
    	List<Invoice> list = this.invoiceRepository.findAll(example);
    	List<CmsInvoice> ls = new ArrayList<>();
    	for(Invoice temp: list) {
//            String stDt = DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_dd_MM_yyyy, temp.getPaymentDate());
            CmsInvoice ctm = CommonUtil.createCopyProperties(temp, CmsInvoice.class);
            ctm.setStrPaymentDate(DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_dd_MM_yyyy, CmsConstants.DATE_FORMAT_yyyy_MM_dd, DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_yyyy_MM_dd, DateFormatUtil.converUtilDateFromLocaDate(temp.getPaymentDate()))));
            ls.add(ctm);
        }
    	return ls;
    }


    public CmsInvoice getInvoiceByStudentId(Student student) {
//    	Student student = new Student();
//    	student.setStudentPrimaryEmailId(studentMailId);
//    	Optional<Student> ost = this.studentRepository.findOne(Example.of(student));
    	CmsInvoice cmsInv = null;
    	if(student != null) {
    		Invoice inv = new Invoice();
    		inv.setStudentId(student.getId());
    		List<Invoice> ls = this.invoiceRepository.findAll(Example.of(inv), Sort.by(Direction.DESC, "id"));
    		if(ls != null && ls.size() > 0) {
    			cmsInv = CommonUtil.createCopyProperties(ls.get(0), CmsInvoice.class);
    			cmsInv.setStrNextPaymentDate(DateFormatUtil.changeLocalDateFormat(ls.get(0).getNextPaymentDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
    		}else {
    			cmsInv = new CmsInvoice();
    		}
    	}
    	return cmsInv;
    }

    public Long getTotalCollectedAmount(Branch branch, AcademicYear academicYear, LocalDate dt) {
    	LocalDate lastPaymentDate = null;
    	if( dt == null) {
    		@SuppressWarnings("unchecked")
    		Object dtResult = this.entityManager.createQuery("select max(inv.paymentDate) from Invoice inv where inv.academicYearId = :ay and inv.branchId = :br ")
        			.setParameter("ay", academicYear.getId())
        			.setParameter("br", branch.getId())
        			.getSingleResult();
        	lastPaymentDate = (LocalDate)dtResult;
        	logger.debug("Last payment date: "+lastPaymentDate);
    	}

    	Object result = this.entityManager.createQuery("select sum(inv.amountPaid) from Invoice inv where inv.paymentDate = :pmtDate and inv.academicYearId = :ay and inv.branchId = :br ")
    			.setParameter("pmtDate", (dt != null ? dt : lastPaymentDate))
    			.setParameter("ay", academicYear.getId())
    			.setParameter("br", branch.getId())
    			.getSingleResult();
    	Long totalAmtCollected = (Long)result;
    	logger.debug("Total amount collected : "+totalAmtCollected);

    	return totalAmtCollected ;
    }

    public Long getTotalPendingAmount(Branch branch, AcademicYear academicYear, LocalDate dt) {
    	LocalDate lastPaymentDate = null;
    	if( dt == null) {
    		@SuppressWarnings("unchecked")
    		Object dtResult = this.entityManager.createQuery("select max(inv.paymentDate) from Invoice inv where inv.academicYearId = :ay and inv.branchId = :br ")
        			.setParameter("ay", academicYear.getId())
        			.setParameter("br", branch.getId())
        			.getSingleResult();
        	lastPaymentDate = (LocalDate)dtResult;
        	logger.debug("Last payment date: "+lastPaymentDate);
    	}

    	Object result = this.entityManager.createQuery("select sum(inv.outStandingAmount) from Invoice inv where inv.paymentDate = :pmtDate and inv.academicYearId = :ay and inv.branchId = :br ")
    			.setParameter("pmtDate", (dt != null ? dt : lastPaymentDate))
    			.setParameter("ay", academicYear.getId())
    			.setParameter("br", branch.getId())
    			.getSingleResult();
    	Long totalAmtPending = (Long)result;
    	logger.debug("Total pending amount: "+totalAmtPending);

    	return totalAmtPending ;
    }

    public Long getTotalOverDueAmount(Branch branch, AcademicYear academicYear) {
    	Object result = this.entityManager.createQuery("select sum(inv.outStandingAmount) from Invoice inv where inv.nextPaymentDate < :pmtDate and inv.academicYearId = :ay and inv.branchId = :br ")
    			.setParameter("pmtDate", LocalDate.now())
    			.setParameter("ay", academicYear.getId())
    			.setParameter("br", branch.getId())
    			.getSingleResult();
    	Long totalAmtOverDue = (Long)result;
    	logger.debug("Total over due amount: "+totalAmtOverDue);

    	return totalAmtOverDue ;
    }

    public AddInvoicePayload addInvoice(AddInvoiceInput addInvoiceInput) {
    	logger.debug("Start saving invoice");
    	Invoice invoice   = new Invoice();

    	if(addInvoiceInput.getFeeCategoryId() != null) {
    		FeeCategory feeCategory = this.cmsFeeCategoryService.getFeeCategory(addInvoiceInput.getFeeCategoryId());
        	if(feeCategory != null) {
        		invoice.setFeeCategory(feeCategory);
        	}
    	}
    	if(addInvoiceInput.getFeeDetailsId() != null) {
    		FeeDetails feeDetails = this.cmsFeeDetailsService.getFeeDetails(addInvoiceInput.getFeeDetailsId());
    		if(feeDetails != null) {
    			invoice.setFeeDetails(feeDetails);
    		}
        }
    	if(addInvoiceInput.getDueDateId() != null) {
    		DueDate dueDate = cmsDueDateService.getDueDate(addInvoiceInput.getDueDateId());
    		if(dueDate != null) {
    			invoice.setDueDate(dueDate);

    		}
    	}
    	if(addInvoiceInput.getPaymentRemainderId() != null) {
    		PaymentRemainder paymentRemainder = cmsPaymentRemainderService.getPaymentRemainder(addInvoiceInput.getPaymentRemainderId());
    		if(paymentRemainder != null) {
    			invoice.setPaymentRemainder(paymentRemainder);
    		}
    	}

//        Student student = studentRepository.findById(addInvoiceInput.getStudentId()).get();
        invoice.setStudentId(addInvoiceInput.getStudentId());
        invoice.setBranchId(addInvoiceInput.getBranchId());
        invoice.setDepartmentId(addInvoiceInput.getDepartmentId());
        invoice.setAcademicYearId(addInvoiceInput.getAcademicYearId());
        invoice.setAmountPaid(addInvoiceInput.getAmountPaid());
        invoice.setModeOfPayment(addInvoiceInput.getModeOfPayment());
        invoice.setChequeNumber(addInvoiceInput.getChequeNumber());
        invoice.setDemandDraftNumber(addInvoiceInput.getDemandDraftNumber());
        invoice.setUpdatedBy(addInvoiceInput.getUpdatedBy());
        invoice.setUpdatedOn(LocalDate.now());
        invoice.setPaymentStatus("PAID");
        Long dt = System.currentTimeMillis();
        invoice.setInvoiceNumber(String.valueOf(addInvoiceInput.getStudentId())+""+String.valueOf(dt));
        invoice.setPaymentDate(LocalDate.now());
        invoice.setBank(addInvoiceInput.getBank());
        invoice.setOutStandingAmount(addInvoiceInput.getOutStandingAmount());
        //        invoice.setNextPaymentDate();

//        invoice.setOnlineTxnRefNumber(addInvoiceInput.getOnlineTxnRefNumber());
//        invoice.setComments(addInvoiceInput.getComments());
//        invoice.setCollegeId(addInvoiceInput.getCollegeId());

        invoice = invoiceRepository.save(invoice);
        logger.debug("Invoice save successfully : "+invoice);
        return new AddInvoicePayload(invoice);
    }
}
