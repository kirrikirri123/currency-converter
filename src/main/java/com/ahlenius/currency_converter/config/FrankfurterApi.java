package com.ahlenius.currency_converter.config;

import com.ahlenius.currency_converter.dto.FrankfurterResponse;
import com.ahlenius.currency_converter.exception.FrankfurterApiException;
import com.ahlenius.currency_converter.exception.NoRateFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;
// Hela klassen blir en Frankfurterböne var uppdrag är att ta hand om koppling och validering mot frankfurterapiet
@Component
public class FrankfurterApi {

    //RestClient är inbyggd funktionalitet i SpringBoot.
    private final RestClient restClient;

    // SpringBoot automatskapar en böna "direkt" injecten
    public FrankfurterApi(RestClient.Builder restClient) {
        this.restClient = restClient
                .baseUrl("https://api.frankfurter.dev")
                .build();
    }
 // Frankfurter v2 ger svar i en [] även om de bara och oftast är en rad.
    public BigDecimal getRate(String base, String quote) {
            FrankfurterResponse[] rate = restClient.get()// Måste man ha rates [] alltså en array? kan de va möjligt att de blir flera? eller kommer alltid svaret som en array?
                    .uri("/v2/rates?base={from}&quotes={to}", base, quote)
                    .retrieve()
                    .body(FrankfurterResponse[].class);
            if (rate == null || rate.length == 0) {
                throw new NoRateFoundException("Ingen växelkurs hittades för " + base + " till " + quote);
            }
            return rate[0].rate();
            }


}
