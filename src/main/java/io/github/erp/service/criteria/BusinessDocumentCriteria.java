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
 * Criteria class for the {@link io.github.erp.domain.BusinessDocument} entity. This class is used
 * in {@link io.github.erp.web.rest.BusinessDocumentResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /business-documents?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class BusinessDocumentCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter documentTitle;

    private StringFilter description;

    private UUIDFilter documentSerial;

    private ZonedDateTimeFilter lastModified;

    private StringFilter attachmentFilePath;

    private LongFilter createdById;

    private LongFilter lastModifiedById;

    private LongFilter originatingDepartmentId;

    private LongFilter applicationMappingsId;

    private LongFilter placeholderId;

    private Boolean distinct;

    public BusinessDocumentCriteria() {}

    public BusinessDocumentCriteria(BusinessDocumentCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.documentTitle = other.documentTitle == null ? null : other.documentTitle.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.documentSerial = other.documentSerial == null ? null : other.documentSerial.copy();
        this.lastModified = other.lastModified == null ? null : other.lastModified.copy();
        this.attachmentFilePath = other.attachmentFilePath == null ? null : other.attachmentFilePath.copy();
        this.createdById = other.createdById == null ? null : other.createdById.copy();
        this.lastModifiedById = other.lastModifiedById == null ? null : other.lastModifiedById.copy();
        this.originatingDepartmentId = other.originatingDepartmentId == null ? null : other.originatingDepartmentId.copy();
        this.applicationMappingsId = other.applicationMappingsId == null ? null : other.applicationMappingsId.copy();
        this.placeholderId = other.placeholderId == null ? null : other.placeholderId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public BusinessDocumentCriteria copy() {
        return new BusinessDocumentCriteria(this);
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

    public StringFilter getDocumentTitle() {
        return documentTitle;
    }

    public StringFilter documentTitle() {
        if (documentTitle == null) {
            documentTitle = new StringFilter();
        }
        return documentTitle;
    }

    public void setDocumentTitle(StringFilter documentTitle) {
        this.documentTitle = documentTitle;
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

    public UUIDFilter getDocumentSerial() {
        return documentSerial;
    }

    public UUIDFilter documentSerial() {
        if (documentSerial == null) {
            documentSerial = new UUIDFilter();
        }
        return documentSerial;
    }

    public void setDocumentSerial(UUIDFilter documentSerial) {
        this.documentSerial = documentSerial;
    }

    public ZonedDateTimeFilter getLastModified() {
        return lastModified;
    }

    public ZonedDateTimeFilter lastModified() {
        if (lastModified == null) {
            lastModified = new ZonedDateTimeFilter();
        }
        return lastModified;
    }

    public void setLastModified(ZonedDateTimeFilter lastModified) {
        this.lastModified = lastModified;
    }

    public StringFilter getAttachmentFilePath() {
        return attachmentFilePath;
    }

    public StringFilter attachmentFilePath() {
        if (attachmentFilePath == null) {
            attachmentFilePath = new StringFilter();
        }
        return attachmentFilePath;
    }

    public void setAttachmentFilePath(StringFilter attachmentFilePath) {
        this.attachmentFilePath = attachmentFilePath;
    }

    public LongFilter getCreatedById() {
        return createdById;
    }

    public LongFilter createdById() {
        if (createdById == null) {
            createdById = new LongFilter();
        }
        return createdById;
    }

    public void setCreatedById(LongFilter createdById) {
        this.createdById = createdById;
    }

    public LongFilter getLastModifiedById() {
        return lastModifiedById;
    }

    public LongFilter lastModifiedById() {
        if (lastModifiedById == null) {
            lastModifiedById = new LongFilter();
        }
        return lastModifiedById;
    }

    public void setLastModifiedById(LongFilter lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public LongFilter getOriginatingDepartmentId() {
        return originatingDepartmentId;
    }

    public LongFilter originatingDepartmentId() {
        if (originatingDepartmentId == null) {
            originatingDepartmentId = new LongFilter();
        }
        return originatingDepartmentId;
    }

    public void setOriginatingDepartmentId(LongFilter originatingDepartmentId) {
        this.originatingDepartmentId = originatingDepartmentId;
    }

    public LongFilter getApplicationMappingsId() {
        return applicationMappingsId;
    }

    public LongFilter applicationMappingsId() {
        if (applicationMappingsId == null) {
            applicationMappingsId = new LongFilter();
        }
        return applicationMappingsId;
    }

    public void setApplicationMappingsId(LongFilter applicationMappingsId) {
        this.applicationMappingsId = applicationMappingsId;
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
        final BusinessDocumentCriteria that = (BusinessDocumentCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(documentTitle, that.documentTitle) &&
            Objects.equals(description, that.description) &&
            Objects.equals(documentSerial, that.documentSerial) &&
            Objects.equals(lastModified, that.lastModified) &&
            Objects.equals(attachmentFilePath, that.attachmentFilePath) &&
            Objects.equals(createdById, that.createdById) &&
            Objects.equals(lastModifiedById, that.lastModifiedById) &&
            Objects.equals(originatingDepartmentId, that.originatingDepartmentId) &&
            Objects.equals(applicationMappingsId, that.applicationMappingsId) &&
            Objects.equals(placeholderId, that.placeholderId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            documentTitle,
            description,
            documentSerial,
            lastModified,
            attachmentFilePath,
            createdById,
            lastModifiedById,
            originatingDepartmentId,
            applicationMappingsId,
            placeholderId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BusinessDocumentCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (documentTitle != null ? "documentTitle=" + documentTitle + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (documentSerial != null ? "documentSerial=" + documentSerial + ", " : "") +
            (lastModified != null ? "lastModified=" + lastModified + ", " : "") +
            (attachmentFilePath != null ? "attachmentFilePath=" + attachmentFilePath + ", " : "") +
            (createdById != null ? "createdById=" + createdById + ", " : "") +
            (lastModifiedById != null ? "lastModifiedById=" + lastModifiedById + ", " : "") +
            (originatingDepartmentId != null ? "originatingDepartmentId=" + originatingDepartmentId + ", " : "") +
            (applicationMappingsId != null ? "applicationMappingsId=" + applicationMappingsId + ", " : "") +
            (placeholderId != null ? "placeholderId=" + placeholderId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
