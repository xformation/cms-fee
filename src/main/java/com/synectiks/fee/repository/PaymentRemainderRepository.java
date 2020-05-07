package com.synectiks.fee.repository;

import org.springframework.stereotype.Repository;

import com.synectiks.fee.domain.PaymentRemainder;
import com.synectiks.fee.utils.JPASearchRepository;


/**
 * Spring Data  repository for the PaymentRemainder entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaymentRemainderRepository extends JPASearchRepository<PaymentRemainder, Long> {

}
