package com.guilloux.poc.test.activemq.listener;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guilloux.poc.test.activemq.JmsProducer;

public class TestProducerConsumerAsync {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "com/guilloux/poc/test/activemq/listener/application-context.xml" });

		System.out.println("envoi des messages");
		JmsProducer jmsProducer = (JmsProducer) appContext
				.getBean("jmsProducer");
		jmsProducer.envoyerMessage("1");
		jmsProducer.envoyerMessage("2");
		jmsProducer.envoyerMessage("3");

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
