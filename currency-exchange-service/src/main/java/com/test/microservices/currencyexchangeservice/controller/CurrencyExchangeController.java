package com.test.microservices.currencyexchangeservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepo repo;

    @Autowired
    private Environment environment;


    @GetMapping("/currencyExchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

//        CurrencyExchange cur =new CurrencyExchange(1000L,from,to, 59);
//        CurrencyExchange currencyExchange = repo.findByFromAndTo()
        String port = environment.getProperty("local.server.port");

      CurrencyExchange currencyExchange= repo.findByFromAndTo(from,to);

        currencyExchange.setEnv(port);
        return currencyExchange;

    }


}
