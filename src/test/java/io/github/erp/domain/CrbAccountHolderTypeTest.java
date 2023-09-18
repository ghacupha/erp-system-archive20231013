package io.github.erp.domain;

/*-
 * Erp System - Mark V No 8 (Ehud Series) Server ver 1.5.1
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
import static org.assertj.core.api.Assertions.assertThat;

import io.github.erp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CrbAccountHolderTypeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CrbAccountHolderType.class);
        CrbAccountHolderType crbAccountHolderType1 = new CrbAccountHolderType();
        crbAccountHolderType1.setId(1L);
        CrbAccountHolderType crbAccountHolderType2 = new CrbAccountHolderType();
        crbAccountHolderType2.setId(crbAccountHolderType1.getId());
        assertThat(crbAccountHolderType1).isEqualTo(crbAccountHolderType2);
        crbAccountHolderType2.setId(2L);
        assertThat(crbAccountHolderType1).isNotEqualTo(crbAccountHolderType2);
        crbAccountHolderType1.setId(null);
        assertThat(crbAccountHolderType1).isNotEqualTo(crbAccountHolderType2);
    }
}
