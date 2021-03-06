package com.synectiks.fee.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of {@link DueDateSearchRepository} to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class DueDateSearchRepositoryMockConfiguration {

    @MockBean
    private DueDateSearchRepository mockDueDateSearchRepository;

}
