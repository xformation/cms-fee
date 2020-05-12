package com.synectiks.fee.graphql.types.invoice;

import com.synectiks.fee.domain.Invoice;

public class AbstractInvoicePayload {
    private final Invoice invoice;

    public AbstractInvoicePayload(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }
}
