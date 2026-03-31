package com.ahlenius.currency_converter.controller;


import com.ahlenius.currency_converter.dto.CurrencyResponse;
import com.ahlenius.currency_converter.service.CurrencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/currency")
public class CurrencyController {

    private final CurrencyService service;

    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/rate")
    public ResponseEntity<BigDecimal> getRate(@RequestParam String from, @RequestParam String to) {
        CurrencyResponse response = service.convert(from, to);
        return ResponseEntity.ok(response.rate()); // plockar ut bigdecimal från responsen

    }





}
