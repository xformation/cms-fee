package com.synectiks.fee.repository;

import org.springframework.stereotype.Repository;

import com.synectiks.fee.domain.FeeDetails;
import com.synectiks.fee.utils.JPASearchRepository;


/**
 * Spring Data  repository for the FeeDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FeeDetailsRepository extends JPASearchRepository<FeeDetails, Long> {

}
