package br.com.contjamax.company.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contjamax.company.domain.AuthenticationBean;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BasicAuthenticationController {
    @GetMapping("/basicAuth")
    public AuthenticationBean authenticationBean() {
        return new AuthenticationBean("You are Authenticated");
    }
}