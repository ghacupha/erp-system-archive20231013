package io.github.erp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaxReferenceMapperTest {

    private TaxReferenceMapper taxReferenceMapper;

    @BeforeEach
    public void setUp() {
        taxReferenceMapper = new TaxReferenceMapperImpl();
    }
}
