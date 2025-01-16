package com.hercodecommerce.demo.dto;

import java.util.Set;

import com.hercodecommerce.demo.entity.Address;
import com.hercodecommerce.demo.entity.Customer;
import com.hercodecommerce.demo.entity.Order;
import com.hercodecommerce.demo.entity.OrderItem;

public class Purchase {

	private Customer customer;
	
	private Address shippAddress;
	
	private Address billingAddress;
	
	private Order order;
	
	private Set<OrderItem> orderItems;

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Purchase(Customer customer, Address shippAddress, Address billingAddress, Order order,
			Set<OrderItem> orderItems) {
		super();
		this.customer = customer;
		this.shippAddress = shippAddress;
		this.billingAddress = billingAddress;
		this.order = order;
		this.orderItems = orderItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getShippAddress() {
		return shippAddress;
	}

	public void setShippAddress(Address shippAddress) {
		this.shippAddress = shippAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Purchase [customer=" + customer + ", shippAddress=" + shippAddress + ", billingAddress="
				+ billingAddress + ", order=" + order + ", orderItems=" + orderItems + "]";
	}
	
	
	
}
