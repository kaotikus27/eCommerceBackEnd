package com.hercodecommerce.demo.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hercodecommerce.demo.dao.CustomerRepository;
import com.hercodecommerce.demo.dto.Purchase;
import com.hercodecommerce.demo.dto.PurschaseResponse;
import com.hercodecommerce.demo.entity.Customer;
import com.hercodecommerce.demo.entity.Order;
import com.hercodecommerce.demo.entity.OrderItem;

import jakarta.transaction.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService{

	private CustomerRepository customerRepository;
	
	
	
	@Autowired
	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}



	@Override
	@Transactional
	public PurschaseResponse placeOrder(Purchase purchase) {

//		retrieve the order info from dto
		Order order = purchase.getOrder();		
		
//		generate tracking number
		String orderTrackingNumber= generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		
//		populate order with orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));
		
//		populate order with billingAddress and shippingAddress
		order.setBillinAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getBillingAddress());
		
//		populate customer with order
		Customer customer = purchase.getCustomer();
		
// check if this is an existing customer
		String theEmail = customer.getEmail();
		
		Customer customerFromDBCustomer= customerRepository.findByEmail(theEmail);
		
		if(customerFromDBCustomer !=null) {
			
			customer = customerFromDBCustomer;
		}
		
		
		customer.add(order);
		
		
//		save to the database
		customerRepository.save(customer);
		
//		return a response
		
		
		return new PurschaseResponse(orderTrackingNumber);
		
	
		
	}



	private String generateOrderTrackingNumber() {
		// generate a unique id that is hard to guess and random UUID nuymber (UUID version-4)
		
		return UUID.randomUUID().toString();	
	}

	
	
}
