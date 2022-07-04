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
	@Qualifier("netBanking")
	private Payment netBankingPayment;
	
	@Autowired
	@Qualifier("cashOnDelivery")
	private Payment codPayment;
	
	@Autowired
	@Qualifier("creditCardPayment")
	private Payment ccPayment;
	
	@Autowired
	@Qualifier("debitCardPayment")
	private Payment dcPayment;
	
	
	
	
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

	

	public Payment getNetBankingPayment() {
		return netBankingPayment;
	}

	public void setNetBankingPayment(Payment netBankingPayment) {
		this.netBankingPayment = netBankingPayment;
	}

	public Payment getCodPayment() {
		return codPayment;
	}

	public void setCodPayment(Payment codPayment) {
		this.codPayment = codPayment;
	}
	
	

	public Payment getCcPayment() {
		return ccPayment;
	}

	public void setCcPayment(Payment ccPayment) {
		this.ccPayment = ccPayment;
	}

	public Payment getDcPayment() {
		return dcPayment;
	}

	public void setDcPayment(Payment dcPayment) {
		this.dcPayment = dcPayment;
	}

	@Override
	public String toString() {
		return "Order [productName=" + productName + ", grossOrderAmount=" + grossOrderAmount + ", finalOrderAmount="
				+ finalOrderAmount + "]";
	}


		
}
