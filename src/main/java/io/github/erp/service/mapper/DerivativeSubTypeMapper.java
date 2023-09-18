package io.github.erp.service.mapper;

/*-
 * Erp System - Mark V No 7 (Ehud Series) Server ver 1.5.0
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

import io.github.erp.domain.DerivativeSubType;
import io.github.erp.service.dto.DerivativeSubTypeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link DerivativeSubType} and its DTO {@link DerivativeSubTypeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DerivativeSubTypeMapper extends EntityMapper<DerivativeSubTypeDTO, DerivativeSubType> {}