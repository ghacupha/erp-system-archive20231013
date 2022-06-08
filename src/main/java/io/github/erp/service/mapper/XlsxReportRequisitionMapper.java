package io.github.erp.service.mapper;

import io.github.erp.domain.XlsxReportRequisition;
import io.github.erp.service.dto.XlsxReportRequisitionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link XlsxReportRequisition} and its DTO {@link XlsxReportRequisitionDTO}.
 */
@Mapper(componentModel = "spring", uses = { ReportTemplateMapper.class, PlaceholderMapper.class, UniversallyUniqueMappingMapper.class })
public interface XlsxReportRequisitionMapper extends EntityMapper<XlsxReportRequisitionDTO, XlsxReportRequisition> {
    @Mapping(target = "reportTemplate", source = "reportTemplate", qualifiedByName = "catalogueNumber")
    @Mapping(target = "placeholders", source = "placeholders", qualifiedByName = "descriptionSet")
    @Mapping(target = "valueMaps", source = "valueMaps", qualifiedByName = "mappedValueSet")
    XlsxReportRequisitionDTO toDto(XlsxReportRequisition s);

    @Mapping(target = "removePlaceholder", ignore = true)
    @Mapping(target = "removeValueMaps", ignore = true)
    XlsxReportRequisition toEntity(XlsxReportRequisitionDTO xlsxReportRequisitionDTO);
}