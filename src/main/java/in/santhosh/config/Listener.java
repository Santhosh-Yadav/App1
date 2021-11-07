//package in.santhosh.config;
//
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.Session;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.core.MessageCreator;
//import org.springframework.stereotype.Component;
//
//import in.santhosh.exception.PosidexException;
//import in.santhosh.response.IRCTResponse;
//
//@Component
//public class Listener {
//	
//	Logger logger = Logger.getLogger(Listener.class);
//	
//	@Autowired
//	private JmsTemplate jmsTemplate;
//	
//	@JmsListener(destination = "PRIME360_RESPONSE_QUEUE")
//	public void consumeMsg(String msg) throws PosidexException {
//		
//		logger.info("Conusmed Msg in TicketsAdda class :: "+msg);
//		
//		if(msg != null) {
//			
//		
//		}
//		
//	//	String clientMessage = "{\"trainNo\":\"1000\",\"from\":\"HYD\",\"to\":\"MNCL\",\"name\":\"Santhosh Express\"}";
//	//	int requestId = 1234;
//	/*
//	 * try { jmsTemplate.send("PRIME360_RESPONSE_QUEUE", new MessageCreator() {
//	 * 
//	 * @Override public Message createMessage(Session session) throws JMSException {
//	 * Message message = (session).createTextMessage(clientMessage);
//	 * //message.setStringProperty("PSX_PSX_ID", String.valueOf(requestId)); return
//	 * message; } }); } catch (Exception e) {
//	 * logger.error("Error while sending message to Queue"); throw new
//	 * PosidexException("Error while sending message to Queue"); }
//	 */
//	}
//
//}
