package com.synectiks.fee.graphql.types.invoice;

import java.util.List;

import com.synectiks.fee.domain.Invoice;

public class RemoveInvoicePayload {
    private final List<Invoice> invoices;

    public RemoveInvoicePayload(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
