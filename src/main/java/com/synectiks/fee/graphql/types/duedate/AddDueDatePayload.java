package com.synectiks.fee.graphql.types.duedate;

import com.synectiks.fee.domain.DueDate;

public class AddDueDatePayload extends AbstractDueDatePayload {

    public AddDueDatePayload(DueDate dueDate) {
        super(dueDate);
    }
}
