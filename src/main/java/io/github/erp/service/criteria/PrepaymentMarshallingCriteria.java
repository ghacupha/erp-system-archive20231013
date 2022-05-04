package io.github.erp.service.criteria;

import java.io.Serializable;
import java.util.Objects;

import io.github.erp.erp.resources.PrepaymentMarshallingResource;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.BooleanFilter;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.IntegerFilter;
import tech.jhipster.service.filter.LocalDateFilter;
import tech.jhipster.service.filter.LongFilter;

/**
 * Criteria class for the {@link io.github.erp.domain.PrepaymentMarshalling} entity. This class is used
 * in {@link PrepaymentMarshallingResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /prepayment-marshallings?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class PrepaymentMarshallingCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private BooleanFilter inactive;

    private LocalDateFilter amortizationCommencementDate;

    private IntegerFilter amortizationPeriods;

    private LongFilter prepaymentAccountId;

    private LongFilter placeholderId;

    private Boolean distinct;

    public PrepaymentMarshallingCriteria() {}

    public PrepaymentMarshallingCriteria(PrepaymentMarshallingCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.inactive = other.inactive == null ? null : other.inactive.copy();
        this.amortizationCommencementDate = other.amortizationCommencementDate == null ? null : other.amortizationCommencementDate.copy();
        this.amortizationPeriods = other.amortizationPeriods == null ? null : other.amortizationPeriods.copy();
        this.prepaymentAccountId = other.prepaymentAccountId == null ? null : other.prepaymentAccountId.copy();
        this.placeholderId = other.placeholderId == null ? null : other.placeholderId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public PrepaymentMarshallingCriteria copy() {
        return new PrepaymentMarshallingCriteria(this);
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

    public BooleanFilter getInactive() {
        return inactive;
    }

    public BooleanFilter inactive() {
        if (inactive == null) {
            inactive = new BooleanFilter();
        }
        return inactive;
    }

    public void setInactive(BooleanFilter inactive) {
        this.inactive = inactive;
    }

    public LocalDateFilter getAmortizationCommencementDate() {
        return amortizationCommencementDate;
    }

    public LocalDateFilter amortizationCommencementDate() {
        if (amortizationCommencementDate == null) {
            amortizationCommencementDate = new LocalDateFilter();
        }
        return amortizationCommencementDate;
    }

    public void setAmortizationCommencementDate(LocalDateFilter amortizationCommencementDate) {
        this.amortizationCommencementDate = amortizationCommencementDate;
    }

    public IntegerFilter getAmortizationPeriods() {
        return amortizationPeriods;
    }

    public IntegerFilter amortizationPeriods() {
        if (amortizationPeriods == null) {
            amortizationPeriods = new IntegerFilter();
        }
        return amortizationPeriods;
    }

    public void setAmortizationPeriods(IntegerFilter amortizationPeriods) {
        this.amortizationPeriods = amortizationPeriods;
    }

    public LongFilter getPrepaymentAccountId() {
        return prepaymentAccountId;
    }

    public LongFilter prepaymentAccountId() {
        if (prepaymentAccountId == null) {
            prepaymentAccountId = new LongFilter();
        }
        return prepaymentAccountId;
    }

    public void setPrepaymentAccountId(LongFilter prepaymentAccountId) {
        this.prepaymentAccountId = prepaymentAccountId;
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
        final PrepaymentMarshallingCriteria that = (PrepaymentMarshallingCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(inactive, that.inactive) &&
            Objects.equals(amortizationCommencementDate, that.amortizationCommencementDate) &&
            Objects.equals(amortizationPeriods, that.amortizationPeriods) &&
            Objects.equals(prepaymentAccountId, that.prepaymentAccountId) &&
            Objects.equals(placeholderId, that.placeholderId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inactive, amortizationCommencementDate, amortizationPeriods, prepaymentAccountId, placeholderId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PrepaymentMarshallingCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (inactive != null ? "inactive=" + inactive + ", " : "") +
            (amortizationCommencementDate != null ? "amortizationCommencementDate=" + amortizationCommencementDate + ", " : "") +
            (amortizationPeriods != null ? "amortizationPeriods=" + amortizationPeriods + ", " : "") +
            (prepaymentAccountId != null ? "prepaymentAccountId=" + prepaymentAccountId + ", " : "") +
            (placeholderId != null ? "placeholderId=" + placeholderId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
