package io.github.erp.domain;

/*-
 * Erp System - Mark III No 12 (Caleb Series) Server ver 1.0.5-SNAPSHOT
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

class ContractMetadataTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ContractMetadata.class);
        ContractMetadata contractMetadata1 = new ContractMetadata();
        contractMetadata1.setId(1L);
        ContractMetadata contractMetadata2 = new ContractMetadata();
        contractMetadata2.setId(contractMetadata1.getId());
        assertThat(contractMetadata1).isEqualTo(contractMetadata2);
        contractMetadata2.setId(2L);
        assertThat(contractMetadata1).isNotEqualTo(contractMetadata2);
        contractMetadata1.setId(null);
        assertThat(contractMetadata1).isNotEqualTo(contractMetadata2);
    }
}
