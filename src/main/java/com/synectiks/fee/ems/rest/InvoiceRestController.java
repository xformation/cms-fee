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

import com.synectiks.fee.business.service.CmsInvoiceService;
import com.synectiks.fee.domain.Invoice;
import com.synectiks.fee.domain.vo.CmsInvoice;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing Invoice.
 */
@RestController
@RequestMapping("/api")
public class InvoiceRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CmsInvoiceService cmsInvoiceService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/invoice-by-filters")
    public List<Invoice> getInvoiceListOnFilterCriteria(@RequestParam Map<String, String> dataMap) throws Exception {
        logger.debug("Rest request to get list of invoice based on filter criteria");
        List<Invoice> list = this.cmsInvoiceService.getInvoiceListOnFilterCriteria(dataMap);
        return list;
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/cmsinvoice-by-filters")
    public List<CmsInvoice> getCmsInvoiceListOnFilterCriteria(@RequestParam Map<String, String> dataMap) throws Exception {
        logger.debug("Rest request to get list of cmsinvoice based on filter criteria");
        List<CmsInvoice> list = this.cmsInvoiceService.getCmsInvoiceListOnFilterCriteria(dataMap);
        return list;
    }
	
    @RequestMapping(method = RequestMethod.GET, value = "/invoice-by-id/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable Long id) throws Exception {
        logger.debug("REST request to get a Invoice: {}", id);
        return ResponseUtil.wrapOrNotFound(Optional.of(this.cmsInvoiceService.getInvoice(id)));
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/cmsinvoice-by-id/{id}")
    public ResponseEntity<CmsInvoice> getCmsInvoice(@PathVariable Long id) throws Exception {
        logger.debug("REST request to get a CmsInvoice: {}", id);
        return ResponseUtil.wrapOrNotFound(Optional.of(this.cmsInvoiceService.getCmsInvoice(id)));
    }
}
