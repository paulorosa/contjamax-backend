package br.com.contjamax.company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.contjamax.company.domain.Company;

@Service
public class CompanyService {
    private static List<Company> companies = new ArrayList<>();

    static {
        for (int i=1; i<5; i++) {
            companies.add(Company.builder().nickname("A"+i).name("E"+i).build());
        }
    }

    public List<Company> findAll() {
        return companies;
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