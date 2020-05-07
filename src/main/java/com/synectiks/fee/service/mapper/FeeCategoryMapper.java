package com.synectiks.fee.service.mapper;

import com.synectiks.fee.domain.*;
import com.synectiks.fee.service.dto.FeeCategoryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link FeeCategory} and its DTO {@link FeeCategoryDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FeeCategoryMapper extends EntityMapper<FeeCategoryDTO, FeeCategory> {



    default FeeCategory fromId(Long id) {
        if (id == null) {
            return null;
        }
        FeeCategory feeCategory = new FeeCategory();
        feeCategory.setId(id);
        return feeCategory;
    }
}
