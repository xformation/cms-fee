package com.synectiks.fee.graphql.types.paymentremainder;

public class AddPaymentRemainderInput extends AbstractPaymentRemainderInput {
    private Long branchId;

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

}

