package com.synectiks.fee.graphql.types.invoice;

import com.synectiks.fee.domain.Invoice;

public class AddInvoicePayload extends AbstractInvoicePayload {
    public AddInvoicePayload(Invoice invoice) {
        super(invoice);
    }
}
