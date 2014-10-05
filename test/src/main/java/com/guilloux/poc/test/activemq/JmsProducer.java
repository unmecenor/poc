package com.guilloux.poc.test.activemq;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JmsProducer {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JmsProducer.class);
	private JmsTemplate jmsTemplate;

	public void envoyerMessage(final String param) {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(final Session session)
					throws JMSException {
				return session.createTextMessage("Message "+param+"|" + new Date());
			}
		});
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(final JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}
