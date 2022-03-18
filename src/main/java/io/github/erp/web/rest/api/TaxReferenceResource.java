package io.github.erp.web.rest.api;

import io.github.erp.repository.TaxReferenceRepository;
import io.github.erp.service.TaxReferenceQueryService;
import io.github.erp.service.TaxReferenceService;
import io.github.erp.service.criteria.TaxReferenceCriteria;
import io.github.erp.service.dto.TaxReferenceDTO;
import io.github.erp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link io.github.erp.domain.TaxReference}.
 */
@RestController("DevTaxReferenceResource")
@RequestMapping("/api/dev")
public class TaxReferenceResource {

    private final Logger log = LoggerFactory.getLogger(TaxReferenceResource.class);

    private static final String ENTITY_NAME = "paymentsTaxReference";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TaxReferenceService taxReferenceService;

    private final TaxReferenceRepository taxReferenceRepository;

    private final TaxReferenceQueryService taxReferenceQueryService;

    public TaxReferenceResource(
        TaxReferenceService taxReferenceService,
        TaxReferenceRepository taxReferenceRepository,
        TaxReferenceQueryService taxReferenceQueryService
    ) {
        this.taxReferenceService = taxReferenceService;
        this.taxReferenceRepository = taxReferenceRepository;
        this.taxReferenceQueryService = taxReferenceQueryService;
    }

    /**
     * {@code POST  /tax-references} : Create a new taxReference.
     *
     * @param taxReferenceDTO the taxReferenceDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new taxReferenceDTO, or with status {@code 400 (Bad Request)} if the taxReference has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/tax-references")
    public ResponseEntity<TaxReferenceDTO> createTaxReference(@Valid @RequestBody TaxReferenceDTO taxReferenceDTO)
        throws URISyntaxException {
        log.debug("REST request to save TaxReference : {}", taxReferenceDTO);
        if (taxReferenceDTO.getId() != null) {
            throw new BadRequestAlertException("A new taxReference cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TaxReferenceDTO result = taxReferenceService.save(taxReferenceDTO);
        return ResponseEntity
            .created(new URI("/api/tax-references/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /tax-references/:id} : Updates an existing taxReference.
     *
     * @param id the id of the taxReferenceDTO to save.
     * @param taxReferenceDTO the taxReferenceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated taxReferenceDTO,
     * or with status {@code 400 (Bad Request)} if the taxReferenceDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the taxReferenceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/tax-references/{id}")
    public ResponseEntity<TaxReferenceDTO> updateTaxReference(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody TaxReferenceDTO taxReferenceDTO
    ) throws URISyntaxException {
        log.debug("REST request to update TaxReference : {}, {}", id, taxReferenceDTO);
        if (taxReferenceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, taxReferenceDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!taxReferenceRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        TaxReferenceDTO result = taxReferenceService.save(taxReferenceDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, taxReferenceDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /tax-references/:id} : Partial updates given fields of an existing taxReference, field will ignore if it is null
     *
     * @param id the id of the taxReferenceDTO to save.
     * @param taxReferenceDTO the taxReferenceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated taxReferenceDTO,
     * or with status {@code 400 (Bad Request)} if the taxReferenceDTO is not valid,
     * or with status {@code 404 (Not Found)} if the taxReferenceDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the taxReferenceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/tax-references/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<TaxReferenceDTO> partialUpdateTaxReference(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody TaxReferenceDTO taxReferenceDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update TaxReference partially : {}, {}", id, taxReferenceDTO);
        if (taxReferenceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, taxReferenceDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!taxReferenceRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<TaxReferenceDTO> result = taxReferenceService.partialUpdate(taxReferenceDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, taxReferenceDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /tax-references} : get all the taxReferences.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of taxReferences in body.
     */
    @GetMapping("/tax-references")
    public ResponseEntity<List<TaxReferenceDTO>> getAllTaxReferences(TaxReferenceCriteria criteria, Pageable pageable) {
        log.debug("REST request to get TaxReferences by criteria: {}", criteria);
        Page<TaxReferenceDTO> page = taxReferenceQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /tax-references/count} : count all the taxReferences.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/tax-references/count")
    public ResponseEntity<Long> countTaxReferences(TaxReferenceCriteria criteria) {
        log.debug("REST request to count TaxReferences by criteria: {}", criteria);
        return ResponseEntity.ok().body(taxReferenceQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /tax-references/:id} : get the "id" taxReference.
     *
     * @param id the id of the taxReferenceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the taxReferenceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/tax-references/{id}")
    public ResponseEntity<TaxReferenceDTO> getTaxReference(@PathVariable Long id) {
        log.debug("REST request to get TaxReference : {}", id);
        Optional<TaxReferenceDTO> taxReferenceDTO = taxReferenceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(taxReferenceDTO);
    }

    /**
     * {@code DELETE  /tax-references/:id} : delete the "id" taxReference.
     *
     * @param id the id of the taxReferenceDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/tax-references/{id}")
    public ResponseEntity<Void> deleteTaxReference(@PathVariable Long id) {
        log.debug("REST request to delete TaxReference : {}", id);
        taxReferenceService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }

    /**
     * {@code SEARCH  /_search/tax-references?query=:query} : search for the taxReference corresponding
     * to the query.
     *
     * @param query the query of the taxReference search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/tax-references")
    public ResponseEntity<List<TaxReferenceDTO>> searchTaxReferences(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of TaxReferences for query {}", query);
        Page<TaxReferenceDTO> page = taxReferenceService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}