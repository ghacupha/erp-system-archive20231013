package io.github.erp.service;

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
import io.github.erp.domain.*; // for static metamodels
import io.github.erp.domain.Algorithm;
import io.github.erp.repository.AlgorithmRepository;
import io.github.erp.repository.search.AlgorithmSearchRepository;
import io.github.erp.service.criteria.AlgorithmCriteria;
import io.github.erp.service.dto.AlgorithmDTO;
import io.github.erp.service.mapper.AlgorithmMapper;
import java.util.List;
import javax.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Algorithm} entities in the database.
 * The main input is a {@link AlgorithmCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link AlgorithmDTO} or a {@link Page} of {@link AlgorithmDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class AlgorithmQueryService extends QueryService<Algorithm> {

    private final Logger log = LoggerFactory.getLogger(AlgorithmQueryService.class);

    private final AlgorithmRepository algorithmRepository;

    private final AlgorithmMapper algorithmMapper;

    private final AlgorithmSearchRepository algorithmSearchRepository;

    public AlgorithmQueryService(
        AlgorithmRepository algorithmRepository,
        AlgorithmMapper algorithmMapper,
        AlgorithmSearchRepository algorithmSearchRepository
    ) {
        this.algorithmRepository = algorithmRepository;
        this.algorithmMapper = algorithmMapper;
        this.algorithmSearchRepository = algorithmSearchRepository;
    }

    /**
     * Return a {@link List} of {@link AlgorithmDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<AlgorithmDTO> findByCriteria(AlgorithmCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Algorithm> specification = createSpecification(criteria);
        return algorithmMapper.toDto(algorithmRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link AlgorithmDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<AlgorithmDTO> findByCriteria(AlgorithmCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Algorithm> specification = createSpecification(criteria);
        return algorithmRepository.findAll(specification, page).map(algorithmMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(AlgorithmCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Algorithm> specification = createSpecification(criteria);
        return algorithmRepository.count(specification);
    }

    /**
     * Function to convert {@link AlgorithmCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Algorithm> createSpecification(AlgorithmCriteria criteria) {
        Specification<Algorithm> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Algorithm_.id));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), Algorithm_.name));
            }
            if (criteria.getPlaceholderId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getPlaceholderId(),
                            root -> root.join(Algorithm_.placeholders, JoinType.LEFT).get(Placeholder_.id)
                        )
                    );
            }
            if (criteria.getParametersId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getParametersId(),
                            root -> root.join(Algorithm_.parameters, JoinType.LEFT).get(UniversallyUniqueMapping_.id)
                        )
                    );
            }
        }
        return specification;
    }
}
