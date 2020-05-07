package com.synectiks.fee.repository.search;

import com.synectiks.fee.domain.FeeCategory;
import com.synectiks.fee.utils.JPASearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link FeeCategory} entity.
 */
public interface FeeCategorySearchRepository extends JPASearchRepository<FeeCategory, Long> {
}
