package com.synectiks.fee.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synectiks.fee.domain.Invoice;
import com.synectiks.fee.repository.InvoiceRepository;
import com.synectiks.fee.repository.search.InvoiceSearchRepository;
import com.synectiks.fee.service.InvoiceService;
import com.synectiks.fee.service.dto.InvoiceDTO;
import com.synectiks.fee.service.mapper.InvoiceMapper;

/**
 * Service Implementation for managing {@link Invoice}.
 */
@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final Logger log = LoggerFactory.getLogger(InvoiceServiceImpl.class);

    private final InvoiceRepository invoiceRepository;

    private final InvoiceMapper invoiceMapper;

    private final InvoiceSearchRepository invoiceSearchRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, InvoiceSearchRepository invoiceSearchRepository) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.invoiceSearchRepository = invoiceSearchRepository;
    }

    /**
     * Save a invoice.
     *
     * @param invoiceDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public InvoiceDTO save(InvoiceDTO invoiceDTO) {
        log.debug("Request to save Invoice : {}", invoiceDTO);
        Invoice invoice = invoiceMapper.toEntity(invoiceDTO);
        invoice = invoiceRepository.save(invoice);
        InvoiceDTO result = invoiceMapper.toDto(invoice);
        invoiceSearchRepository.save(invoice);
        return result;
    }

    /**
     * Get all the invoices.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<InvoiceDTO> findAll() {
        log.debug("Request to get all Invoices");
        return invoiceRepository.findAll().stream()
            .map(invoiceMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one invoice by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<InvoiceDTO> findOne(Long id) {
        log.debug("Request to get Invoice : {}", id);
        return invoiceRepository.findById(id)
            .map(invoiceMapper::toDto);
    }

    /**
     * Delete the invoice by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Invoice : {}", id);
        invoiceRepository.deleteById(id);
        invoiceSearchRepository.deleteById(id);
    }

    /**
     * Search for the invoice corresponding to the query.
     *
     * @param query the query of the search.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<InvoiceDTO> search(String query) {
        log.debug("Request to search Invoices for query {}", query);
        return null;
    }
}
