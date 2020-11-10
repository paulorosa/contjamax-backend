package br.com.contjamax.company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.contjamax.company.domain.Company;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyService {
    private static List<Company> companies = new ArrayList<>();

    static {
        for (int i=0; i<5; i++) {
            companies.add(Company.builder().id(i).nickname("A"+i).name("E"+i).build());
        }
    }

    public List<Company> findAll() {
        return companies;
    }

    public Company save (Company company) {
        if (company.getId() == -1) {
            log.info("Creating a new company");
            company.setId(companies.size());
            companies.add(company);
        } else {
            log.info("Updating a new company");
            companies.add((int)company.getId(), company);
        }
        return company;
    }
    public Company delete(long id) {
        Company company = find(id);
        if (company == null) return null;
        if (companies.remove(company)) return company;
        return null;
    }

    public Company find (long id) {
        for(Company company: companies) {
            if (company.getId() == id) return company;
        }
        return null;
    }
}