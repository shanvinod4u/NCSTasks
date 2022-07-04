package com.ncs.task1.p1;

import org.springframework.stereotype.Component;

@Component
public class NetBanking implements Payment {

	public int doPayment(int amount) {
		int cashBackAmount = amount *5/100;
		int finalAmount = amount - cashBackAmount;
		System.out.println("Payment by NetBanking 5% cashback");
		return finalAmount;
	}

}
