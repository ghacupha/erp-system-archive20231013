package io.github.erp.service.criteria;

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
 * Criteria class for the {@link io.github.erp.domain.ProcessStatus} entity. This class is used
 * in {@link io.github.erp.web.rest.ProcessStatusResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /process-statuses?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ProcessStatusCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter designation;

    private StringFilter description;

    private StringFilter statusCode;

    private LongFilter placeholderId;

    private LongFilter parametersId;

    private Boolean distinct;

    public ProcessStatusCriteria() {}

    public ProcessStatusCriteria(ProcessStatusCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.designation = other.designation == null ? null : other.designation.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.statusCode = other.statusCode == null ? null : other.statusCode.copy();
        this.placeholderId = other.placeholderId == null ? null : other.placeholderId.copy();
        this.parametersId = other.parametersId == null ? null : other.parametersId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public ProcessStatusCriteria copy() {
        return new ProcessStatusCriteria(this);
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

    public StringFilter getDesignation() {
        return designation;
    }

    public StringFilter designation() {
        if (designation == null) {
            designation = new StringFilter();
        }
        return designation;
    }

    public void setDesignation(StringFilter designation) {
        this.designation = designation;
    }

    public StringFilter getDescription() {
        return description;
    }

    public StringFilter description() {
        if (description == null) {
            description = new StringFilter();
        }
        return description;
    }

    public void setDescription(StringFilter description) {
        this.description = description;
    }

    public StringFilter getStatusCode() {
        return statusCode;
    }

    public StringFilter statusCode() {
        if (statusCode == null) {
            statusCode = new StringFilter();
        }
        return statusCode;
    }

    public void setStatusCode(StringFilter statusCode) {
        this.statusCode = statusCode;
    }

    public LongFilter getPlaceholderId() {
        return placeholderId;
    }

    public LongFilter placeholderId() {
        if (placeholderId == null) {
            placeholderId = new LongFilter();
        }
        return placeholderId;
    }

    public void setPlaceholderId(LongFilter placeholderId) {
        this.placeholderId = placeholderId;
    }

    public LongFilter getParametersId() {
        return parametersId;
    }

    public LongFilter parametersId() {
        if (parametersId == null) {
            parametersId = new LongFilter();
        }
        return parametersId;
    }

    public void setParametersId(LongFilter parametersId) {
        this.parametersId = parametersId;
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
        final ProcessStatusCriteria that = (ProcessStatusCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(designation, that.designation) &&
            Objects.equals(description, that.description) &&
            Objects.equals(statusCode, that.statusCode) &&
            Objects.equals(placeholderId, that.placeholderId) &&
            Objects.equals(parametersId, that.parametersId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designation, description, statusCode, placeholderId, parametersId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProcessStatusCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (designation != null ? "designation=" + designation + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (statusCode != null ? "statusCode=" + statusCode + ", " : "") +
            (placeholderId != null ? "placeholderId=" + placeholderId + ", " : "") +
            (parametersId != null ? "parametersId=" + parametersId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
