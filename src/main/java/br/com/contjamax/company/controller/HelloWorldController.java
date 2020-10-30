package br.com.contjamax.company.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.contjamax.company.domain.HelloWorldBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world/{name}")
    public HelloWorldBean helloWorld(@PathVariable String name) {
        return HelloWorldBean.builder().message(String.format("Hello World, %s!", name)).build();
    }
}