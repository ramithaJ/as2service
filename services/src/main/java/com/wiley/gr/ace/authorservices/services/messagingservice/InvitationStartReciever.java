package com.wiley.gr.ace.authorservices.services.messagingservice;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;

public class InvitationStartReciever {
	public void queueReceiver() {
		try {

			InitialContext initCtx = new InitialContext();
			QueueConnectionFactory queueConnFactory = (QueueConnectionFactory) initCtx
					.lookup("myQueueConnectionFactory");
			QueueConnection queueConn = queueConnFactory
					.createQueueConnection();
			queueConn.start();

			QueueSession queueSession = queueConn.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);

			Queue queue = (Queue) initCtx.lookup("myQueue");

			QueueReceiver receiver = queueSession.createReceiver(queue);

			QueueListener listener = new QueueListener();
			receiver.setMessageListener(listener);  
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

	}
}
