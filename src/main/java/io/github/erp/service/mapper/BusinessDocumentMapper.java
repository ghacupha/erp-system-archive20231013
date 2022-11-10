package io.github.erp.service.mapper;

import io.github.erp.domain.BusinessDocument;
import io.github.erp.service.dto.BusinessDocumentDTO;
import java.util.Set;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link BusinessDocument} and its DTO {@link BusinessDocumentDTO}.
 */
@Mapper(
    componentModel = "spring",
    uses = { ApplicationUserMapper.class, DealerMapper.class, UniversallyUniqueMappingMapper.class, PlaceholderMapper.class }
)
public interface BusinessDocumentMapper extends EntityMapper<BusinessDocumentDTO, BusinessDocument> {
    @Mapping(target = "createdBy", source = "createdBy", qualifiedByName = "applicationIdentity")
    @Mapping(target = "lastModifiedBy", source = "lastModifiedBy", qualifiedByName = "applicationIdentity")
    @Mapping(target = "originatingDepartment", source = "originatingDepartment", qualifiedByName = "dealerName")
    @Mapping(target = "applicationMappings", source = "applicationMappings", qualifiedByName = "universalKeySet")
    @Mapping(target = "placeholders", source = "placeholders", qualifiedByName = "descriptionSet")
    BusinessDocumentDTO toDto(BusinessDocument s);

    @Mapping(target = "removeApplicationMappings", ignore = true)
    @Mapping(target = "removePlaceholder", ignore = true)
    BusinessDocument toEntity(BusinessDocumentDTO businessDocumentDTO);

    @Named("documentTitleSet")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "documentTitle", source = "documentTitle")
    Set<BusinessDocumentDTO> toDtoDocumentTitleSet(Set<BusinessDocument> businessDocument);
}
