package io.github.erp.service.mapper;

/*-
 * Copyright © 2021 Edwin Njeru (mailnjeru@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import io.github.erp.domain.*;
import io.github.erp.service.dto.TaxRuleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link TaxRule} and its DTO {@link TaxRuleDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TaxRuleMapper extends EntityMapper<TaxRuleDTO, TaxRule> {


    @Mapping(target = "payment", ignore = true)
    TaxRule toEntity(TaxRuleDTO taxRuleDTO);

    default TaxRule fromId(Long id) {
        if (id == null) {
            return null;
        }
        TaxRule taxRule = new TaxRule();
        taxRule.setId(id);
        return taxRule;
    }
}