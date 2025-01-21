package com.hercodecommerce.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hercodecommerce.demo.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{

	
	Customer findByEmail(String theEmail);

	
}
