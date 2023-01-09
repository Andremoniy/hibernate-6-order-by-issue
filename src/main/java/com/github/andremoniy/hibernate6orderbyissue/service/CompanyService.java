package com.github.andremoniy.hibernate6orderbyissue.service;

import com.github.andremoniy.hibernate6orderbyissue.model.Company;
import com.github.andremoniy.hibernate6orderbyissue.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<Company> findCompanyByName(String name) {
        return companyRepository.findCompanyByName(name);
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

}
