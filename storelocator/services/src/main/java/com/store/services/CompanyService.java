package com.store.services;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import common.CompanyVO;

public interface CompanyService extends MongoRepository<CompanyVO, String> {
	
	public List<CompanyVO> findByIsActive(boolean active);
	public List<CompanyVO> findAll();
	public CompanyVO findByCompanyId(String id);

}
