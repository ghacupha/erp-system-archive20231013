package io.github.erp.service.mapper;

/*-
 * Erp System - Mark III No 10 (Caleb Series) Server ver 0.6.0
 * Copyright © 2021 - 2022 Edwin Njeru (mailnjeru@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
import io.github.erp.domain.LeaseContract;
import io.github.erp.service.dto.LeaseContractDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link LeaseContract} and its DTO {@link LeaseContractDTO}.
 */
@Mapper(componentModel = "spring", uses = { PlaceholderMapper.class, UniversallyUniqueMappingMapper.class, BusinessDocumentMapper.class })
public interface LeaseContractMapper extends EntityMapper<LeaseContractDTO, LeaseContract> {
    @Mapping(target = "placeholders", source = "placeholders", qualifiedByName = "descriptionSet")
    @Mapping(target = "systemMappings", source = "systemMappings", qualifiedByName = "mappedValueSet")
    @Mapping(target = "businessDocuments", source = "businessDocuments", qualifiedByName = "documentTitleSet")
    LeaseContractDTO toDto(LeaseContract s);

    @Mapping(target = "removePlaceholder", ignore = true)
    @Mapping(target = "removeSystemMappings", ignore = true)
    @Mapping(target = "removeBusinessDocument", ignore = true)
    LeaseContract toEntity(LeaseContractDTO leaseContractDTO);
}