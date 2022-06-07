package io.github.erp.internal.report;

/*-
 * Erp System - Mark II No 7 (Artaxerxes Series)
 * Copyright © 2021 Edwin Njeru (mailnjeru@gmail.com)
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

import io.github.erp.service.dto.XlsxReportRequisitionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class XLSXAssemblyService implements ReportAssemblyService<XlsxReportRequisitionDTO> {


    private final static Logger log = LoggerFactory.getLogger(XLSXAssemblyService.class);

    private final TemplatePresentation templatePresentation;
    private final XLSXReportsService reportsService;

    public XLSXAssemblyService(TemplatePresentation templatePresentation, XLSXReportsService reportsService) {
        this.templatePresentation = templatePresentation;
        this.reportsService = reportsService;
    }

    @Override
    public String createReport(XlsxReportRequisitionDTO dto, String fileExtension) {
        String fileName = templatePresentation.presentTemplate(dto.getReportTemplate());

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("title", dto.getReportName());
        parameters.put("description", dto.getReportTemplate().getDescription());

        return reportsService.generateReport(
            fileName,
            dto.getReportId().toString().concat(fileExtension),
            dto.getUserPassword(),
            dto.getUserPassword(),
            parameters
        );

    }
}
