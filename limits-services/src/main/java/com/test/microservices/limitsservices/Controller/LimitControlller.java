package com.test.microservices.limitsservices.Controller;


import com.test.microservices.limitsservices.Configuration.Configuration;
import com.test.microservices.limitsservices.bean.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitControlller {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimits(){
        return new Limits(configuration.getMin(),configuration.getMax());

//        return new Limits(1,1000);
    }
}
