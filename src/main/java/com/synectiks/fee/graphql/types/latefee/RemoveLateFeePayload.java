package com.synectiks.fee.graphql.types.latefee;

import java.util.List;

import com.synectiks.fee.domain.LateFee;

public class RemoveLateFeePayload {
    private final List<LateFee> lateFees;

    public RemoveLateFeePayload(List<LateFee> lateFees) {
        this.lateFees = lateFees;
    }

    public List<LateFee> getLateFees() {
        return lateFees;
    }
}
