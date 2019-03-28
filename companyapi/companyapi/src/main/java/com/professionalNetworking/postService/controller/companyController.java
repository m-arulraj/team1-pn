package com.professionalNetworking.postService.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.professionalNetworking.postService.domain.Company;
import com.professionalNetworking.postService.service.CompanyService;

@RestController
public class companyController {

	@Autowired
	CompanyService companyService;

	@RequestMapping(value = "/api/companies", method = RequestMethod.POST)
	public ResponseEntity<String> saveCompany(@RequestBody Company company) throws URISyntaxException {

		System.out.println(company.getName());
		Company companyObject = companyService.savecompany(company);
		System.out.println(companyObject.getAddress());
		URI uri = new URI("/api/companies/" + companyObject.getId());

		HttpHeaders header = new HttpHeaders();
		header.setLocation(uri);
		return new ResponseEntity<String>(header, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/api/getCompanyById/{id}", method = RequestMethod.GET)
	public Optional<Company> getCompanyData(@PathVariable(value = "id") Long id) {
		return companyService.getCompanyData(id);

	}

	@RequestMapping(value = "/api/company/deleteCompanyById/{id}", method = RequestMethod.DELETE)
	public void deleteCompanyData(@PathVariable(value = "id") Long id) {

		companyService.deleteCompanyData(id);

	}

	@RequestMapping(value = "/api/company/updateCompanyById/{id}/updateName/{name}", method = RequestMethod.PUT)
	public void updateCompany(@PathVariable(value = "id") Long id, @PathVariable(value = "name") String name) {

		companyService.updateCompany(id, name);
	}

	@RequestMapping(value = "/api/companies/all", method = RequestMethod.GET)
	public List<Company> allCompanies() {

		return companyService.getAllCompanies();

	}

}
