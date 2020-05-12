package com.synectiks.fee.graphql.types.paymentremainder;

import com.synectiks.fee.domain.PaymentRemainder;

public class UpdatePaymentRemainderPayload extends AbstractPaymentRemainderPayload {
    public UpdatePaymentRemainderPayload(PaymentRemainder paymentRemainder) {
        super(paymentRemainder);
    }
}
