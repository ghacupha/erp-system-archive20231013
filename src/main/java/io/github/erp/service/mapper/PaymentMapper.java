package io.github.erp.service.mapper;

import io.github.erp.domain.*;
import io.github.erp.service.dto.PaymentDTO;
import java.util.Set;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Payment} and its DTO {@link PaymentDTO}.
 */
@Mapper(
    componentModel = "spring",
    uses = { PaymentCategoryMapper.class, TaxRuleMapper.class, PaymentCalculationMapper.class, PaymentRequisitionMapper.class }
)
public interface PaymentMapper extends EntityMapper<PaymentDTO, Payment> {
    @Mapping(target = "paymentCategory", source = "paymentCategory", qualifiedByName = "id")
    @Mapping(target = "taxRule", source = "taxRule", qualifiedByName = "id")
    @Mapping(target = "paymentCalculation", source = "paymentCalculation", qualifiedByName = "id")
    @Mapping(target = "paymentRequisition", source = "paymentRequisition", qualifiedByName = "id")
    PaymentDTO toDto(Payment s);

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PaymentDTO toDtoId(Payment payment);

    @Named("idSet")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    Set<PaymentDTO> toDtoIdSet(Set<Payment> payment);
}