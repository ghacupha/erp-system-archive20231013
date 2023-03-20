package io.github.erp.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of {@link LeaseContractSearchRepository} to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class LeaseContractSearchRepositoryMockConfiguration {

    @MockBean
    private LeaseContractSearchRepository mockLeaseContractSearchRepository;
}
