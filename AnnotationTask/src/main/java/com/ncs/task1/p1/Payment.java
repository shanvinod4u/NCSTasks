package com.ncs.task1.p1;

import org.springframework.stereotype.Component;

@Component
public interface Payment {
	
	public int doPayment(int amount);
}
