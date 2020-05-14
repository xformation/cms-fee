package com.synectiks.fee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synectiks.fee.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
