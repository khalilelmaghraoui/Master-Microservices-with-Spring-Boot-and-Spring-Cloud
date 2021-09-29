package com.test.microservices.currencyexchangeservice.controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange,Long> {

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods



    CurrencyExchange findByFromAndTo(String from , String To);
//    We create a query using the JPA criteria API from this, but,
//    essentially,jpa will do the impl and translate it to a query
//    select C from CurrencyExchange C where c.from = ?1 and u.To = ?
}
