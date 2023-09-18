package io.github.erp.service.criteria;

/*-
 * Erp System - Mark V No 7 (Ehud Series) Server ver 1.5.0
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
 * Criteria class for the {@link io.github.erp.domain.SecurityType} entity. This class is used
 * in {@link io.github.erp.web.rest.SecurityTypeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /security-types?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class SecurityTypeCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter securityTypeCode;

    private StringFilter securityType;

    private StringFilter securityTypeDescription;

    private Boolean distinct;

    public SecurityTypeCriteria() {}

    public SecurityTypeCriteria(SecurityTypeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.securityTypeCode = other.securityTypeCode == null ? null : other.securityTypeCode.copy();
        this.securityType = other.securityType == null ? null : other.securityType.copy();
        this.securityTypeDescription = other.securityTypeDescription == null ? null : other.securityTypeDescription.copy();
        this.distinct = other.distinct;
    }

    @Override
    public SecurityTypeCriteria copy() {
        return new SecurityTypeCriteria(this);
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

    public StringFilter getSecurityTypeCode() {
        return securityTypeCode;
    }

    public StringFilter securityTypeCode() {
        if (securityTypeCode == null) {
            securityTypeCode = new StringFilter();
        }
        return securityTypeCode;
    }

    public void setSecurityTypeCode(StringFilter securityTypeCode) {
        this.securityTypeCode = securityTypeCode;
    }

    public StringFilter getSecurityType() {
        return securityType;
    }

    public StringFilter securityType() {
        if (securityType == null) {
            securityType = new StringFilter();
        }
        return securityType;
    }

    public void setSecurityType(StringFilter securityType) {
        this.securityType = securityType;
    }

    public StringFilter getSecurityTypeDescription() {
        return securityTypeDescription;
    }

    public StringFilter securityTypeDescription() {
        if (securityTypeDescription == null) {
            securityTypeDescription = new StringFilter();
        }
        return securityTypeDescription;
    }

    public void setSecurityTypeDescription(StringFilter securityTypeDescription) {
        this.securityTypeDescription = securityTypeDescription;
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
        final SecurityTypeCriteria that = (SecurityTypeCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(securityTypeCode, that.securityTypeCode) &&
            Objects.equals(securityType, that.securityType) &&
            Objects.equals(securityTypeDescription, that.securityTypeDescription) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, securityTypeCode, securityType, securityTypeDescription, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SecurityTypeCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (securityTypeCode != null ? "securityTypeCode=" + securityTypeCode + ", " : "") +
            (securityType != null ? "securityType=" + securityType + ", " : "") +
            (securityTypeDescription != null ? "securityTypeDescription=" + securityTypeDescription + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}