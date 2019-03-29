package com.pnp.adminservice.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pnp.adminservice.domain.Company;

@FeignClient(value = "company-service", path = "/api")
public interface CompanyFeignClient {

	@RequestMapping(value = "/companies/all", method = RequestMethod.GET)
	public List<Company> allCompanies();

	@RequestMapping(value = "/company/deleteCompanyById/{id}", method = RequestMethod.DELETE)
	public void deleteCompanyById(Long id);

}
