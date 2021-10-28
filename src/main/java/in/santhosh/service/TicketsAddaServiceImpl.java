package in.santhosh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import in.santhosh.config.SendAndRecieveJMSMessage;
import in.santhosh.exception.PosidexException;
import in.santhosh.request.CustomerRequest;
import in.santhosh.response.IRCTResponse;

@Service
public class TicketsAddaServiceImpl implements TicketsAddaService {
	
	@Autowired
	private SendAndRecieveJMSMessage jmsMessage;

	@Override
	public IRCTResponse searchTrainService(CustomerRequest custReq) {
		System.out.println("Inside searchTrainService");
		
		IRCTResponse response = new IRCTResponse();
		
		Gson gson = new Gson();
		String jsonMessage = gson.toJson(custReq, CustomerRequest.class);
		try {
			jmsMessage.sendMessage(jsonMessage, "");
		} catch (PosidexException e) {
			System.out.println("Message Sending Failded");
			e.printStackTrace();
		}
		
		response.setTrainNo("121045");
		/*
		 * try { Object receiveMessage = jmsMessage.receiveMessage("123");
		 * System.out.println("Rec Msg :: "+receiveMessage); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		
		return response;
	}

	@Override
	public void ackn(CustomerRequest custReq) throws PosidexException {
		// TODO Auto-generated method stub
		
	}

}
