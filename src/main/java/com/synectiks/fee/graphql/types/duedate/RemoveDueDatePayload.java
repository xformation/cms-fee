package com.synectiks.fee.graphql.types.duedate;

import java.util.List;

import com.synectiks.fee.domain.DueDate;

public class RemoveDueDatePayload  {
    private final List<DueDate> dueDates;

    public RemoveDueDatePayload(List<DueDate> dueDates) {
        this.dueDates = dueDates;
    }

    public List<DueDate> getDueDates() {
        return dueDates;
    }
}
