package com.synectiks.fee.repository.search;

import com.synectiks.fee.domain.FeeDetails;
import com.synectiks.fee.utils.JPASearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link FeeDetails} entity.
 */
public interface FeeDetailsSearchRepository extends JPASearchRepository<FeeDetails, Long> {
}
