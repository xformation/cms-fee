package com.synectiks.fee.graphql.types.feecategory;

import com.synectiks.fee.domain.FeeCategory;

public class UpdateFeeCategoryPayload extends AbstractFeeCategoryPayload{
    public UpdateFeeCategoryPayload(FeeCategory feeCategory) {
        super(feeCategory);
    }
}
