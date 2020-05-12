package com.synectiks.fee.graphql.types.invoice;

import com.synectiks.fee.domain.Invoice;

public class UpdateInvoicePayload  extends AbstractInvoicePayload{
    public UpdateInvoicePayload(Invoice invoice) {
        super(invoice);
    }
}
