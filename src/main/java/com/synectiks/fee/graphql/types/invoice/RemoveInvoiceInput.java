package com.synectiks.fee.graphql.types.invoice;

public class RemoveInvoiceInput {
    private Long invoiceId;

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }
}
