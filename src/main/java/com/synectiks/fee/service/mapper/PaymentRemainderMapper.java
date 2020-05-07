package com.synectiks.fee.service.mapper;

import com.synectiks.fee.domain.*;
import com.synectiks.fee.service.dto.PaymentRemainderDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaymentRemainder} and its DTO {@link PaymentRemainderDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PaymentRemainderMapper extends EntityMapper<PaymentRemainderDTO, PaymentRemainder> {



    default PaymentRemainder fromId(Long id) {
        if (id == null) {
            return null;
        }
        PaymentRemainder paymentRemainder = new PaymentRemainder();
        paymentRemainder.setId(id);
        return paymentRemainder;
    }
}
