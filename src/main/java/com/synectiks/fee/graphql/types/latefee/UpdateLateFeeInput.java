package com.synectiks.fee.graphql.types.latefee;

public class UpdateLateFeeInput extends AbstractLateFeeInput{
    private Long branchId;

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }


}
