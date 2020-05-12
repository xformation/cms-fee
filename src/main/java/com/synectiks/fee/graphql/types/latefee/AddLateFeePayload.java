package com.synectiks.fee.graphql.types.latefee;

import com.synectiks.fee.domain.LateFee;

public class AddLateFeePayload extends AbstractLateFeePayload{
    public AddLateFeePayload(LateFee lateFee) {
        super(lateFee);
    }
}
