package com.synectiks.fee.service.mapper;

import com.synectiks.fee.domain.*;
import com.synectiks.fee.service.dto.DueDateDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DueDate} and its DTO {@link DueDateDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DueDateMapper extends EntityMapper<DueDateDTO, DueDate> {



    default DueDate fromId(Long id) {
        if (id == null) {
            return null;
        }
        DueDate dueDate = new DueDate();
        dueDate.setId(id);
        return dueDate;
    }
}
