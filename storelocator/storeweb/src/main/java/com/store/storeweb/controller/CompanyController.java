package com.store.storeweb.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.PostLoad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.services.CompanyService;

import common.CompanyVO;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyrepository;
	
	@GetMapping("/company/active")
	public List<CompanyVO> activeCompany() {
		List<CompanyVO> list = companyrepository.findByIsActive(true);
		for(CompanyVO c : list) {
			System.out.println(c.isActive() +" --> "+c.getCompanyName());
		}
		
		return list;
	}
	
	@GetMapping("/company/all")
	public List<CompanyVO> allCompanies(){
		List<CompanyVO> list = companyrepository.findAll();
		return list;
	}
	
	@GetMapping("/company/{id}")
	public ResponseEntity<CompanyVO> findById(@PathVariable("id") String id){
		CompanyVO company = companyrepository.findByCompanyId(id);
		if(company==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CompanyVO>(company,HttpStatus.OK);
	}
	
	@PostMapping("/company/save")
	public ResponseEntity<CompanyVO> saveCompany(@RequestBody CompanyVO company){
		if(company!=null) {
			Date date = new Date();
			company.setCreatedTime(date);
			company.setActive(true);
			company.setStatus("Active");
			companyrepository.save(company);
			return new ResponseEntity<CompanyVO>(company,HttpStatus.OK);
		}
		return new ResponseEntity<CompanyVO>(HttpStatus.NOT_FOUND);
		
	}
	
//	public void run(String... args) throws Exception {
//
//		repository.deleteAll();
//
//		// save a couple of customers
//		repository.save(new CompanyVO("Frediee Mac", "Active","1001"));
//		repository.save(new CompanyVO("Apple", "Not Active","1002"));
//
//		// fetch all customers
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for (CompanyVO customer : repository.findAll()) {
//			System.out.println(customer);
//		}
//		System.out.println();
//
//		// fetch an individual customer
//		System.out.println("Customer found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");
//		System.out.println(repository.findByCompanyId("1001"));
//
//		System.out.println("Customers found with findByLastName('Smith'):");
//		System.out.println("--------------------------------");
//		for (CompanyVO customer : repository.findByIsActive(false)) {
//			System.out.println(customer);
//		}
//
//	}

}
