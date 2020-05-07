package com.synectiks.fee.web.rest;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synectiks.fee.service.FeeCategoryService;
import com.synectiks.fee.service.dto.FeeCategoryDTO;
import com.synectiks.fee.web.rest.errors.BadRequestAlertException;
import com.synectiks.fee.web.rest.util.HeaderUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.synectiks.fee.domain.FeeCategory}.
 */
@RestController
@RequestMapping("/api")
public class FeeCategoryResource {

    private final Logger log = LoggerFactory.getLogger(FeeCategoryResource.class);

    private static final String ENTITY_NAME = "feeFeeCategory";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FeeCategoryService feeCategoryService;

    public FeeCategoryResource(FeeCategoryService feeCategoryService) {
        this.feeCategoryService = feeCategoryService;
    }

    /**
     * {@code POST  /fee-categories} : Create a new feeCategory.
     *
     * @param feeCategoryDTO the feeCategoryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new feeCategoryDTO, or with status {@code 400 (Bad Request)} if the feeCategory has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/fee-categories")
    public ResponseEntity<FeeCategoryDTO> createFeeCategory(@RequestBody FeeCategoryDTO feeCategoryDTO) throws URISyntaxException {
        log.debug("REST request to save FeeCategory : {}", feeCategoryDTO);
        if (feeCategoryDTO.getId() != null) {
            throw new BadRequestAlertException("A new feeCategory cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FeeCategoryDTO result = feeCategoryService.save(feeCategoryDTO);
        return ResponseEntity.created(new URI("/api/fee-categories/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /fee-categories} : Updates an existing feeCategory.
     *
     * @param feeCategoryDTO the feeCategoryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated feeCategoryDTO,
     * or with status {@code 400 (Bad Request)} if the feeCategoryDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the feeCategoryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/fee-categories")
    public ResponseEntity<FeeCategoryDTO> updateFeeCategory(@RequestBody FeeCategoryDTO feeCategoryDTO) throws URISyntaxException {
        log.debug("REST request to update FeeCategory : {}", feeCategoryDTO);
        if (feeCategoryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        FeeCategoryDTO result = feeCategoryService.save(feeCategoryDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, feeCategoryDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /fee-categories} : get all the feeCategories.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of feeCategories in body.
     */
    @GetMapping("/fee-categories")
    public List<FeeCategoryDTO> getAllFeeCategories() {
        log.debug("REST request to get all FeeCategories");
        return feeCategoryService.findAll();
    }

    /**
     * {@code GET  /fee-categories/:id} : get the "id" feeCategory.
     *
     * @param id the id of the feeCategoryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the feeCategoryDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/fee-categories/{id}")
    public ResponseEntity<FeeCategoryDTO> getFeeCategory(@PathVariable Long id) {
        log.debug("REST request to get FeeCategory : {}", id);
        Optional<FeeCategoryDTO> feeCategoryDTO = feeCategoryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(feeCategoryDTO);
    }

    /**
     * {@code DELETE  /fee-categories/:id} : delete the "id" feeCategory.
     *
     * @param id the id of the feeCategoryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/fee-categories/{id}")
    public ResponseEntity<Void> deleteFeeCategory(@PathVariable Long id) {
        log.debug("REST request to delete FeeCategory : {}", id);
        feeCategoryService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/fee-categories?query=:query} : search for the feeCategory corresponding
     * to the query.
     *
     * @param query the query of the feeCategory search.
     * @return the result of the search.
     */
    @GetMapping("/_search/fee-categories")
    public List<FeeCategoryDTO> searchFeeCategories(@RequestParam String query) {
        log.debug("REST request to search FeeCategories for query {}", query);
        return feeCategoryService.search(query);
    }

}
