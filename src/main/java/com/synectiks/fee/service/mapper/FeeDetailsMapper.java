package com.synectiks.fee.service.mapper;

import com.synectiks.fee.domain.*;
import com.synectiks.fee.service.dto.FeeDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link FeeDetails} and its DTO {@link FeeDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {FeeCategoryMapper.class})
public interface FeeDetailsMapper extends EntityMapper<FeeDetailsDTO, FeeDetails> {

    @Mapping(source = "feeCategory.id", target = "feeCategoryId")
    FeeDetailsDTO toDto(FeeDetails feeDetails);

    @Mapping(source = "feeCategoryId", target = "feeCategory")
    FeeDetails toEntity(FeeDetailsDTO feeDetailsDTO);

    default FeeDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        FeeDetails feeDetails = new FeeDetails();
        feeDetails.setId(id);
        return feeDetails;
    }
}
