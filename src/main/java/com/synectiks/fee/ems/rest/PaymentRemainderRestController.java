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

import com.synectiks.fee.business.service.CmsPaymentRemainderService;
import com.synectiks.fee.domain.PaymentRemainder;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing PaymentRemainder.
 */
@RestController
@RequestMapping("/api")
public class PaymentRemainderRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CmsPaymentRemainderService cmsPaymentRemainderService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/paymentremainder-by-filters")
    public List<PaymentRemainder> getPaymentRemainderListOnFilterCriteria(@RequestParam Map<String, String> dataMap) throws Exception {
        logger.debug("Rest request to get list of paymentremainder based on filter criteria");
        List<PaymentRemainder> list = this.cmsPaymentRemainderService.getPaymentRemainderListOnFilterCriteria(dataMap);
        return list;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/paymentremainder-by-id/{id}")
    public ResponseEntity<PaymentRemainder> getPaymentRemainder(@PathVariable Long id) throws Exception {
        logger.debug("REST request to get a PaymentRemainder: {}", id);
        return ResponseUtil.wrapOrNotFound(Optional.of(this.cmsPaymentRemainderService.getPaymentRemainder(id)));
    }
    
}
