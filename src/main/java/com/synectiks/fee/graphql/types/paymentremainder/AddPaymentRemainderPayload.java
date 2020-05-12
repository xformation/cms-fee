package com.synectiks.fee.graphql.types.paymentremainder;

import com.synectiks.fee.domain.PaymentRemainder;

public class AddPaymentRemainderPayload extends AbstractPaymentRemainderPayload{
    public AddPaymentRemainderPayload(PaymentRemainder paymentRemainder) {
        super(paymentRemainder);
    }
}
