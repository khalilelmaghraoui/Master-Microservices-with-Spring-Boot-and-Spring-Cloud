package com.microServices.rest.webservices.restfulwebservices.helloWorld;

public class Hello {
    private  String message;

    public Hello(String hello_class) {
        this.message = hello_class;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Hello{" +
            "message='" + message + '\'' +
            '}';
    }
}
