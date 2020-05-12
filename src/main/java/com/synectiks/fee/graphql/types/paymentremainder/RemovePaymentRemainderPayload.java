package com.synectiks.fee.graphql.types.paymentremainder;

import java.util.List;

import com.synectiks.fee.domain.PaymentRemainder;

public class RemovePaymentRemainderPayload {
    private final List<PaymentRemainder>paymentRemainders;

    public RemovePaymentRemainderPayload(List<PaymentRemainder> paymentRemainders) {
        this.paymentRemainders = paymentRemainders;
    }

    public List<PaymentRemainder> getPaymentRemainders() {
        return paymentRemainders;
    }
}
