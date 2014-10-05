package com.guilloux.poc.test.activemq;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProducerConsumer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
		        new String[] {"com/guilloux/poc/test/activemq/application-context.xml" });
		    System.out.println("envoi du message");
		    JmsProducer jmsProducer = (JmsProducer) appContext.getBean("jmsProducer");
		    jmsProducer.envoyerMessage("1");
		   
		    System.out.println("reception du message");
		    JmsConsumer jmsConsumer = (JmsConsumer) appContext.getBean("jmsConsumer");
		    jmsConsumer.recevoirMessage();

	}

}
