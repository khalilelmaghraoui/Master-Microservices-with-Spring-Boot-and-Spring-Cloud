package com.test.microservices.limitsservices.Configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "limit-service")
public class Configuration {
    private int max;
    private int min;

    public Configuration(int max, int min) {
        this.max = max;
        this.min = min;
    }


    public Configuration() {
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
