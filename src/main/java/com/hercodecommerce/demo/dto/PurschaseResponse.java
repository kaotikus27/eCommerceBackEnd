package com.hercodecommerce.demo.dto;

public class PurschaseResponse {

	private String orderTrackingNumber;

	public PurschaseResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurschaseResponse(String orderTrackingNumber) {
		super();
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

	@Override
	public String toString() {
		return "PurschaseResponse [orderTrackingNumber=" + orderTrackingNumber + "]";
	}
	
	
	
	
	
}
