package com.ncs.task1.p1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		ApplicationContext spring = new ClassPathXmlApplicationContext("spring-config.xml");
		Order o = (Order)spring.getBean("order");
		o.setFinalOrderAmount(o.getModeOfPayment().doPayment(o.getGrossOrderAmount()));
		System.out.println(o);
			
		
	}

}
