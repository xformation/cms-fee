package com.synectiks.fee.repository.search;

import com.synectiks.fee.domain.DueDate;
import com.synectiks.fee.utils.JPASearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link DueDate} entity.
 */
public interface DueDateSearchRepository extends JPASearchRepository<DueDate, Long> {
}
