package com.ncs.task1.p1;

import org.springframework.stereotype.Component;

@Component
public class DebitCardPayment implements Payment {

	public int doPayment(int amount) {
		int serviceCharge = amount *10/100;
		int finalAmount = amount + serviceCharge;
		System.out.println("Payment by debitCardPayment 10% service charge");
		return finalAmount;
	}

}
