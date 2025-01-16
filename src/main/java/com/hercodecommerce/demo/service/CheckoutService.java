package com.hercodecommerce.demo.service;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.hercodecommerce.demo.dto.Purchase;
import com.hercodecommerce.demo.dto.PurschaseResponse;

@CrossOrigin("http://localhost:4200")
public interface CheckoutService {

	PurschaseResponse placeOrder(Purchase purchase);
	
	
}
