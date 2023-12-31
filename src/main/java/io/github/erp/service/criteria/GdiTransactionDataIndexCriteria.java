package io.github.erp.service.criteria;

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

import io.github.erp.domain.enumeration.DatasetBehaviorTypes;
import io.github.erp.domain.enumeration.UpdateFrequencyTypes;
import java.io.Serializable;
import java.util.Objects;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.BooleanFilter;
import tech.jhipster.service.filter.DoubleFilter;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.FloatFilter;
import tech.jhipster.service.filter.IntegerFilter;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link io.github.erp.domain.GdiTransactionDataIndex} entity. This class is used
 * in {@link io.github.erp.web.rest.GdiTransactionDataIndexResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /gdi-transaction-data-indices?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class GdiTransactionDataIndexCriteria implements Serializable, Criteria {

    /**
     * Class for filtering UpdateFrequencyTypes
     */
    public static class UpdateFrequencyTypesFilter extends Filter<UpdateFrequencyTypes> {

        public UpdateFrequencyTypesFilter() {}

        public UpdateFrequencyTypesFilter(UpdateFrequencyTypesFilter filter) {
            super(filter);
        }

        @Override
        public UpdateFrequencyTypesFilter copy() {
            return new UpdateFrequencyTypesFilter(this);
        }
    }

    /**
     * Class for filtering DatasetBehaviorTypes
     */
    public static class DatasetBehaviorTypesFilter extends Filter<DatasetBehaviorTypes> {

        public DatasetBehaviorTypesFilter() {}

        public DatasetBehaviorTypesFilter(DatasetBehaviorTypesFilter filter) {
            super(filter);
        }

        @Override
        public DatasetBehaviorTypesFilter copy() {
            return new DatasetBehaviorTypesFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter datasetName;

    private StringFilter databaseName;

    private UpdateFrequencyTypesFilter updateFrequency;

    private DatasetBehaviorTypesFilter datasetBehavior;

    private IntegerFilter minimumDatarowsPerRequest;

    private IntegerFilter maximumDataRowsPerRequest;

    private LongFilter masterDataItemId;

    private Boolean distinct;

    public GdiTransactionDataIndexCriteria() {}

    public GdiTransactionDataIndexCriteria(GdiTransactionDataIndexCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.datasetName = other.datasetName == null ? null : other.datasetName.copy();
        this.databaseName = other.databaseName == null ? null : other.databaseName.copy();
        this.updateFrequency = other.updateFrequency == null ? null : other.updateFrequency.copy();
        this.datasetBehavior = other.datasetBehavior == null ? null : other.datasetBehavior.copy();
        this.minimumDatarowsPerRequest = other.minimumDatarowsPerRequest == null ? null : other.minimumDatarowsPerRequest.copy();
        this.maximumDataRowsPerRequest = other.maximumDataRowsPerRequest == null ? null : other.maximumDataRowsPerRequest.copy();
        this.masterDataItemId = other.masterDataItemId == null ? null : other.masterDataItemId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public GdiTransactionDataIndexCriteria copy() {
        return new GdiTransactionDataIndexCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getDatasetName() {
        return datasetName;
    }

    public StringFilter datasetName() {
        if (datasetName == null) {
            datasetName = new StringFilter();
        }
        return datasetName;
    }

    public void setDatasetName(StringFilter datasetName) {
        this.datasetName = datasetName;
    }

    public StringFilter getDatabaseName() {
        return databaseName;
    }

    public StringFilter databaseName() {
        if (databaseName == null) {
            databaseName = new StringFilter();
        }
        return databaseName;
    }

    public void setDatabaseName(StringFilter databaseName) {
        this.databaseName = databaseName;
    }

    public UpdateFrequencyTypesFilter getUpdateFrequency() {
        return updateFrequency;
    }

    public UpdateFrequencyTypesFilter updateFrequency() {
        if (updateFrequency == null) {
            updateFrequency = new UpdateFrequencyTypesFilter();
        }
        return updateFrequency;
    }

    public void setUpdateFrequency(UpdateFrequencyTypesFilter updateFrequency) {
        this.updateFrequency = updateFrequency;
    }

    public DatasetBehaviorTypesFilter getDatasetBehavior() {
        return datasetBehavior;
    }

    public DatasetBehaviorTypesFilter datasetBehavior() {
        if (datasetBehavior == null) {
            datasetBehavior = new DatasetBehaviorTypesFilter();
        }
        return datasetBehavior;
    }

    public void setDatasetBehavior(DatasetBehaviorTypesFilter datasetBehavior) {
        this.datasetBehavior = datasetBehavior;
    }

    public IntegerFilter getMinimumDatarowsPerRequest() {
        return minimumDatarowsPerRequest;
    }

    public IntegerFilter minimumDatarowsPerRequest() {
        if (minimumDatarowsPerRequest == null) {
            minimumDatarowsPerRequest = new IntegerFilter();
        }
        return minimumDatarowsPerRequest;
    }

    public void setMinimumDatarowsPerRequest(IntegerFilter minimumDatarowsPerRequest) {
        this.minimumDatarowsPerRequest = minimumDatarowsPerRequest;
    }

    public IntegerFilter getMaximumDataRowsPerRequest() {
        return maximumDataRowsPerRequest;
    }

    public IntegerFilter maximumDataRowsPerRequest() {
        if (maximumDataRowsPerRequest == null) {
            maximumDataRowsPerRequest = new IntegerFilter();
        }
        return maximumDataRowsPerRequest;
    }

    public void setMaximumDataRowsPerRequest(IntegerFilter maximumDataRowsPerRequest) {
        this.maximumDataRowsPerRequest = maximumDataRowsPerRequest;
    }

    public LongFilter getMasterDataItemId() {
        return masterDataItemId;
    }

    public LongFilter masterDataItemId() {
        if (masterDataItemId == null) {
            masterDataItemId = new LongFilter();
        }
        return masterDataItemId;
    }

    public void setMasterDataItemId(LongFilter masterDataItemId) {
        this.masterDataItemId = masterDataItemId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final GdiTransactionDataIndexCriteria that = (GdiTransactionDataIndexCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(datasetName, that.datasetName) &&
            Objects.equals(databaseName, that.databaseName) &&
            Objects.equals(updateFrequency, that.updateFrequency) &&
            Objects.equals(datasetBehavior, that.datasetBehavior) &&
            Objects.equals(minimumDatarowsPerRequest, that.minimumDatarowsPerRequest) &&
            Objects.equals(maximumDataRowsPerRequest, that.maximumDataRowsPerRequest) &&
            Objects.equals(masterDataItemId, that.masterDataItemId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            datasetName,
            databaseName,
            updateFrequency,
            datasetBehavior,
            minimumDatarowsPerRequest,
            maximumDataRowsPerRequest,
            masterDataItemId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GdiTransactionDataIndexCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (datasetName != null ? "datasetName=" + datasetName + ", " : "") +
            (databaseName != null ? "databaseName=" + databaseName + ", " : "") +
            (updateFrequency != null ? "updateFrequency=" + updateFrequency + ", " : "") +
            (datasetBehavior != null ? "datasetBehavior=" + datasetBehavior + ", " : "") +
            (minimumDatarowsPerRequest != null ? "minimumDatarowsPerRequest=" + minimumDatarowsPerRequest + ", " : "") +
            (maximumDataRowsPerRequest != null ? "maximumDataRowsPerRequest=" + maximumDataRowsPerRequest + ", " : "") +
            (masterDataItemId != null ? "masterDataItemId=" + masterDataItemId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
