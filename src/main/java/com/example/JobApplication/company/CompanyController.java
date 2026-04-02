package com.example.JobApplication.company;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController
{
    private final CompanyService companyService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllCompany()
    {
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody Company updatedCompany)
    {
        boolean f=companyService.updateCompany(id,updatedCompany);
        if(f)
        {
            return new ResponseEntity<>("Updated company",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("No company found with id = "+id,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Company company)
    {
        return new ResponseEntity<>(companyService.create(company),HttpStatus.CREATED);
    }
}
