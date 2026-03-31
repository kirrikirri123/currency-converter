package com.ahlenius.currency_converter.service;

import com.ahlenius.currency_converter.config.FrankfurterApi;
import com.ahlenius.currency_converter.dto.CurrencyResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class CurrencyService {

    private final FrankfurterApi frankfurterApi;

    public CurrencyService(FrankfurterApi frankfurterApi) {
        this.frankfurterApi = frankfurterApi;
    }

    public CurrencyResponse convert(String from, String to) {
        BigDecimal currencyRate = frankfurterApi.getRate(from,to);
        return new CurrencyResponse(
                from,
                to,
                currencyRate.setScale(4, RoundingMode.HALF_UP));
    }

}
