package com.guilloux.poc.test.activemq;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

public class JmsConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JmsConsumer.class);
	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void recevoirMessage() {
		Message msg = jmsTemplate.receive();
		try {
			TextMessage textMessage = (TextMessage) msg;
			if (msg != null) {
				System.out.println("Message = " + textMessage.getText());
				LOGGER.info("Message = " + textMessage.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setJmsTemplate(final JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}
