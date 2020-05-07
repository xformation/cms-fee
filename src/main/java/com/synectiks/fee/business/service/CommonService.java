package com.synectiks.fee.business.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.synectiks.fee.config.ApplicationProperties;
import com.synectiks.fee.domain.AcademicYear;
import com.synectiks.fee.domain.Batch;
import com.synectiks.fee.domain.Branch;
import com.synectiks.fee.domain.Department;
import com.synectiks.fee.domain.Section;

@Component
public class CommonService {

    private final static Logger logger = LoggerFactory.getLogger(CommonService.class);

//    @Autowired
//    private StudentRepository studentRepository;

    @Autowired
    ApplicationProperties applicationProperties;

    @Autowired
    RestTemplate restTemplate;

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

	public Section getSectionById(Long id) {
        if(id == null) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefSectionUrl = prefUrl+"/api/section-by-id/"+id;
        Section temp = this.restTemplate.getForObject(prefSectionUrl, Section.class);
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

    

}
