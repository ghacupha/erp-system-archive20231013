package io.github.erp.domain;

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
import static org.assertj.core.api.Assertions.assertThat;

import io.github.erp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class GdiMasterDataIndexTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(GdiMasterDataIndex.class);
        GdiMasterDataIndex gdiMasterDataIndex1 = new GdiMasterDataIndex();
        gdiMasterDataIndex1.setId(1L);
        GdiMasterDataIndex gdiMasterDataIndex2 = new GdiMasterDataIndex();
        gdiMasterDataIndex2.setId(gdiMasterDataIndex1.getId());
        assertThat(gdiMasterDataIndex1).isEqualTo(gdiMasterDataIndex2);
        gdiMasterDataIndex2.setId(2L);
        assertThat(gdiMasterDataIndex1).isNotEqualTo(gdiMasterDataIndex2);
        gdiMasterDataIndex1.setId(null);
        assertThat(gdiMasterDataIndex1).isNotEqualTo(gdiMasterDataIndex2);
    }
}
