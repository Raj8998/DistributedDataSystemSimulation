package com.ddss.elements;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("BeanInjection.xml");
		DataArbiter arbiter = (DataArbiter)appContext.getBean("Arbiter");
		FileHandler handler = (FileHandler)appContext.getBean("FileHandler");

		arbiter.setHandler(handler);
		handler.setReceiverInstance(arbiter);
		handler.startHandling();
		
		arbiter.printDelegatingStats();
	}

}
