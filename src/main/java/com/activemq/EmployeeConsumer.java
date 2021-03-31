package com.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import net.com.springmvc.entity.Employee;

@Component
public class EmployeeConsumer {
	Logger logger = LoggerFactory.getLogger(EmployeeConsumer.class);

	@JmsListener(destination = "${activemq.destination}", containerFactory = "jmsFactory")
	public void processToDo(Employee emp) {
		logger.info("This message is consumed from ActiveMq" + emp);
	}
}