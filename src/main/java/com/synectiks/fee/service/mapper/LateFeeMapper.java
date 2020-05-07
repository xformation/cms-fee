package com.synectiks.fee.service.mapper;

import com.synectiks.fee.domain.*;
import com.synectiks.fee.service.dto.LateFeeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link LateFee} and its DTO {@link LateFeeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface LateFeeMapper extends EntityMapper<LateFeeDTO, LateFee> {



    default LateFee fromId(Long id) {
        if (id == null) {
            return null;
        }
        LateFee lateFee = new LateFee();
        lateFee.setId(id);
        return lateFee;
    }
}
