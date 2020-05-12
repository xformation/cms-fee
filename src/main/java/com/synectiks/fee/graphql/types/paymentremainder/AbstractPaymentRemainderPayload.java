package com.synectiks.fee.graphql.types.paymentremainder;

import com.synectiks.fee.domain.PaymentRemainder;

public class AbstractPaymentRemainderPayload {
    private final  PaymentRemainder paymentRemainder;

    public AbstractPaymentRemainderPayload(PaymentRemainder paymentRemainder) {
        this.paymentRemainder = paymentRemainder;
    }

    public PaymentRemainder getPaymentRemainder() {
        return paymentRemainder;
    }
}
