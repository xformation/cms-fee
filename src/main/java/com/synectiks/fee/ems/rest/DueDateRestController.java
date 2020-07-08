package com.synectiks.fee.ems.rest;

import com.synectiks.fee.business.service.CmsDueDateService;
import com.synectiks.fee.domain.DueDate;
import com.synectiks.fee.domain.FeeCategory;
import com.synectiks.fee.repository.DueDateRepository;
import com.synectiks.fee.service.util.CommonUtil;
import com.synectiks.fee.web.rest.errors.BadRequestAlertException;
import com.synectiks.fee.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

/**
 * REST controller for managing DueDate.
 */
@RestController
@RequestMapping("/api")
public class DueDateRestController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String ENTITY_NAME = "due_date";


    @Autowired
    private DueDateRepository duedateRepository;

    @Autowired
    private CmsDueDateService cmsDueDateService;

    @PostMapping("/cmsduedate-bulk-load")
    public List<DueDate> bulkLoad(@RequestBody List<DueDate> list) throws Exception {
        List<DueDate> failedRecords = new ArrayList<>();
        for (DueDate dueDate : list) {
            try {
                createDueDate(dueDate);
            } catch (Exception e) {
                failedRecords.add(dueDate);
                log.error("Exception. Saving of feeCategory failed. ", e);
            }
        }

        return failedRecords;
    }


    @PostMapping("/cmsduedates")
    public ResponseEntity<DueDate> createDueDate(@Valid @RequestBody DueDate dueDate) throws Exception {
        log.debug("REST request to save a duedate : {}", dueDate);
        if (dueDate.getId() != null) {
            throw new BadRequestAlertException("A new feeCategory cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DueDate duedate = CommonUtil.createCopyProperties(dueDate, DueDate.class);
        DueDate result = duedateRepository.save(dueDate);
        DueDate vo = CommonUtil.createCopyProperties(dueDate, DueDate.class);
        return ResponseEntity.created(new URI("/api/cmsduedates/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(vo);
    }


    @PutMapping("/cmsduedates")
    public ResponseEntity<DueDate> updateDueDate(@Valid @RequestBody DueDate dueDate) throws URISyntaxException {
        log.debug("REST request to update a duedate : {}", dueDate);
        if (dueDate.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DueDate duedate = CommonUtil.createCopyProperties(dueDate, DueDate.class);
        DueDate result = duedateRepository.save(dueDate);
        DueDate vo = CommonUtil.createCopyProperties(dueDate, DueDate.class);
        return ResponseEntity.created(new URI("/api/cmsduedates/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(vo);
    }


    @GetMapping("/cmsduedates")
    public List<DueDate> getAllDueDates(@RequestParam Map<String, String> dataMap) {
        List<DueDate> list = null;
        List<DueDate> ls = null;

        DueDate obj = new DueDate();
        boolean isFilter = false;
        if (!CommonUtil.isNullOrEmpty(dataMap.get("id"))) {
            obj.setId(Long.parseLong(dataMap.get("id")));
            isFilter = true;
        }
        if (!CommonUtil.isNullOrEmpty(dataMap.get("branchId"))) {
//    		Branch branch = this.commonService.getBranchById(Long.parseLong(dataMap.get("branchId")));
            obj.setBranchId(Long.parseLong(dataMap.get("branchId")));
            isFilter = true;
        }

        if (!CommonUtil.isNullOrEmpty(dataMap.get("paymentMethod"))) {
            isFilter = true;
            String name = dataMap.get("paymentMethod");
            StringTokenizer token = new StringTokenizer(name, " ");
            int cnt = 0;
            while (token.hasMoreTokens()) {
                if (cnt == 0) {
                    obj.setPaymentMethod(token.nextToken());
                }
                cnt++;
            }
//        	ls = getStudentListByName(name) ;
        }
//        List<Teacher> list = null;
        if (isFilter) {
            list = this.duedateRepository.findAll(Example.of(obj), Sort.by(Sort.Direction.DESC, "id"));
        } else {
            list = this.duedateRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        }
        ls = new ArrayList<>();
        for (DueDate fc : list) {
            DueDate vo = CommonUtil.createCopyProperties(fc, DueDate.class);
            ls.add(vo);
        }

        return ls;
    }


    @GetMapping("/cmsduedates/{id}")
    public ResponseEntity<DueDate> getDueDtae(@PathVariable Long id) {
        log.debug("REST request to get dueDate : {}", id);
        Optional<DueDate> dueDateDTO = duedateRepository.findById(id);
        DueDate vo = null;
        if (dueDateDTO.isPresent()) {
            DueDate fc = dueDateDTO.get();
            vo = CommonUtil.createCopyProperties(fc, DueDate.class);
        } else {
            vo = new DueDate();
        }
        return ResponseUtil.wrapOrNotFound(Optional.of(vo));
    }

    public List<DueDate> getDueDateListByName(String name) {
        DueDate dueDate = null;
        if (!CommonUtil.isNullOrEmpty(name)) {
            dueDate = new DueDate();
            StringTokenizer token = new StringTokenizer(name, " ");
            int cnt = 0;
            while (token.hasMoreTokens()) {
                if (cnt == 0) {
                    dueDate.setPaymentMethod(token.nextToken());
                }
                cnt++;
            }
        }
        log.debug("REST request to get DueDate by name : {}", name);
        List<DueDate> list = null;
        if (dueDate != null) {
            list = duedateRepository.findAll(Example.of(dueDate));
        } else {
            list = Collections.emptyList();
        }

        List<DueDate> ls = new ArrayList<>();
        for (DueDate st : list) {
            DueDate vo = CommonUtil.createCopyProperties(st, DueDate.class);
            ls.add(vo);
        }
        return ls;
    }


    @DeleteMapping("/cmsduedates/{id}")
    public Integer deleteDueDate(@PathVariable Long id) {
        log.debug("REST request to delete a DueDate : {}", id);
        try {
            DueDate st = new DueDate();
            st.setId(id);
//            st.setStatus(Status.DEACTIVE);
            this.duedateRepository.save(st);
        } catch (Exception e) {
            return HttpStatus.FAILED_DEPENDENCY.value();
        }
        return HttpStatus.OK.value();

    }

    @RequestMapping(method = RequestMethod.GET, value = "/duedate-by-id/{id}")
    public ResponseEntity<DueDate> getDueDate(@PathVariable Long id) throws Exception {
        log.debug("REST request to get a DueDate : {}", id);
        return ResponseUtil.wrapOrNotFound(Optional.of(this.cmsDueDateService.getDueDate(id)));
    }

}
