package com.synectiks.fee.repository;

import org.springframework.stereotype.Repository;

import com.synectiks.fee.domain.Invoice;
import com.synectiks.fee.utils.JPASearchRepository;


/**
 * Spring Data  repository for the Invoice entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InvoiceRepository extends JPASearchRepository<Invoice, Long> {

}
