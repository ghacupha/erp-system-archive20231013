package io.github.erp.service.mapper;

import io.github.erp.domain.SettlementRequisition;
import io.github.erp.service.dto.SettlementRequisitionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SettlementRequisition} and its DTO {@link SettlementRequisitionDTO}.
 */
@Mapper(
    componentModel = "spring",
    uses = {
        SettlementCurrencyMapper.class,
        ApplicationUserMapper.class,
        DealerMapper.class,
        PaymentInvoiceMapper.class,
        DeliveryNoteMapper.class,
        JobSheetMapper.class,
        BusinessDocumentMapper.class,
        UniversallyUniqueMappingMapper.class,
        PlaceholderMapper.class,
    }
)
public interface SettlementRequisitionMapper extends EntityMapper<SettlementRequisitionDTO, SettlementRequisition> {
    @Mapping(target = "settlementCurrency", source = "settlementCurrency", qualifiedByName = "iso4217CurrencyCode")
    @Mapping(target = "currentOwner", source = "currentOwner", qualifiedByName = "applicationIdentity")
    @Mapping(target = "nativeOwner", source = "nativeOwner", qualifiedByName = "applicationIdentity")
    @Mapping(target = "nativeDepartment", source = "nativeDepartment", qualifiedByName = "dealerName")
    @Mapping(target = "biller", source = "biller", qualifiedByName = "dealerName")
    @Mapping(target = "paymentInvoices", source = "paymentInvoices", qualifiedByName = "invoiceNumberSet")
    @Mapping(target = "deliveryNotes", source = "deliveryNotes", qualifiedByName = "deliveryNoteNumberSet")
    @Mapping(target = "jobSheets", source = "jobSheets", qualifiedByName = "serialNumberSet")
    @Mapping(target = "signatures", source = "signatures", qualifiedByName = "dealerNameSet")
    @Mapping(target = "businessDocuments", source = "businessDocuments", qualifiedByName = "documentTitleSet")
    @Mapping(target = "applicationMappings", source = "applicationMappings", qualifiedByName = "universalKeySet")
    @Mapping(target = "placeholders", source = "placeholders", qualifiedByName = "descriptionSet")
    SettlementRequisitionDTO toDto(SettlementRequisition s);

    @Mapping(target = "removePaymentInvoice", ignore = true)
    @Mapping(target = "removeDeliveryNote", ignore = true)
    @Mapping(target = "removeJobSheet", ignore = true)
    @Mapping(target = "removeSignatures", ignore = true)
    @Mapping(target = "removeBusinessDocument", ignore = true)
    @Mapping(target = "removeApplicationMapping", ignore = true)
    @Mapping(target = "removePlaceholder", ignore = true)
    SettlementRequisition toEntity(SettlementRequisitionDTO settlementRequisitionDTO);
}
