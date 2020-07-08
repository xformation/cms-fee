package com.synectiks.fee.business.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.synectiks.fee.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.synectiks.fee.config.ApplicationProperties;
import com.synectiks.fee.constant.CmsConstants;
import com.synectiks.fee.domain.vo.CmsFeeDetails;
import com.synectiks.fee.service.util.CommonUtil;
import com.synectiks.fee.service.util.DateFormatUtil;

@Component
public class CommonService<T> {

    private final static Logger logger = LoggerFactory.getLogger(CommonService.class);

//    @Autowired
//    private StudentRepository studentRepository;

    @Autowired
    ApplicationProperties applicationProperties;

    @Autowired
    RestTemplate restTemplate;

    @PersistenceContext
    private EntityManager entityManager;


    public AcademicYear getAcademicYearById(Long academicYearId) {
        if(academicYearId == null) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl()+"/api/academic-years-by-id/"+academicYearId;
        AcademicYear temp = this.restTemplate.getForObject(prefUrl, AcademicYear.class);
        return temp;
    }

    public AcademicYear getActiveAcademicYear() {
    	String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefAcademicYearUrl = prefUrl+"/api/academic-years-by-filters?status=ACTIVE";
        AcademicYear[] temp = this.restTemplate.getForObject(prefAcademicYearUrl, AcademicYear[].class);
        if(temp.length == 0) {
        	return null;
        }
        List<AcademicYear> acYearList = Arrays.asList(temp);
        Collections.sort(acYearList, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return acYearList.get(0);
    }

    public List<AcademicYear> getAcademicYear(String url) {
    	String prefUrl = applicationProperties.getPrefSrvUrl()+url;
        AcademicYear[] temp = this.restTemplate.getForObject(prefUrl, AcademicYear[].class);
        if(temp.length == 0) {
        	return null;
        }
        List<AcademicYear> acYearList = Arrays.asList(temp);
        Collections.sort(acYearList, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return acYearList;
    }

    public Branch getBranchById(Long id) {
        if(id == null) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefBranchUrl = prefUrl+"/api/branch-by-id/"+id;
        Branch temp = this.restTemplate.getForObject(prefBranchUrl, Branch.class);
        return temp;
    }
    public List<Branch> getAllBranches() {
        String prefBranchUrl = applicationProperties.getPrefSrvUrl()+"/api/branch-by-filters?status=ACTIVE";
        Branch[] temp = this.restTemplate.getForObject(prefBranchUrl, Branch[].class);
        if(temp.length == 0) {
        	return Collections.emptyList();
        }
        List<Branch> branchList = Arrays.asList(temp);
        Collections.sort(branchList, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return branchList;
  	}

	public Department getDepartmentById(Long id) {
        if(id == null) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefDepartmentUrl = prefUrl+"/api/department-by-id/"+id;
        Department temp = this.restTemplate.getForObject(prefDepartmentUrl, Department.class);
        return temp;
    }


	public Batch getBatchById(Long id) {
        if(id == null) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefBatchUrl = prefUrl+"/api/batch-by-id/"+id;
        Batch temp = this.restTemplate.getForObject(prefBatchUrl, Batch.class);
        return temp;
    }

	public List<Batch> getAllBatches() {
        logger.debug("Getting all Batches ");
	    String prefBatchUrl = applicationProperties.getPrefSrvUrl()+"/api/batch-by-filters";
	    Batch[] temp = this.restTemplate.getForObject(prefBatchUrl, Batch[].class);
	    if(temp.length == 0) {
	    	return Collections.emptyList();
	    }
	    List<Batch> batchList = Arrays.asList(temp);
	    Collections.sort(batchList, (o1, o2) -> o1.getId().compareTo(o2.getId()));
	    return batchList;
    }

	public Section getSectionById(Long id) {
        if(id == null) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefSectionUrl = prefUrl+"/api/section-by-id/"+id;
        Section temp = this.restTemplate.getForObject(prefSectionUrl, Section.class);
        return temp;
    }

	public Facility getFacilityById(Long id) {
        if(id == null) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefSectionUrl = prefUrl+"/api/facility-by-id/"+id;
        Facility temp = this.restTemplate.getForObject(prefSectionUrl, Facility.class);
        return temp;
    }
	public List<Facility> getFacility(String filters) {
		String prefUrl = applicationProperties.getPrefSrvUrl()+"/api/facility-by-filters";
		if(CommonUtil.isNullOrEmpty(filters)) {
			prefUrl = prefUrl + "?"+filters;
		}
        Facility[] temp = this.restTemplate.getForObject(prefUrl, Facility[].class);

	    if(temp.length == 0) {
	    	return Collections.emptyList();
	    }
	    List<Facility> tpList = Arrays.asList(temp);
	    Collections.sort(tpList, (o1, o2) -> o1.getId().compareTo(o2.getId()));
	    return tpList;
    }
	public TransportRoute getTransportRouteById(Long id) {
        if(id == null) {
            return null;
        }
//        String prefUrl = applicationProperties.getPrefSrvUrl();
        String url = applicationProperties.getTransportSrvUrl()+"/api/transport-route-by-id/"+id;
        TransportRoute temp = this.restTemplate.getForObject(url, TransportRoute.class);
        return temp;
    }

	public List<TransportRoute> getTransportRoute(String filters) {
		String url = applicationProperties.getTransportSrvUrl()+"/api/transport-route-by-filters";
		if(CommonUtil.isNullOrEmpty(filters)) {
			url = url + "?"+filters;
		}
        TransportRoute[] temp = this.restTemplate.getForObject(url, TransportRoute[].class);

	    if(temp.length == 0) {
	    	return Collections.emptyList();
	    }
	    List<TransportRoute> tpList = Arrays.asList(temp);
	    Collections.sort(tpList, (o1, o2) -> o1.getId().compareTo(o2.getId()));
	    return tpList;
    }

	public List<CmsFeeDetails> getFeeDetailsList(List<FeeCategory> feeCategoryList) throws ParseException, Exception{
        if(feeCategoryList.size() == 0 ) {
            logger.warn("FeeCategory list is empty. Returning empty fee details list.");
            return Collections.emptyList();
        }

        @SuppressWarnings("unchecked")
        List<FeeDetails> list = this.entityManager.createQuery("select l from FeeDetails l where l.feeCategory in (:fcList) ")
            .setParameter("fcList", feeCategoryList)
            .getResultList();

        List<CmsFeeDetails> ls = new ArrayList<>();
        for(FeeDetails ff: list) {
            CmsFeeDetails cfd = CommonUtil.createCopyProperties(ff, CmsFeeDetails.class);
            if(ff.getStartDate() != null) {
                cfd.setStrStartDate(DateFormatUtil.changeLocalDateFormat(ff.getStartDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
                cfd.setStartDate(null);
            }
            if(ff.getEndDate() != null) {
                cfd.setStrEndDate(DateFormatUtil.changeLocalDateFormat(ff.getEndDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
                cfd.setEndDate(null);
            }
            if(ff.getCreatedOn() != null) {
                cfd.setStrCreatedOn(DateFormatUtil.changeLocalDateFormat(ff.getCreatedOn(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
                cfd.setCreatedOn(null);
            }
            if(ff.getUpdatedOn() != null) {
                cfd.setStrUpdatedOn(DateFormatUtil.changeLocalDateFormat(ff.getUpdatedOn(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
                cfd.setUpdatedOn(null);
            }
            ls.add(cfd);
        }
        logger.debug("Returning list of fee details from JPA criteria query. Total records : "+list.size());
        return ls;
    }

	public List<T> getList(String url) {
		List<T> temp = this.restTemplate.getForObject(url, List.class);
        return temp;
    }

//	public List<Subject> findAllSubjectByDepartmentAndBatch(Long departmentId, Long batchId) {
//		logger.debug("Getting subjects based on department id : "+departmentId+", and batch id : "+batchId);
//	    String prefUrl = applicationProperties.getPrefSrvUrl();
//	    String prefSubjectUrl = prefUrl+"/api/subject-by-filters?departmentId="+departmentId+"&batchId="+batchId;
//	    Subject[] temp = this.restTemplate.getForObject(prefSubjectUrl, Subject[].class);
//	    if(temp.length == 0) {
//	    	return Collections.emptyList();
//	    }
//	    List<Subject> list = Arrays.asList(temp);
//	    Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
//	    return list;
//	}
//
//	public List<Subject> getAllSubject() {
//		logger.debug("Getting all subjects ");
//	    String prefUrl = applicationProperties.getPrefSrvUrl();
//	    String prefSubjectUrl = prefUrl+"/api/subject-by-filters";
//	    Subject[] temp = this.restTemplate.getForObject(prefSubjectUrl, Subject[].class);
//	    if(temp.length == 0) {
//	    	return Collections.emptyList();
//	    }
//	    List<Subject> list = Arrays.asList(temp);
//	    Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
//	    return list;
//	}
//
//    public State getStateById(Long id) {
//        if(id == null) {
//            return null;
//        }
//        Optional<State> st =  this.stateRepository.findById(id);
//        if(st.isPresent()) {
//            return st.get();
//        }
//        return null;
//    }
//
//    public City getCityById(Long id) {
//        if(id == null) {
//            return null;
//        }
//        Optional<City> ct =  this.cityRepository.findById(id);
//        if(ct.isPresent()) {
//            return ct.get();
//        }
//        return null;
//    }

    public Student getStudentById(Long id) {
        if(id == null) {
            return null;
        }
        String studenturl = applicationProperties.getStdSrvUrl();
        String stdUrl = studenturl+"/api/student-by-id/"+id;
        Student temp = this.restTemplate.getForObject(stdUrl, Student.class);
        return temp;
    }

}
