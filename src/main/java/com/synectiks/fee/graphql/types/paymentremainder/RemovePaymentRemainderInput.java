package com.synectiks.fee.graphql.types.paymentremainder;

public class RemovePaymentRemainderInput {
    private Long paymentRemainderId;

    public Long getPaymentRemainderId() {
        return paymentRemainderId;
    }

    public RemovePaymentRemainderInput(Long paymentRemainderId) {
        this.paymentRemainderId = paymentRemainderId;
    }
}
