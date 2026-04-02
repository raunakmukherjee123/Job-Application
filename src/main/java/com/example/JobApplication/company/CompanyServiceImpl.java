package com.example.JobApplication.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Integer id,Company updatedCompany) {
      return companyRepository.findById(id)
               .map(company->{
                   company.setDescription(updatedCompany.getDescription());
                   company.setName(updatedCompany.getName());
                   company.setJobs(updatedCompany.getJobs());
                   companyRepository.save(company);
                   return true;
               }).orElse(false);
    }

    @Override
    public String create(Company company) {
        companyRepository.save(company);
        return "Created company";
    }
}
