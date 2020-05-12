package com.synectiks.fee.graphql.types.feedetails;

import com.synectiks.fee.domain.FeeDetails;

public class AbstractFeeDetailsPayload {
    private final FeeDetails feeDetails;

    public AbstractFeeDetailsPayload(FeeDetails feeDetails) {
        this.feeDetails = feeDetails;
    }

    public FeeDetails getFeeDetails() {
        return feeDetails;
    }
}
