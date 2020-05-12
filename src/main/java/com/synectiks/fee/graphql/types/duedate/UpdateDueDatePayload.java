package com.synectiks.fee.graphql.types.duedate;

import com.synectiks.fee.domain.DueDate;

public class UpdateDueDatePayload extends AbstractDueDatePayload {

    public UpdateDueDatePayload(DueDate dueDate) {
        super(dueDate);
    }
}
