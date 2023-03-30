package io.github.erp.internal.model.mapping;

/*-
 * Erp System - Mark III No 12 (Caleb Series) Server ver 1.0.5-SNAPSHOT
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
import io.github.erp.domain.enumeration.CurrencyTypes;
import io.github.erp.internal.framework.MapUtils;
import io.github.erp.internal.framework.Mapping;
import io.github.erp.internal.model.SignedPaymentEVM;
import io.github.erp.service.dto.SignedPaymentDTO;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.time.LocalDate;

import static io.github.erp.internal.model.mapping.CurrencyMappingUtility.enumToString;
import static io.github.erp.internal.model.mapping.CurrencyMappingUtility.stringToEnum;

@Mapper(componentModel = "spring")
public interface SignedPaymentEVMMapping extends Mapping<SignedPaymentEVM, SignedPaymentDTO> {

    @org.mapstruct.Mapping(target = "transactionDate", source = "transactionDate")
    default LocalDate dateStringToLocalDate(String dateString) {
        return MapUtils.dateStringToLocalDate(dateString);
    }

    @org.mapstruct.Mapping(target = "transactionDate", source = "transactionDate")
    default String localDateToDateString(LocalDate localDateValue) {
        return MapUtils.localDateToDateString(localDateValue);
    }

    @org.mapstruct.Mapping(target = "transactionAmount", source = "transactionAmount")
    default BigDecimal toBigDecimalValue(Double doubleValue) {
        return MapUtils.doubleToBigDecimal(doubleValue);
    }

    @org.mapstruct.Mapping(target = "transactionAmount", source = "transactionAmount")
    default Double toDoubleValue(BigDecimal bigDecimalValue) {
        return MapUtils.bigDecimalToDouble(bigDecimalValue);
    }

    @org.mapstruct.Mapping(target = "transactionCurrency", source = "transactionCurrency")
    default CurrencyTypes currencyMapping(String currencyCode) {
        return stringToEnum(currencyCode);
    }

    @org.mapstruct.Mapping(target = "transactionCurrency", source = "transactionCurrency")
    default String currencyMapping(CurrencyTypes currencyCode) {
        return enumToString(currencyCode);
    }
}
