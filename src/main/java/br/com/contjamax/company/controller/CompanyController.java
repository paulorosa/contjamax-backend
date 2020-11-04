package br.com.contjamax.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.contjamax.company.domain.Company;
import br.com.contjamax.company.service.CompanyService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping("/companies")
    public List<Company> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        Company company = service.delete(id);
        if (company != null) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}