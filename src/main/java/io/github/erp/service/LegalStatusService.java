package io.github.erp.service;

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

import io.github.erp.service.dto.LegalStatusDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link io.github.erp.domain.LegalStatus}.
 */
public interface LegalStatusService {
    /**
     * Save a legalStatus.
     *
     * @param legalStatusDTO the entity to save.
     * @return the persisted entity.
     */
    LegalStatusDTO save(LegalStatusDTO legalStatusDTO);

    /**
     * Partially updates a legalStatus.
     *
     * @param legalStatusDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<LegalStatusDTO> partialUpdate(LegalStatusDTO legalStatusDTO);

    /**
     * Get all the legalStatuses.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<LegalStatusDTO> findAll(Pageable pageable);

    /**
     * Get the "id" legalStatus.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<LegalStatusDTO> findOne(Long id);

    /**
     * Delete the "id" legalStatus.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the legalStatus corresponding to the query.
     *
     * @param query the query of the search.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<LegalStatusDTO> search(String query, Pageable pageable);
}