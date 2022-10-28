package io.github.erp.service.dto;

/*-
 * Erp System - Mark III No 3 (Caleb Series) Server ver 0.1.3-SNAPSHOT
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
import static org.assertj.core.api.Assertions.assertThat;

import io.github.erp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SettlementDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SettlementDTO.class);
        SettlementDTO settlementDTO1 = new SettlementDTO();
        settlementDTO1.setId(1L);
        SettlementDTO settlementDTO2 = new SettlementDTO();
        assertThat(settlementDTO1).isNotEqualTo(settlementDTO2);
        settlementDTO2.setId(settlementDTO1.getId());
        assertThat(settlementDTO1).isEqualTo(settlementDTO2);
        settlementDTO2.setId(2L);
        assertThat(settlementDTO1).isNotEqualTo(settlementDTO2);
        settlementDTO1.setId(null);
        assertThat(settlementDTO1).isNotEqualTo(settlementDTO2);
    }
}
