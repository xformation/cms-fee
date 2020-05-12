package com.synectiks.fee.graphql.types.feecategory;

import com.synectiks.fee.domain.FeeCategory;

public class AbstractFeeCategoryPayload {
    private final FeeCategory feeCategory;

    public AbstractFeeCategoryPayload(FeeCategory feeCategory) {
        this.feeCategory = feeCategory;
    }

    public FeeCategory getFeeCategory() {
        return feeCategory;
    }
}
