package io.github.erp.domain;

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

class FileUploadTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FileUpload.class);
        FileUpload fileUpload1 = new FileUpload();
        fileUpload1.setId(1L);
        FileUpload fileUpload2 = new FileUpload();
        fileUpload2.setId(fileUpload1.getId());
        assertThat(fileUpload1).isEqualTo(fileUpload2);
        fileUpload2.setId(2L);
        assertThat(fileUpload1).isNotEqualTo(fileUpload2);
        fileUpload1.setId(null);
        assertThat(fileUpload1).isNotEqualTo(fileUpload2);
    }
}
