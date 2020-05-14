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

import com.synectiks.fee.business.service.CmsLateFeeService;
import com.synectiks.fee.domain.LateFee;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing LateFee.
 */
@RestController
@RequestMapping("/api")
public class LateFeeRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CmsLateFeeService cmsLateFeeService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/latefee-by-filters")
    public List<LateFee> getLateFeeListOnFilterCriteria(@RequestParam Map<String, String> dataMap) throws Exception {
        logger.debug("Rest request to get list of latefee based on filter criteria");
        List<LateFee> list = this.cmsLateFeeService.getLateFeeListOnFilterCriteria(dataMap);
        return list;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/latefee-by-id/{id}")
    public ResponseEntity<LateFee> getLateFee(@PathVariable Long id) throws Exception {
        logger.debug("REST request to get a LateFee: {}", id);
        return ResponseUtil.wrapOrNotFound(Optional.of(this.cmsLateFeeService.getLateFee(id)));
    }
    
}
