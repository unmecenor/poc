package com.guilloux.poc.test.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MonSimpleMessageListener implements MessageListener{
	public void onMessage(final Message message) {
	    try {
	      System.out.println("debut reception message");
	      TextMessage msg = (TextMessage) message;
	      System.out.println(" Message recu : " + msg.getText());
	    } catch (JMSException e) {
	      e.printStackTrace();
	    }
	    System.out.println("fin reception message");
	  }

}
