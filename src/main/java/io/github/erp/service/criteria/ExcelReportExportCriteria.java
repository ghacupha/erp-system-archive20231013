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
import tech.jhipster.service.filter.UUIDFilter;
import tech.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link io.github.erp.domain.ExcelReportExport} entity. This class is used
 * in {@link io.github.erp.web.rest.ExcelReportExportResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /excel-report-exports?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ExcelReportExportCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter reportName;

    private StringFilter reportPassword;

    private ZonedDateTimeFilter reportTimeStamp;

    private UUIDFilter reportId;

    private LongFilter placeholderId;

    private LongFilter parametersId;

    private LongFilter reportStatusId;

    private LongFilter securityClearanceId;

    private LongFilter reportCreatorId;

    private LongFilter organizationId;

    private LongFilter departmentId;

    private LongFilter systemModuleId;

    private LongFilter reportDesignId;

    private Boolean distinct;

    public ExcelReportExportCriteria() {}

    public ExcelReportExportCriteria(ExcelReportExportCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.reportName = other.reportName == null ? null : other.reportName.copy();
        this.reportPassword = other.reportPassword == null ? null : other.reportPassword.copy();
        this.reportTimeStamp = other.reportTimeStamp == null ? null : other.reportTimeStamp.copy();
        this.reportId = other.reportId == null ? null : other.reportId.copy();
        this.placeholderId = other.placeholderId == null ? null : other.placeholderId.copy();
        this.parametersId = other.parametersId == null ? null : other.parametersId.copy();
        this.reportStatusId = other.reportStatusId == null ? null : other.reportStatusId.copy();
        this.securityClearanceId = other.securityClearanceId == null ? null : other.securityClearanceId.copy();
        this.reportCreatorId = other.reportCreatorId == null ? null : other.reportCreatorId.copy();
        this.organizationId = other.organizationId == null ? null : other.organizationId.copy();
        this.departmentId = other.departmentId == null ? null : other.departmentId.copy();
        this.systemModuleId = other.systemModuleId == null ? null : other.systemModuleId.copy();
        this.reportDesignId = other.reportDesignId == null ? null : other.reportDesignId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public ExcelReportExportCriteria copy() {
        return new ExcelReportExportCriteria(this);
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

    public StringFilter getReportName() {
        return reportName;
    }

    public StringFilter reportName() {
        if (reportName == null) {
            reportName = new StringFilter();
        }
        return reportName;
    }

    public void setReportName(StringFilter reportName) {
        this.reportName = reportName;
    }

    public StringFilter getReportPassword() {
        return reportPassword;
    }

    public StringFilter reportPassword() {
        if (reportPassword == null) {
            reportPassword = new StringFilter();
        }
        return reportPassword;
    }

    public void setReportPassword(StringFilter reportPassword) {
        this.reportPassword = reportPassword;
    }

    public ZonedDateTimeFilter getReportTimeStamp() {
        return reportTimeStamp;
    }

    public ZonedDateTimeFilter reportTimeStamp() {
        if (reportTimeStamp == null) {
            reportTimeStamp = new ZonedDateTimeFilter();
        }
        return reportTimeStamp;
    }

    public void setReportTimeStamp(ZonedDateTimeFilter reportTimeStamp) {
        this.reportTimeStamp = reportTimeStamp;
    }

    public UUIDFilter getReportId() {
        return reportId;
    }

    public UUIDFilter reportId() {
        if (reportId == null) {
            reportId = new UUIDFilter();
        }
        return reportId;
    }

    public void setReportId(UUIDFilter reportId) {
        this.reportId = reportId;
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

    public LongFilter getReportStatusId() {
        return reportStatusId;
    }

    public LongFilter reportStatusId() {
        if (reportStatusId == null) {
            reportStatusId = new LongFilter();
        }
        return reportStatusId;
    }

    public void setReportStatusId(LongFilter reportStatusId) {
        this.reportStatusId = reportStatusId;
    }

    public LongFilter getSecurityClearanceId() {
        return securityClearanceId;
    }

    public LongFilter securityClearanceId() {
        if (securityClearanceId == null) {
            securityClearanceId = new LongFilter();
        }
        return securityClearanceId;
    }

    public void setSecurityClearanceId(LongFilter securityClearanceId) {
        this.securityClearanceId = securityClearanceId;
    }

    public LongFilter getReportCreatorId() {
        return reportCreatorId;
    }

    public LongFilter reportCreatorId() {
        if (reportCreatorId == null) {
            reportCreatorId = new LongFilter();
        }
        return reportCreatorId;
    }

    public void setReportCreatorId(LongFilter reportCreatorId) {
        this.reportCreatorId = reportCreatorId;
    }

    public LongFilter getOrganizationId() {
        return organizationId;
    }

    public LongFilter organizationId() {
        if (organizationId == null) {
            organizationId = new LongFilter();
        }
        return organizationId;
    }

    public void setOrganizationId(LongFilter organizationId) {
        this.organizationId = organizationId;
    }

    public LongFilter getDepartmentId() {
        return departmentId;
    }

    public LongFilter departmentId() {
        if (departmentId == null) {
            departmentId = new LongFilter();
        }
        return departmentId;
    }

    public void setDepartmentId(LongFilter departmentId) {
        this.departmentId = departmentId;
    }

    public LongFilter getSystemModuleId() {
        return systemModuleId;
    }

    public LongFilter systemModuleId() {
        if (systemModuleId == null) {
            systemModuleId = new LongFilter();
        }
        return systemModuleId;
    }

    public void setSystemModuleId(LongFilter systemModuleId) {
        this.systemModuleId = systemModuleId;
    }

    public LongFilter getReportDesignId() {
        return reportDesignId;
    }

    public LongFilter reportDesignId() {
        if (reportDesignId == null) {
            reportDesignId = new LongFilter();
        }
        return reportDesignId;
    }

    public void setReportDesignId(LongFilter reportDesignId) {
        this.reportDesignId = reportDesignId;
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
        final ExcelReportExportCriteria that = (ExcelReportExportCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(reportName, that.reportName) &&
            Objects.equals(reportPassword, that.reportPassword) &&
            Objects.equals(reportTimeStamp, that.reportTimeStamp) &&
            Objects.equals(reportId, that.reportId) &&
            Objects.equals(placeholderId, that.placeholderId) &&
            Objects.equals(parametersId, that.parametersId) &&
            Objects.equals(reportStatusId, that.reportStatusId) &&
            Objects.equals(securityClearanceId, that.securityClearanceId) &&
            Objects.equals(reportCreatorId, that.reportCreatorId) &&
            Objects.equals(organizationId, that.organizationId) &&
            Objects.equals(departmentId, that.departmentId) &&
            Objects.equals(systemModuleId, that.systemModuleId) &&
            Objects.equals(reportDesignId, that.reportDesignId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            reportName,
            reportPassword,
            reportTimeStamp,
            reportId,
            placeholderId,
            parametersId,
            reportStatusId,
            securityClearanceId,
            reportCreatorId,
            organizationId,
            departmentId,
            systemModuleId,
            reportDesignId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ExcelReportExportCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (reportName != null ? "reportName=" + reportName + ", " : "") +
            (reportPassword != null ? "reportPassword=" + reportPassword + ", " : "") +
            (reportTimeStamp != null ? "reportTimeStamp=" + reportTimeStamp + ", " : "") +
            (reportId != null ? "reportId=" + reportId + ", " : "") +
            (placeholderId != null ? "placeholderId=" + placeholderId + ", " : "") +
            (parametersId != null ? "parametersId=" + parametersId + ", " : "") +
            (reportStatusId != null ? "reportStatusId=" + reportStatusId + ", " : "") +
            (securityClearanceId != null ? "securityClearanceId=" + securityClearanceId + ", " : "") +
            (reportCreatorId != null ? "reportCreatorId=" + reportCreatorId + ", " : "") +
            (organizationId != null ? "organizationId=" + organizationId + ", " : "") +
            (departmentId != null ? "departmentId=" + departmentId + ", " : "") +
            (systemModuleId != null ? "systemModuleId=" + systemModuleId + ", " : "") +
            (reportDesignId != null ? "reportDesignId=" + reportDesignId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}