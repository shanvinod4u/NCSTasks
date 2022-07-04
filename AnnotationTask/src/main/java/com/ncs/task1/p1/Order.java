package com.ncs.task1.p1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Order {
	@Value("${product.name}")
	private String productName;
	@Value("${product.grossValue}")
	private int grossOrderAmount;
	private int finalOrderAmount;
	
	@Autowired
	@Qualifier("cashOnDelivery")
	private Payment modeOfPayment;

	
	
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String productName, int grossOrderAmount) {
		super();
		this.productName = productName;
		this.grossOrderAmount = grossOrderAmount;
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getGrossOrderAmount() {
		return grossOrderAmount;
	}

	public void setGrossOrderAmount(int grossOrderAmount) {
		this.grossOrderAmount = grossOrderAmount;
	}

	public int getFinalOrderAmount() {
		return finalOrderAmount;
	}

	public void setFinalOrderAmount(int finalOrderAmount) {
		this.finalOrderAmount = finalOrderAmount;
	}



	public Payment getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(Payment modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	@Override
	public String toString() {
		return "Order [productName=" + productName + ", grossOrderAmount=" + grossOrderAmount + ", finalOrderAmount="
				+ finalOrderAmount + "]";
	}


		
}
