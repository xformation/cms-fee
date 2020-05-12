package com.synectiks.fee.graphql.types.feedetails;

import com.synectiks.fee.domain.FeeDetails;

public class UpdateFeeDetailsPayload extends AbstractFeeDetailsPayload {
    public UpdateFeeDetailsPayload(FeeDetails feeDetails) {
        super(feeDetails);
    }
}
