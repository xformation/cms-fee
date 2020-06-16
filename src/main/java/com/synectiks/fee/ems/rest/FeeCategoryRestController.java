package com.synectiks.fee.ems.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import com.synectiks.fee.domain.enumeration.Status;
import com.synectiks.fee.repository.FeeCategoryRepository;
import com.synectiks.fee.service.util.CommonUtil;
import com.synectiks.fee.web.rest.errors.BadRequestAlertException;
import com.synectiks.fee.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.synectiks.fee.business.service.CmsFeeCategoryService;
import com.synectiks.fee.domain.FeeCategory;
import com.synectiks.fee.domain.vo.CmsFeeCategory;

import io.github.jhipster.web.util.ResponseUtil;

import javax.validation.Valid;

/**
 * REST controller for managing FeeCategory.
 */
@RestController
@RequestMapping("/api")
public class FeeCategoryRestController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String ENTITY_NAME = "feeCategory";

	@Autowired
	private CmsFeeCategoryService cmsFeeCategoryService;

    @Autowired
    private FeeCategoryRepository feeCategoryRepository;

    @PostMapping("/cmsfeecategory-bulk-load")
    public List<CmsFeeCategory> bulkLoad(@RequestBody List<CmsFeeCategory> list) throws Exception {
        List<CmsFeeCategory> failedRecords = new ArrayList<>();
        for(CmsFeeCategory cmsFeeCategory: list) {
            try {
                createFeeCategory(cmsFeeCategory);
            }catch(Exception e) {
                failedRecords.add(cmsFeeCategory);
                log.error("Exception. Saving of feeCategory failed. ", e);
            }
        }

        return failedRecords;
    }


    @PostMapping("/cmsfee-categories")
    public ResponseEntity<CmsFeeCategory> createFeeCategory(@Valid @RequestBody CmsFeeCategory cmsFeeCategory) throws Exception {
        log.debug("REST request to save a feeCategory : {}", cmsFeeCategory);
        if (cmsFeeCategory.getId() != null) {
            throw new BadRequestAlertException("A new feeCategory cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FeeCategory feeCategory = CommonUtil.createCopyProperties(cmsFeeCategory, FeeCategory.class);
        FeeCategory result = feeCategoryRepository.save(feeCategory);
        CmsFeeCategory vo = CommonUtil.createCopyProperties(feeCategory, CmsFeeCategory.class);
        return ResponseEntity.created(new URI("/api/cmsfee-categories/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(vo);
    }


    @PutMapping("/cmsfee-categories")
    public ResponseEntity<CmsFeeCategory> updateFeeCategory(@Valid @RequestBody CmsFeeCategory cmsFeeCategory) throws URISyntaxException {
        log.debug("REST request to update a feeCategory : {}", cmsFeeCategory);
        if (cmsFeeCategory.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        FeeCategory feeCategory = CommonUtil.createCopyProperties(cmsFeeCategory, FeeCategory.class);
        FeeCategory result = feeCategoryRepository.save(feeCategory);
        CmsFeeCategory vo = CommonUtil.createCopyProperties(feeCategory, CmsFeeCategory.class);
        return ResponseEntity.created(new URI("/api/cmsfee-categories/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(vo);
    }


    @GetMapping("/cmsfee-categories")
    public List<CmsFeeCategory> getAllFeeCategories(@RequestParam Map<String, String> dataMap) {
        List<FeeCategory> list = null;
        List<CmsFeeCategory> ls = null;

        FeeCategory obj = new FeeCategory();
        boolean isFilter = false;
        if(!CommonUtil.isNullOrEmpty(dataMap.get("id"))) {
            obj.setId(Long.parseLong(dataMap.get("id")));
            isFilter = true;
        }
        if(!CommonUtil.isNullOrEmpty(dataMap.get("branchId"))) {
//    		Branch branch = this.commonService.getBranchById(Long.parseLong(dataMap.get("branchId")));
            obj.setBranchId(Long.parseLong(dataMap.get("branchId")));
            isFilter = true;
        }

        if(!CommonUtil.isNullOrEmpty(dataMap.get("categoryName"))) {
            isFilter = true;
            String name = dataMap.get("categoryName");
            StringTokenizer token = new StringTokenizer(name, " ");
            int cnt = 0;
            while(token.hasMoreTokens()) {
                if(cnt == 0) {
                    obj.setCategoryName(token.nextToken());
                }
                cnt++;
            }
//        	ls = getStudentListByName(name) ;
        }
//        List<Teacher> list = null;
        if(isFilter) {
            list = this.feeCategoryRepository.findAll(Example.of(obj), Sort.by(Sort.Direction.DESC, "id"));
        }else {
            list = this.feeCategoryRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        }
        ls = new ArrayList<>();
        for(FeeCategory fc: list) {
            CmsFeeCategory vo = CommonUtil.createCopyProperties(fc, CmsFeeCategory.class);
            ls.add(vo);
        }

        return ls;
    }


    @GetMapping("/cmsfee-categories/{id}")
    public ResponseEntity<CmsFeeCategory> getFeeCategory(@PathVariable Long id) {
        log.debug("REST request to get feeCategory : {}", id);
        Optional<FeeCategory> feeCategoryDTO = feeCategoryRepository.findById(id);
        CmsFeeCategory vo = null;
        if(feeCategoryDTO.isPresent()) {
            FeeCategory fc = feeCategoryDTO.get();
            vo = CommonUtil.createCopyProperties(fc,  CmsFeeCategory.class);
        }else {
            vo = new CmsFeeCategory();
        }
        return ResponseUtil.wrapOrNotFound(Optional.of(vo));
    }

    public List<CmsFeeCategory> getFeeCategoryListByName(String name) {
        FeeCategory feeCategory = null;
        if(!CommonUtil.isNullOrEmpty(name)) {
            feeCategory = new FeeCategory();
            StringTokenizer token = new StringTokenizer(name, " ");
            int cnt = 0;
            while(token.hasMoreTokens()) {
                if(cnt == 0) {
                    feeCategory.setCategoryName(token.nextToken());
                }
                cnt++;
            }
        }
        log.debug("REST request to get FeeCategory by name : {}", name);
        List<FeeCategory> list = null;
        if(feeCategory != null) {
            list = feeCategoryRepository.findAll(Example.of(feeCategory));
        }else {
            list = Collections.emptyList();
        }

        List<CmsFeeCategory> ls = new ArrayList<>();
        for(FeeCategory st: list) {
            CmsFeeCategory vo = CommonUtil.createCopyProperties(st, CmsFeeCategory.class);
            ls.add(vo);
        }
        return ls;
    }


    @DeleteMapping("/cmsfee-categories/{id}")
    public Integer deleteFeeCategory(@PathVariable Long id) {
        log.debug("REST request to delete a FeeCategory : {}", id);
        try {
            FeeCategory st = new FeeCategory();
            st.setId(id);
//            st.setStatus(status);
            this.feeCategoryRepository.save(st);
        }catch(Exception e) {
            return HttpStatus.FAILED_DEPENDENCY.value();
        }
        return HttpStatus.OK.value();
    }
}
