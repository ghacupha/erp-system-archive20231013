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
 * Criteria class for the {@link io.github.erp.domain.SystemModule} entity. This class is used
 * in {@link io.github.erp.web.rest.SystemModuleResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /system-modules?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class SystemModuleCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter moduleName;

    private Boolean distinct;

    public SystemModuleCriteria() {}

    public SystemModuleCriteria(SystemModuleCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.moduleName = other.moduleName == null ? null : other.moduleName.copy();
        this.distinct = other.distinct;
    }

    @Override
    public SystemModuleCriteria copy() {
        return new SystemModuleCriteria(this);
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

    public StringFilter getModuleName() {
        return moduleName;
    }

    public StringFilter moduleName() {
        if (moduleName == null) {
            moduleName = new StringFilter();
        }
        return moduleName;
    }

    public void setModuleName(StringFilter moduleName) {
        this.moduleName = moduleName;
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
        final SystemModuleCriteria that = (SystemModuleCriteria) o;
        return Objects.equals(id, that.id) && Objects.equals(moduleName, that.moduleName) && Objects.equals(distinct, that.distinct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moduleName, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SystemModuleCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (moduleName != null ? "moduleName=" + moduleName + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}