package io.github.erp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class XlsxReportRequisitionMapperTest {

    private XlsxReportRequisitionMapper xlsxReportRequisitionMapper;

    @BeforeEach
    public void setUp() {
        xlsxReportRequisitionMapper = new XlsxReportRequisitionMapperImpl();
    }
}
