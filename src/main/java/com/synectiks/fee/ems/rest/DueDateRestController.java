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

import com.synectiks.fee.business.service.CmsDueDateService;
import com.synectiks.fee.domain.DueDate;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing DueDate.
 */
@RestController
@RequestMapping("/api")
public class DueDateRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CmsDueDateService cmsDueDateService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/duedate-by-filters")
    public List<DueDate> getDueDateListOnFilterCriteria(@RequestParam Map<String, String> dataMap) throws Exception {
        logger.debug("Rest request to get list of duedate based on filter criteria");
        List<DueDate> list = this.cmsDueDateService.getDueDateListOnFilterCriteria(dataMap);
        return list;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/duedate-by-id/{id}")
    public ResponseEntity<DueDate> getDueDate(@PathVariable Long id) throws Exception {
        logger.debug("REST request to get a DueDate: {}", id);
        return ResponseUtil.wrapOrNotFound(Optional.of(this.cmsDueDateService.getDueDate(id)));
    }
    
}
