package com.microServices.rest.webservices.restfulwebservices.helloWorld;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
    public @ResponseBody String helloWorld(){
        return "hello world";
    }

    @RequestMapping("/hello")
    public Hello helo(){

        return new Hello("hello class");
    }

    @GetMapping(path = "/helloo/path/{name}")
    public Hello hello(@PathVariable String name){
        return new Hello("hello"+name);

    }
    @GetMapping("/hello-world-internationalization")
    public @ResponseBody String helloWorldInternationalization(@RequestHeader(name = "accept-language") Locale locale){

        return messageSource.getMessage("good-morning-message",null,locale);
    }
}
