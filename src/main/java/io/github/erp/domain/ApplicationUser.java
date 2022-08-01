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

/**
 * A ApplicationUser.
 */
@Entity
@Table(name = "application_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "applicationuser")
public class ApplicationUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "designation", nullable = false, unique = true)
    private UUID designation;

    @NotNull
    @Column(name = "application_identity", nullable = false, unique = true)
    private String applicationIdentity;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "paymentLabels", "dealerGroup", "placeholders" }, allowSetters = true)
    private Dealer organization;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "paymentLabels", "dealerGroup", "placeholders" }, allowSetters = true)
    private Dealer department;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "grantedClearances", "placeholders" }, allowSetters = true)
    private SecurityClearance securityClearance;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private User systemIdentity;

    @ManyToMany
    @JoinTable(
        name = "rel_application_user__user_properties",
        joinColumns = @JoinColumn(name = "application_user_id"),
        inverseJoinColumns = @JoinColumn(name = "user_properties_id")
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<UniversallyUniqueMapping> userProperties = new HashSet<>();

    @JsonIgnoreProperties(value = { "paymentLabels", "dealerGroup", "placeholders" }, allowSetters = true)
    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private Dealer dealerIdentity;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ApplicationUser id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getDesignation() {
        return this.designation;
    }

    public ApplicationUser designation(UUID designation) {
        this.setDesignation(designation);
        return this;
    }

    public void setDesignation(UUID designation) {
        this.designation = designation;
    }

    public String getApplicationIdentity() {
        return this.applicationIdentity;
    }

    public ApplicationUser applicationIdentity(String applicationIdentity) {
        this.setApplicationIdentity(applicationIdentity);
        return this;
    }

    public void setApplicationIdentity(String applicationIdentity) {
        this.applicationIdentity = applicationIdentity;
    }

    public Dealer getOrganization() {
        return this.organization;
    }

    public void setOrganization(Dealer dealer) {
        this.organization = dealer;
    }

    public ApplicationUser organization(Dealer dealer) {
        this.setOrganization(dealer);
        return this;
    }

    public Dealer getDepartment() {
        return this.department;
    }

    public void setDepartment(Dealer dealer) {
        this.department = dealer;
    }

    public ApplicationUser department(Dealer dealer) {
        this.setDepartment(dealer);
        return this;
    }

    public SecurityClearance getSecurityClearance() {
        return this.securityClearance;
    }

    public void setSecurityClearance(SecurityClearance securityClearance) {
        this.securityClearance = securityClearance;
    }

    public ApplicationUser securityClearance(SecurityClearance securityClearance) {
        this.setSecurityClearance(securityClearance);
        return this;
    }

    public User getSystemIdentity() {
        return this.systemIdentity;
    }

    public void setSystemIdentity(User user) {
        this.systemIdentity = user;
    }

    public ApplicationUser systemIdentity(User user) {
        this.setSystemIdentity(user);
        return this;
    }

    public Set<UniversallyUniqueMapping> getUserProperties() {
        return this.userProperties;
    }

    public void setUserProperties(Set<UniversallyUniqueMapping> universallyUniqueMappings) {
        this.userProperties = universallyUniqueMappings;
    }

    public ApplicationUser userProperties(Set<UniversallyUniqueMapping> universallyUniqueMappings) {
        this.setUserProperties(universallyUniqueMappings);
        return this;
    }

    public ApplicationUser addUserProperties(UniversallyUniqueMapping universallyUniqueMapping) {
        this.userProperties.add(universallyUniqueMapping);
        return this;
    }

    public ApplicationUser removeUserProperties(UniversallyUniqueMapping universallyUniqueMapping) {
        this.userProperties.remove(universallyUniqueMapping);
        return this;
    }

    public Dealer getDealerIdentity() {
        return this.dealerIdentity;
    }

    public void setDealerIdentity(Dealer dealer) {
        this.dealerIdentity = dealer;
    }

    public ApplicationUser dealerIdentity(Dealer dealer) {
        this.setDealerIdentity(dealer);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApplicationUser)) {
            return false;
        }
        return id != null && id.equals(((ApplicationUser) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ApplicationUser{" +
            "id=" + getId() +
            ", designation='" + getDesignation() + "'" +
            ", applicationIdentity='" + getApplicationIdentity() + "'" +
            "}";
    }
}
