package com.ncs.task1.p1;

import org.springframework.stereotype.Component;

@Component
public class CashOnDelivery implements Payment {

	public int doPayment(int amount) {
		int serviceCharge = amount *5/100;
		int finalAmount = amount + serviceCharge;
		System.out.println("Payment by CashOnDelivery 5% service charge");
		return finalAmount;
	}

}
