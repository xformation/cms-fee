package com.synectiks.fee.ems.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synectiks.fee.business.service.CmsFeeCategoryService;
import com.synectiks.fee.domain.FeeCategory;
import com.synectiks.fee.domain.vo.CmsFeeCategory;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing FeeCategory.
 */
@RestController
@RequestMapping("/api")
public class FeeCategoryRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CmsFeeCategoryService cmsFeeCategoryService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/feecategory-by-filters")
    public List<FeeCategory> getFeeCategoryListOnFilterCriteria(@RequestParam Map<String, String> dataMap) throws Exception {
        logger.debug("Rest request to get list of feecategory based on filter criteria");
        List<FeeCategory> list = this.cmsFeeCategoryService.getFeeCategoryListOnFilterCriteria(dataMap);
        return list;
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/cmsfeecategory-by-filters")
    public List<CmsFeeCategory> getCmsFeeCategoryListOnFilterCriteria(@RequestParam Map<String, String> dataMap) throws Exception {
        logger.debug("Rest request to get list of cmsfeecategory based on filter criteria");
        List<CmsFeeCategory> list = this.cmsFeeCategoryService.getCmsFeeCategoryListOnFilterCriteria(dataMap);
        return list;
    }
	
    @RequestMapping(method = RequestMethod.GET, value = "/feecategory-by-id/{id}")
    public ResponseEntity<FeeCategory> getFeeCategory(@PathVariable Long id) throws Exception {
        logger.debug("REST request to get a FeeCategory: {}", id);
        return ResponseUtil.wrapOrNotFound(Optional.of(this.cmsFeeCategoryService.getFeeCategory(id)));
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/cmsfeecategory-by-id/{id}")
    public ResponseEntity<CmsFeeCategory> getCmsFeeCategory(@PathVariable Long id) throws Exception {
        logger.debug("REST request to get a CmsFeeCategory: {}", id);
        return ResponseUtil.wrapOrNotFound(Optional.of(this.cmsFeeCategoryService.getCmsFeeCategory(id)));
    }
}
