package io.github.erp.erp.depreciation.model;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * includes list of asset ids that are to be depreciated in a single batch, and other
 * important batch details
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepreciationBatchMessage implements Serializable {

    private String jobId;
    private String batchId;
    private List<String> assetIds;
    private BigDecimal initialCost;
    private LocalDateTime createdAt;
    private int startIndex;
    private int endIndex;
    private boolean isLastBatch;
}
