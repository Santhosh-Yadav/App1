package in.santhosh.config;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import in.santhosh.exception.PosidexException;

@Component
public class SendAndRecieveJMSMessage {
	@Autowired
	private Environment environment;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${PRIME360_RESPONSE_QUEUE}")
	private String RESPONSE_QUEUE;

	@Value("${PRIME360_REQUEST_QUEUE}")
	private String REQUEST_QUEUE;

	@Value("${PRIME360_RESPONSE_QUEUE_INTRADAY}")
	private String RESPONSE_QUEUE_INTRADAY;

	Logger logger = Logger.getLogger(SendAndRecieveJMSMessage.class);

	private static final String JMS_VALIDATION_MSG = "error while sending message to queue";

	private static final String RESPONSE_VALIDATION = "Active mq is down!";

	public void sendMessage(String clientMessage) throws PosidexException {
		logger.info("Inside sendMessage method");
		logger.info("Sending Message in TicketsAdda class :: " + clientMessage);
		try {
			jmsTemplate.send(REQUEST_QUEUE, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					Message message = (session).createTextMessage(clientMessage);
					// message.setStringProperty("PSX_PSX_ID", String.valueOf(requestId));
					return message;
				}
			});
		} catch (Exception e) {
			logger.error("Error while sending message to Queue");
			throw new PosidexException(RESPONSE_VALIDATION);
		}
	}

	/*
	 * public Object receiveMessage(String requestId) throws PosidexException {
	 * Object receivedMessage = null; logger.info("In receiveMessage method"); try {
	 * //jmsTemplate.setReceiveTimeout(Integer.parseInt(environment.getProperty(
	 * "recieveTimeout")));
	 * 
	 * receivedMessage = jmsTemplate.receiveSelected(RESPONSE_QUEUE, "PSX_PSX_ID='"
	 * + requestId + "'");
	 * 
	 * receivedMessage = jmsTemplate.receiveSelected(RESPONSE_QUEUE);
	 * logger.info("Reciceved Message in TicketsAdda class :: "+receivedMessage); }
	 * catch (Exception e) {
	 * logger.error("Error while recieving message from Queue"); throw new
	 * PosidexException(RESPONSE_VALIDATION); } return receivedMessage;
	 * 
	 * }
	 */
}
