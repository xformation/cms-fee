package com.synectiks.fee.repository;

import org.springframework.stereotype.Repository;

import com.synectiks.fee.domain.LateFee;
import com.synectiks.fee.utils.JPASearchRepository;


/**
 * Spring Data  repository for the LateFee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LateFeeRepository extends JPASearchRepository<LateFee, Long> {

}
