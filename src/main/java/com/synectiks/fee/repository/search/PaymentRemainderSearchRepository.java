package com.synectiks.fee.repository.search;

import com.synectiks.fee.domain.PaymentRemainder;
import com.synectiks.fee.utils.JPASearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link PaymentRemainder} entity.
 */
public interface PaymentRemainderSearchRepository extends JPASearchRepository<PaymentRemainder, Long> {
}
