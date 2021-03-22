package com.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import net.com.springmvc.entity.Employee;

@Component
public class EmployeeProducer {
	Logger logger = LoggerFactory.getLogger(EmployeeProducer.class);
	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendTo(String destination, Employee emp) {
		jmsTemplate.convertAndSend(destination, emp);
		logger.info("Message sent to ActiveMq");
	}
}