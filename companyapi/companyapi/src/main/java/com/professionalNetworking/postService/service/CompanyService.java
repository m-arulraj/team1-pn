package com.professionalNetworking.postService.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.professionalNetworking.postService.Repository.CompanyRepository;
import com.professionalNetworking.postService.domain.Company;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	public Company savecompany(Company company) {

		return companyRepository.save(company);
	}

	public Optional<Company> getCompanyData(Long id) {

		return companyRepository.findById(id);
	}

	public void deleteCompanyData(Long id) {

		
		 companyRepository.deleteById(id);

	}
	
	@Transactional
	public void updateCompany(Long id,String name){
		
		companyRepository.updateCompany(id,name);
	}

}
