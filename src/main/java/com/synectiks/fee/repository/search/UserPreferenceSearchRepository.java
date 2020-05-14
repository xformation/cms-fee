package com.synectiks.fee.repository.search;

import com.synectiks.fee.domain.UserPreference;
import com.synectiks.fee.utils.JPASearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link UserPreference} entity.
 */
public interface UserPreferenceSearchRepository extends JPASearchRepository<UserPreference, Long> {
}
