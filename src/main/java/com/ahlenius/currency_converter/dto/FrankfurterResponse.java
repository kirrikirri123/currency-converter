package com.ahlenius.currency_converter.dto;

import java.math.BigDecimal;

public record FrankfurterResponse(
        String date,
        String base,
        String quote,
        BigDecimal rate
) {
}
