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

import com.synectiks.fee.business.service.CmsFeeDetailsService;
import com.synectiks.fee.domain.FeeDetails;
import com.synectiks.fee.domain.vo.CmsFeeDetails;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing FeeDetails.
 */
@RestController
@RequestMapping("/api")
public class FeeDetailsRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CmsFeeDetailsService cmsFeeDetailsService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/feedetails-by-filters")
    public List<FeeDetails> getFeeDetailsListOnFilterCriteria(@RequestParam Map<String, String> dataMap) throws Exception {
        logger.debug("Rest request to get list of feedetails based on filter criteria");
        List<FeeDetails> list = this.cmsFeeDetailsService.getFeeDetailsListOnFilterCriteria(dataMap);
        return list;
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/cmsfeedetails-by-filters")
    public List<CmsFeeDetails> getCmsFeeDetailsListOnFilterCriteria(@RequestParam Map<String, String> dataMap) throws Exception {
        logger.debug("Rest request to get list of cmsfeedetails based on filter criteria");
        List<CmsFeeDetails> list = this.cmsFeeDetailsService.getCmsFeeDetailsListOnFilterCriteria(dataMap);
        return list;
    }
	
    @RequestMapping(method = RequestMethod.GET, value = "/feedetails-by-id/{id}")
    public ResponseEntity<FeeDetails> getFeeDetails(@PathVariable Long id) throws Exception {
        logger.debug("REST request to get a FeeDetails: {}", id);
        return ResponseUtil.wrapOrNotFound(Optional.of(this.cmsFeeDetailsService.getFeeDetails(id)));
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/cmsfeedetails-by-id/{id}")
    public ResponseEntity<CmsFeeDetails> getCmsFeeDetails(@PathVariable Long id) throws Exception {
        logger.debug("REST request to get a CmsFeeDetails: {}", id);
        return ResponseUtil.wrapOrNotFound(Optional.of(this.cmsFeeDetailsService.getCmsFeeDetails(id)));
    }
}
