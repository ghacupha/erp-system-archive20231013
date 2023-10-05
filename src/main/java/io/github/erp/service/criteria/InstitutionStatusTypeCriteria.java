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
 * Criteria class for the {@link io.github.erp.domain.InstitutionStatusType} entity. This class is used
 * in {@link io.github.erp.web.rest.InstitutionStatusTypeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /institution-status-types?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class InstitutionStatusTypeCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter institutionStatusCode;

    private StringFilter institutionStatusType;

    private Boolean distinct;

    public InstitutionStatusTypeCriteria() {}

    public InstitutionStatusTypeCriteria(InstitutionStatusTypeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.institutionStatusCode = other.institutionStatusCode == null ? null : other.institutionStatusCode.copy();
        this.institutionStatusType = other.institutionStatusType == null ? null : other.institutionStatusType.copy();
        this.distinct = other.distinct;
    }

    @Override
    public InstitutionStatusTypeCriteria copy() {
        return new InstitutionStatusTypeCriteria(this);
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

    public StringFilter getInstitutionStatusCode() {
        return institutionStatusCode;
    }

    public StringFilter institutionStatusCode() {
        if (institutionStatusCode == null) {
            institutionStatusCode = new StringFilter();
        }
        return institutionStatusCode;
    }

    public void setInstitutionStatusCode(StringFilter institutionStatusCode) {
        this.institutionStatusCode = institutionStatusCode;
    }

    public StringFilter getInstitutionStatusType() {
        return institutionStatusType;
    }

    public StringFilter institutionStatusType() {
        if (institutionStatusType == null) {
            institutionStatusType = new StringFilter();
        }
        return institutionStatusType;
    }

    public void setInstitutionStatusType(StringFilter institutionStatusType) {
        this.institutionStatusType = institutionStatusType;
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
        final InstitutionStatusTypeCriteria that = (InstitutionStatusTypeCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(institutionStatusCode, that.institutionStatusCode) &&
            Objects.equals(institutionStatusType, that.institutionStatusType) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, institutionStatusCode, institutionStatusType, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "InstitutionStatusTypeCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (institutionStatusCode != null ? "institutionStatusCode=" + institutionStatusCode + ", " : "") +
            (institutionStatusType != null ? "institutionStatusType=" + institutionStatusType + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
