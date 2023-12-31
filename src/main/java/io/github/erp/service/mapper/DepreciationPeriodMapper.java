package io.github.erp.service.mapper;

/*-
 * Erp System - Mark VI No 1 (Phoebe Series) Server ver 1.5.2
 * Copyright © 2021 - 2023 Edwin Njeru (mailnjeru@gmail.com)
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

import io.github.erp.domain.DepreciationPeriod;
import io.github.erp.service.dto.DepreciationPeriodDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link DepreciationPeriod} and its DTO {@link DepreciationPeriodDTO}.
 */
@Mapper(
    componentModel = "spring",
    uses = { ApplicationUserMapper.class, FiscalYearMapper.class, FiscalMonthMapper.class, FiscalQuarterMapper.class }
)
public interface DepreciationPeriodMapper extends EntityMapper<DepreciationPeriodDTO, DepreciationPeriod> {
    @Mapping(target = "previousPeriod", source = "previousPeriod", qualifiedByName = "endDate")
    @Mapping(target = "createdBy", source = "createdBy", qualifiedByName = "applicationIdentity")
    @Mapping(target = "fiscalYear", source = "fiscalYear", qualifiedByName = "fiscalYearCode")
    @Mapping(target = "fiscalMonth", source = "fiscalMonth", qualifiedByName = "id")
    @Mapping(target = "fiscalQuarter", source = "fiscalQuarter", qualifiedByName = "id")
    DepreciationPeriodDTO toDto(DepreciationPeriod s);

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    DepreciationPeriodDTO toDtoId(DepreciationPeriod depreciationPeriod);

    @Named("endDate")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "endDate", source = "endDate")
    DepreciationPeriodDTO toDtoEndDate(DepreciationPeriod depreciationPeriod);
}
