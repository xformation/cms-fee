package com.synectiks.fee.repository.search;

import com.synectiks.fee.domain.LateFee;
import com.synectiks.fee.utils.JPASearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link LateFee} entity.
 */
public interface LateFeeSearchRepository extends JPASearchRepository<LateFee, Long> {
}
