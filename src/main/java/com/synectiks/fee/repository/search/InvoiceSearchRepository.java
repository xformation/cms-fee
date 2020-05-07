package com.synectiks.fee.repository.search;

import com.synectiks.fee.domain.Invoice;
import com.synectiks.fee.utils.JPASearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link Invoice} entity.
 */
public interface InvoiceSearchRepository extends JPASearchRepository<Invoice, Long> {
}
