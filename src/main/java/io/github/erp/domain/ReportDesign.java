package io.github.erp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

/**
 * A ReportDesign.
 */
@Entity
@Table(name = "report_design")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "reportdesign")
public class ReportDesign implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "catalogue_number", nullable = false, unique = true)
    private UUID catalogueNumber;

    @NotNull
    @Column(name = "designation", nullable = false, unique = true)
    private String designation;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "notes")
    private byte[] notes;

    @Column(name = "notes_content_type")
    private String notesContentType;

    @Lob
    @Column(name = "report_file", nullable = false, unique = true)
    private byte[] reportFile;

    @NotNull
    @Column(name = "report_file_content_type", nullable = false)
    private String reportFileContentType;

    @ManyToMany
    @JoinTable(
        name = "rel_report_design__parameters",
        joinColumns = @JoinColumn(name = "report_design_id"),
        inverseJoinColumns = @JoinColumn(name = "parameters_id")
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<UniversallyUniqueMapping> parameters = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "grantedClearances", "placeholders" }, allowSetters = true)
    private SecurityClearance securityClearance;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(
        value = { "organization", "department", "securityClearance", "systemIdentity", "userProperties", "dealerIdentity" },
        allowSetters = true
    )
    private ApplicationUser reportDesigner;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "paymentLabels", "dealerGroup", "placeholders" }, allowSetters = true)
    private Dealer organization;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "paymentLabels", "dealerGroup", "placeholders" }, allowSetters = true)
    private Dealer department;

    @ManyToMany
    @JoinTable(
        name = "rel_report_design__placeholder",
        joinColumns = @JoinColumn(name = "report_design_id"),
        inverseJoinColumns = @JoinColumn(name = "placeholder_id")
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "containingPlaceholder" }, allowSetters = true)
    private Set<Placeholder> placeholders = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    private SystemModule systemModule;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ReportDesign id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getCatalogueNumber() {
        return this.catalogueNumber;
    }

    public ReportDesign catalogueNumber(UUID catalogueNumber) {
        this.setCatalogueNumber(catalogueNumber);
        return this;
    }

    public void setCatalogueNumber(UUID catalogueNumber) {
        this.catalogueNumber = catalogueNumber;
    }

    public String getDesignation() {
        return this.designation;
    }

    public ReportDesign designation(String designation) {
        this.setDesignation(designation);
        return this;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return this.description;
    }

    public ReportDesign description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getNotes() {
        return this.notes;
    }

    public ReportDesign notes(byte[] notes) {
        this.setNotes(notes);
        return this;
    }

    public void setNotes(byte[] notes) {
        this.notes = notes;
    }

    public String getNotesContentType() {
        return this.notesContentType;
    }

    public ReportDesign notesContentType(String notesContentType) {
        this.notesContentType = notesContentType;
        return this;
    }

    public void setNotesContentType(String notesContentType) {
        this.notesContentType = notesContentType;
    }

    public byte[] getReportFile() {
        return this.reportFile;
    }

    public ReportDesign reportFile(byte[] reportFile) {
        this.setReportFile(reportFile);
        return this;
    }

    public void setReportFile(byte[] reportFile) {
        this.reportFile = reportFile;
    }

    public String getReportFileContentType() {
        return this.reportFileContentType;
    }

    public ReportDesign reportFileContentType(String reportFileContentType) {
        this.reportFileContentType = reportFileContentType;
        return this;
    }

    public void setReportFileContentType(String reportFileContentType) {
        this.reportFileContentType = reportFileContentType;
    }

    public Set<UniversallyUniqueMapping> getParameters() {
        return this.parameters;
    }

    public void setParameters(Set<UniversallyUniqueMapping> universallyUniqueMappings) {
        this.parameters = universallyUniqueMappings;
    }

    public ReportDesign parameters(Set<UniversallyUniqueMapping> universallyUniqueMappings) {
        this.setParameters(universallyUniqueMappings);
        return this;
    }

    public ReportDesign addParameters(UniversallyUniqueMapping universallyUniqueMapping) {
        this.parameters.add(universallyUniqueMapping);
        return this;
    }

    public ReportDesign removeParameters(UniversallyUniqueMapping universallyUniqueMapping) {
        this.parameters.remove(universallyUniqueMapping);
        return this;
    }

    public SecurityClearance getSecurityClearance() {
        return this.securityClearance;
    }

    public void setSecurityClearance(SecurityClearance securityClearance) {
        this.securityClearance = securityClearance;
    }

    public ReportDesign securityClearance(SecurityClearance securityClearance) {
        this.setSecurityClearance(securityClearance);
        return this;
    }

    public ApplicationUser getReportDesigner() {
        return this.reportDesigner;
    }

    public void setReportDesigner(ApplicationUser applicationUser) {
        this.reportDesigner = applicationUser;
    }

    public ReportDesign reportDesigner(ApplicationUser applicationUser) {
        this.setReportDesigner(applicationUser);
        return this;
    }

    public Dealer getOrganization() {
        return this.organization;
    }

    public void setOrganization(Dealer dealer) {
        this.organization = dealer;
    }

    public ReportDesign organization(Dealer dealer) {
        this.setOrganization(dealer);
        return this;
    }

    public Dealer getDepartment() {
        return this.department;
    }

    public void setDepartment(Dealer dealer) {
        this.department = dealer;
    }

    public ReportDesign department(Dealer dealer) {
        this.setDepartment(dealer);
        return this;
    }

    public Set<Placeholder> getPlaceholders() {
        return this.placeholders;
    }

    public void setPlaceholders(Set<Placeholder> placeholders) {
        this.placeholders = placeholders;
    }

    public ReportDesign placeholders(Set<Placeholder> placeholders) {
        this.setPlaceholders(placeholders);
        return this;
    }

    public ReportDesign addPlaceholder(Placeholder placeholder) {
        this.placeholders.add(placeholder);
        return this;
    }

    public ReportDesign removePlaceholder(Placeholder placeholder) {
        this.placeholders.remove(placeholder);
        return this;
    }

    public SystemModule getSystemModule() {
        return this.systemModule;
    }

    public void setSystemModule(SystemModule systemModule) {
        this.systemModule = systemModule;
    }

    public ReportDesign systemModule(SystemModule systemModule) {
        this.setSystemModule(systemModule);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReportDesign)) {
            return false;
        }
        return id != null && id.equals(((ReportDesign) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReportDesign{" +
            "id=" + getId() +
            ", catalogueNumber='" + getCatalogueNumber() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", description='" + getDescription() + "'" +
            ", notes='" + getNotes() + "'" +
            ", notesContentType='" + getNotesContentType() + "'" +
            ", reportFile='" + getReportFile() + "'" +
            ", reportFileContentType='" + getReportFileContentType() + "'" +
            "}";
    }
}