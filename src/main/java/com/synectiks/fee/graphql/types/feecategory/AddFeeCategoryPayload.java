package com.synectiks.fee.graphql.types.feecategory;

import com.synectiks.fee.domain.FeeCategory;

public class AddFeeCategoryPayload extends AbstractFeeCategoryPayload{
    public AddFeeCategoryPayload(FeeCategory feeCategory) {
        super(feeCategory);
    }
}
