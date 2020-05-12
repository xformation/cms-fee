package com.synectiks.fee.graphql.types.feedetails;

import java.util.List;

import com.synectiks.fee.domain.FeeDetails;

public class RemoveFeeDetailsPayload {
    private final List<FeeDetails> feeDetails;

    public RemoveFeeDetailsPayload(List<FeeDetails> feeDetails) {
        this.feeDetails = feeDetails;
    }

    public List<FeeDetails> getFeeDetails() {
        return feeDetails;
    }
}
