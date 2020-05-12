package com.synectiks.fee.graphql.types.latefee;

import com.synectiks.fee.domain.LateFee;

public class AbstractLateFeePayload {
    private final LateFee lateFee;

    public AbstractLateFeePayload(LateFee lateFee) {
        this.lateFee = lateFee;
    }

    public LateFee getLateFee() {
        return lateFee;
    }
}
