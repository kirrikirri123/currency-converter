package com.ahlenius.currency_converter.dto;

import java.math.BigDecimal;

public record CurrencyResponse(
        String to,
        String from,
        BigDecimal rate) {
}
