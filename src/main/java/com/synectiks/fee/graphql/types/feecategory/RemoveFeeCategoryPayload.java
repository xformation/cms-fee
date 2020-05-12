package com.synectiks.fee.graphql.types.feecategory;

import java.util.List;

import com.synectiks.fee.domain.FeeCategory;

public class RemoveFeeCategoryPayload {
    private final List<FeeCategory> feeCategories;

    public RemoveFeeCategoryPayload(List<FeeCategory> feeCategories) {
        this.feeCategories = feeCategories;
    }

    public List<FeeCategory> getFeeCategories() {
        return feeCategories;
    }
}
