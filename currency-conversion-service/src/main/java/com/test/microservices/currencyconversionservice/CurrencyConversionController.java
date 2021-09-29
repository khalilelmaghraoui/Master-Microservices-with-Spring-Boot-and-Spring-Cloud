package com.test.microservices.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy FeinProxy;

    @GetMapping("/currency-conversion-fein/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(
        @PathVariable String from,
        @PathVariable String to,
        @PathVariable BigDecimal quantity
        ){


        CurrencyConversion currencyConversion = FeinProxy.retrieveExchangeValue(from, to);




        return new CurrencyConversion(currencyConversion.getId()
            ,from,to,currencyConversion.getConversionMultiple(),quantity,BigDecimal.ONE,currencyConversion.getEnv());

    }

}
