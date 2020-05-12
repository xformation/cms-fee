package com.synectiks.fee.graphql.types.paymentremainder;

public class UpdatePaymentRemainderInput extends AbstractPaymentRemainderInput {
    private Long branchId;

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }
}
