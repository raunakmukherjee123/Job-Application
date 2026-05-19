package com.example.JobApplication.company;

import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();
    boolean updateCompany(Integer id,Company updatedCompany);

    String create(Company company);

    boolean delete(Integer id);

    Company getById(Integer id);
}
