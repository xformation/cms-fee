package com.synectiks.fee.graphql.types.latefee;

import com.synectiks.fee.domain.LateFee;

public class UpdateLateFeePayload extends AbstractLateFeePayload {
    public UpdateLateFeePayload(LateFee lateFee) {
        super(lateFee);
    }
}
