package com.test.microservices.currencyexchangeservice.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class CurrencyExchange {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "cFrom")
    private String from;

    @Column(name = "cTo")
    private String to;

    @JsonIgnore
    private int conversionMultiple;

    private String env;






    public CurrencyExchange(Long id, String from, String to, int conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    @Override
    public String toString() {
        return "CurrencyExchange{" +
            "id=" + id +
            ", from='" + from + '\'' +
            ", to='" + to + '\'' +
            ", conversionMultiple=" + conversionMultiple +
            ", env='" + env + '\'' +
            '}';
    }

    public CurrencyExchange(Long id, String from, String to, int conversionMultiple, String env) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.env = env;
    }

    public CurrencyExchange() {
    }



    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(int conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

}
