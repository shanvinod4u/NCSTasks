package com.ncs.task1.p1;

import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements Payment{

	public int doPayment(int amount) {
		int cashBackAmount = amount *10/100;
		int finalAmount = amount - cashBackAmount;
		System.out.println("Payment by Credit card payment 10% cashback");
		return finalAmount;
	}


}
