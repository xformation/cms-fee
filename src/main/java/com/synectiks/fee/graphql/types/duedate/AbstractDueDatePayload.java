package com.synectiks.fee.graphql.types.duedate;

import com.synectiks.fee.domain.DueDate;

public class AbstractDueDatePayload extends AbstractDueDateInput {
    private final DueDate dueDate;

    public AbstractDueDatePayload(DueDate dueDate) {
        this.dueDate = dueDate;
    }

    public DueDate getDueDate() {
        return dueDate;
    }
}
