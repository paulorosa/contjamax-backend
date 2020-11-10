package br.com.contjamax.company.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @GetMapping("/companies/{id}")
    public Company find(@PathVariable long id) {
        return service.find(id);
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity<Company> update(@PathVariable long id, @RequestBody Company company) {
        Company companyUpdated = service.save(company);
        return new ResponseEntity<Company>(companyUpdated, HttpStatus.OK);
    }

    @PostMapping("/companies")
    public ResponseEntity<Company> create(@RequestBody Company company) {
        Company companyCreated = service.save(company);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(companyCreated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        Company company = service.delete(id);
        if (company != null) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}