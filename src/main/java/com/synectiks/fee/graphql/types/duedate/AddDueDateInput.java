package com.synectiks.fee.graphql.types.duedate;

public class AddDueDateInput extends AbstractDueDateInput {
    private Long branchId;

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

}
