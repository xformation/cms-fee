package com.synectiks.fee.repository;

import org.springframework.stereotype.Repository;

import com.synectiks.fee.domain.DueDate;
import com.synectiks.fee.utils.JPASearchRepository;


/**
 * Spring Data  repository for the DueDate entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DueDateRepository extends JPASearchRepository<DueDate, Long> {

}
