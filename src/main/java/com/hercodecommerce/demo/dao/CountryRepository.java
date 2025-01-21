package com.hercodecommerce.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hercodecommerce.demo.entity.Country;


@RepositoryRestResource(collectionResourceRel = "countries", path="countries")
public interface CountryRepository  extends JpaRepository<Country, Integer>{

	
	
}
