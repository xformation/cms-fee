package com.synectiks.fee.service;

import com.synectiks.fee.service.dto.FeeDetailsDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.synectiks.fee.domain.FeeDetails}.
 */
public interface FeeDetailsService {

    /**
     * Save a feeDetails.
     *
     * @param feeDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    FeeDetailsDTO save(FeeDetailsDTO feeDetailsDTO);

    /**
     * Get all the feeDetails.
     *
     * @return the list of entities.
     */
    List<FeeDetailsDTO> findAll();


    /**
     * Get the "id" feeDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FeeDetailsDTO> findOne(Long id);

    /**
     * Delete the "id" feeDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the feeDetails corresponding to the query.
     *
     * @param query the query of the search.
     * 
     * @return the list of entities.
     */
    List<FeeDetailsDTO> search(String query);
}
