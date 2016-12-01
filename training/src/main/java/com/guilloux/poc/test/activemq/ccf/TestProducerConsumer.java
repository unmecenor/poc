package com.guilloux.poc.test.activemq.ccf;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guilloux.poc.test.activemq.JmsConsumer;
import com.guilloux.poc.test.activemq.JmsProducer;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class TestProducerConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestProducerConsumer.class);

	public static void main(String[] args) {
		// assume SLF4J is bound to logback in the current environment
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		// print logback's internal status
		StatusPrinter.print(lc);
		// LOGGER.info("youhou");
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "com/guilloux/poc/test/activemq/ccf/application-context.xml" });

		System.out.println("envoi du message");
		LOGGER.info("envoi du message");
		JmsProducer jmsProducer = (JmsProducer) appContext.getBean("jmsProducer");
		jmsProducer.envoyerMessage("1");

		try {
			System.out.println("arret activeMQ");
			System.in.read();
			System.out.println("relance activeMQ");
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("reception du message");
		JmsConsumer jmsConsumer = (JmsConsumer) appContext.getBean("jmsConsumer");
		jmsConsumer.recevoirMessage();
		appContext.close();

	}
}
