package io.github.erp.internal.model;

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
import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;
import io.github.erp.internal.framework.ExcelViewModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FixedAssetNetBookValueEVM implements Serializable, ExcelViewModel<FixedAssetNetBookValueEVM> {

    @ExcelRow
    private Long rowIndex;

    @ExcelCell(0)
    private Long assetNumber;

    @ExcelCell(1)
    private String serviceOutletCode;

    @ExcelCell(2)
    private String assetTag;

    @ExcelCell(3)
    private String assetDescription;

    @ExcelCell(4)
    private String netBookValueDate;

    @ExcelCell(5)
    private String assetCategory;

    @ExcelCell(6)
    private double netBookValue;

    @ExcelCell(7)
    private String depreciationRegime;

    private String fileUploadToken;

    private String compilationToken;

    @Override
    public FixedAssetNetBookValueEVM getModelData() {
        return SerializationUtils.clone(this);
    }
}