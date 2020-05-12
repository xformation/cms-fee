package com.synectiks.fee.graphql.types.feedetails;

import com.synectiks.fee.domain.FeeDetails;

public class AddFeeDetailsPayload extends AbstractFeeDetailsPayload{
    public AddFeeDetailsPayload(FeeDetails feeDetails) {
        super(feeDetails);
    }
}
