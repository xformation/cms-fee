package com.synectiks.fee.repository;

import org.springframework.stereotype.Repository;

import com.synectiks.fee.domain.FeeCategory;
import com.synectiks.fee.utils.JPASearchRepository;


/**
 * Spring Data  repository for the FeeCategory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FeeCategoryRepository extends JPASearchRepository<FeeCategory, Long> {

}
