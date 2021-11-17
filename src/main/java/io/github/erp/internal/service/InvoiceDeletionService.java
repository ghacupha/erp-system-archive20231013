package io.github.erp.internal.service;

import com.google.common.util.concurrent.Futures;
import io.github.erp.domain.Invoice;
import io.github.erp.internal.framework.batch.DeletionService;
import io.github.erp.repository.InvoiceRepository;
import io.github.erp.repository.search.InvoiceSearchRepository;
import io.github.erp.service.InvoiceQueryService;
import io.github.erp.service.criteria.InvoiceCriteria;
import io.github.erp.service.dto.InvoiceDTO;
import io.github.erp.service.mapper.EntityMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.filter.LongFilter;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Transactional
@Service
public class InvoiceDeletionService implements DeletionService<Invoice> {

    private final InvoiceRepository repository;
    private final InvoiceSearchRepository searchRepository;
    private final InvoiceQueryService queryService;
    private final EntityMapper<InvoiceDTO, Invoice> mapper;

    public InvoiceDeletionService(InvoiceRepository repository, InvoiceSearchRepository searchRepository, InvoiceQueryService queryService, EntityMapper<InvoiceDTO, Invoice> mapper) {
        this.repository = repository;
        this.searchRepository = searchRepository;
        this.queryService = queryService;
        this.mapper = mapper;
    }

    /**
     * Implements batch deletion for entities with the ids in the list provided
     *
     * @param list of ids of objects to delete
     * @return List of deleted and detached objects
     */
    @Override
    @Async
    public Future<List<Invoice>> delete(final List<Long> list) {
        List<Invoice> deletedAccounts = new CopyOnWriteArrayList<>();

        Optional<List<Invoice>> deletable = Optional.of(new CopyOnWriteArrayList<>());

        List<InvoiceCriteria> criteriaList = new CopyOnWriteArrayList<>();

        list.forEach(
            id -> {
                LongFilter idFilter = new LongFilter();
                idFilter.setEquals(id);
                InvoiceCriteria criteria = new InvoiceCriteria();
                criteria.setId(idFilter);
                criteriaList.add(criteria);
            }
        );

        mapCriteriaList(deletable, criteriaList);

        deletable.ifPresent(deletedAccounts::addAll);

        deletable.ifPresent(repository::deleteAll);

        deletable.ifPresent(
            deletableItems ->
                searchRepository.deleteAll(
                    // use deletable
                    deletableItems
                        .stream()
                        .filter(ac -> searchRepository.existsById(ac.getId()))
                        .collect(Collectors.toList())
                )
        );

        return Futures.immediateFuture(deletedAccounts);
    }

    public void mapCriteriaList(Optional<List<Invoice>> deletable, List<InvoiceCriteria> criteriaList) {
        criteriaList.forEach(
            criteria ->
                deletable.ifPresent(
                    toDelete ->
                        toDelete.addAll(
                            queryService
                                .findByCriteria(criteria)
                                .stream()
                                .map(mapper::toEntity)
                                .collect(Collectors.toList())
                        )
                )
        );
    }
}