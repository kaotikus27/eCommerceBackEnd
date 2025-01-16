package com.hercodecommerce.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hercodecommerce.demo.dto.Purchase;
import com.hercodecommerce.demo.dto.PurschaseResponse;
import com.hercodecommerce.demo.service.CheckoutService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
	
	private CheckoutService checkoutService;

	@Autowired
	public CheckoutController(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}
	
	@PostMapping
	public PurschaseResponse placeOrder(@RequestBody Purchase purchase) {
		PurschaseResponse purschaseResponse = checkoutService.placeOrder(purchase);
		
		return purschaseResponse;
	}
	
}
