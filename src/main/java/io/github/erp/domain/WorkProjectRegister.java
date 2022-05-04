package io.github.erp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A WorkProjectRegister.
 */
@Entity
@Table(name = "work_project_register")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "workprojectregister")
public class WorkProjectRegister implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "catalogue_number", nullable = false, unique = true)
    private String catalogueNumber;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @Lob
    @Column(name = "details")
    private byte[] details;

    @Column(name = "details_content_type")
    private String detailsContentType;

    @Column(name = "total_project_cost", precision = 21, scale = 2)
    private BigDecimal totalProjectCost;

    @Lob
    @Column(name = "additional_notes")
    private byte[] additionalNotes;

    @Column(name = "additional_notes_content_type")
    private String additionalNotesContentType;

    @ManyToMany
    @NotNull
    @JoinTable(
        name = "rel_work_project_register__dealers",
        joinColumns = @JoinColumn(name = "work_project_register_id"),
        inverseJoinColumns = @JoinColumn(name = "dealers_id")
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "paymentLabels", "dealerGroup", "placeholders" }, allowSetters = true)
    private Set<Dealer> dealers = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "placeholders" }, allowSetters = true)
    private SettlementCurrency settlementCurrency;

    @ManyToMany
    @JoinTable(
        name = "rel_work_project_register__placeholder",
        joinColumns = @JoinColumn(name = "work_project_register_id"),
        inverseJoinColumns = @JoinColumn(name = "placeholder_id")
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "containingPlaceholder" }, allowSetters = true)
    private Set<Placeholder> placeholders = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public WorkProjectRegister id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatalogueNumber() {
        return this.catalogueNumber;
    }

    public WorkProjectRegister catalogueNumber(String catalogueNumber) {
        this.setCatalogueNumber(catalogueNumber);
        return this;
    }

    public void setCatalogueNumber(String catalogueNumber) {
        this.catalogueNumber = catalogueNumber;
    }

    public String getDescription() {
        return this.description;
    }

    public WorkProjectRegister description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getDetails() {
        return this.details;
    }

    public WorkProjectRegister details(byte[] details) {
        this.setDetails(details);
        return this;
    }

    public void setDetails(byte[] details) {
        this.details = details;
    }

    public String getDetailsContentType() {
        return this.detailsContentType;
    }

    public WorkProjectRegister detailsContentType(String detailsContentType) {
        this.detailsContentType = detailsContentType;
        return this;
    }

    public void setDetailsContentType(String detailsContentType) {
        this.detailsContentType = detailsContentType;
    }

    public BigDecimal getTotalProjectCost() {
        return this.totalProjectCost;
    }

    public WorkProjectRegister totalProjectCost(BigDecimal totalProjectCost) {
        this.setTotalProjectCost(totalProjectCost);
        return this;
    }

    public void setTotalProjectCost(BigDecimal totalProjectCost) {
        this.totalProjectCost = totalProjectCost;
    }

    public byte[] getAdditionalNotes() {
        return this.additionalNotes;
    }

    public WorkProjectRegister additionalNotes(byte[] additionalNotes) {
        this.setAdditionalNotes(additionalNotes);
        return this;
    }

    public void setAdditionalNotes(byte[] additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getAdditionalNotesContentType() {
        return this.additionalNotesContentType;
    }

    public WorkProjectRegister additionalNotesContentType(String additionalNotesContentType) {
        this.additionalNotesContentType = additionalNotesContentType;
        return this;
    }

    public void setAdditionalNotesContentType(String additionalNotesContentType) {
        this.additionalNotesContentType = additionalNotesContentType;
    }

    public Set<Dealer> getDealers() {
        return this.dealers;
    }

    public void setDealers(Set<Dealer> dealers) {
        this.dealers = dealers;
    }

    public WorkProjectRegister dealers(Set<Dealer> dealers) {
        this.setDealers(dealers);
        return this;
    }

    public WorkProjectRegister addDealers(Dealer dealer) {
        this.dealers.add(dealer);
        return this;
    }

    public WorkProjectRegister removeDealers(Dealer dealer) {
        this.dealers.remove(dealer);
        return this;
    }

    public SettlementCurrency getSettlementCurrency() {
        return this.settlementCurrency;
    }

    public void setSettlementCurrency(SettlementCurrency settlementCurrency) {
        this.settlementCurrency = settlementCurrency;
    }

    public WorkProjectRegister settlementCurrency(SettlementCurrency settlementCurrency) {
        this.setSettlementCurrency(settlementCurrency);
        return this;
    }

    public Set<Placeholder> getPlaceholders() {
        return this.placeholders;
    }

    public void setPlaceholders(Set<Placeholder> placeholders) {
        this.placeholders = placeholders;
    }

    public WorkProjectRegister placeholders(Set<Placeholder> placeholders) {
        this.setPlaceholders(placeholders);
        return this;
    }

    public WorkProjectRegister addPlaceholder(Placeholder placeholder) {
        this.placeholders.add(placeholder);
        return this;
    }

    public WorkProjectRegister removePlaceholder(Placeholder placeholder) {
        this.placeholders.remove(placeholder);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WorkProjectRegister)) {
            return false;
        }
        return id != null && id.equals(((WorkProjectRegister) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WorkProjectRegister{" +
            "id=" + getId() +
            ", catalogueNumber='" + getCatalogueNumber() + "'" +
            ", description='" + getDescription() + "'" +
            ", details='" + getDetails() + "'" +
            ", detailsContentType='" + getDetailsContentType() + "'" +
            ", totalProjectCost=" + getTotalProjectCost() +
            ", additionalNotes='" + getAdditionalNotes() + "'" +
            ", additionalNotesContentType='" + getAdditionalNotesContentType() + "'" +
            "}";
    }
}