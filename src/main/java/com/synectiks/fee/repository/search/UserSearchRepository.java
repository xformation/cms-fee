package com.synectiks.fee.repository.search;

import com.synectiks.fee.domain.User;
import com.synectiks.fee.utils.JPASearchRepository;

/**
 * Spring Data Elasticsearch repository for the User entity.
 */
public interface UserSearchRepository extends JPASearchRepository<User, Long> {
}
