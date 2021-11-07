package in.santhosh.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import in.santhosh.config.SendAndRecieveJMSMessage;
import in.santhosh.dao.TicketsAddaDao;
import in.santhosh.exception.PosidexException;
import in.santhosh.request.CustomerRequest;
import in.santhosh.response.IRCTResponse;
import in.santhosh.response.StatusInfo;

@Service
public class TicketsAddaServiceImpl implements TicketsAddaService {

	Logger logger = Logger.getLogger(TicketsAddaServiceImpl.class);

	@Autowired
	private TicketsAddaDao dao;

	@Autowired
	private SendAndRecieveJMSMessage jmsMessage;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public List<IRCTResponse> searchTrainService(CustomerRequest custReq) throws PosidexException, JSONException {

		logger.info("In TicketsAddaServiceImpl class searchTrainService method");

		int count = dao.insertTrainSerachDetails(custReq);
		
		Gson gson = new Gson();
		String jsonMessage = gson.toJson(custReq, CustomerRequest.class);
		logger.info("Builded Client Message :: "+jsonMessage);

		if (count > 0) {
			logger.info("Request details inserted successfully");
			try {
				logger.info("Enqueued Message in Request :: "+jsonMessage);
				jmsMessage.sendMessage(jsonMessage);
			} catch (PosidexException e) {
				logger.error("Error while sending message to Queue");
				throw new PosidexException("Error while sending message to Queue");
				
			}
		}
		
		else {
			logger.info("Request details insertion failed");
			throw new PosidexException("Got exception while inserting request details");
		}

		return ackn(custReq);
	}

	@Override
	public List<IRCTResponse> ackn(CustomerRequest custReq) throws PosidexException, JSONException {

		StatusInfo statusInfo = new StatusInfo();
		logger.info("Inside TicketsAddaServiceImpl class ackn method");

		List<IRCTResponse> response = new ArrayList<IRCTResponse>();

		Object receiveAndConvert = jmsTemplate.receiveAndConvert("PRIME360_RESPONSE_QUEUE");

		
		String msg = (String) receiveAndConvert;
		
		logger.info("Message Dequequed in Response :: " + msg);
		JSONObject jsonObject = new JSONObject(msg);
	
		String requestStatus = jsonObject.getString("requestStatus");
		
		logger.info("Request Status :: "+ requestStatus);

		if (requestStatus.equals("C")) {

			response = dao.getTrainDetails(custReq);

		}
		
		else if(requestStatus.equals("E")) {
			logger.info("Internal Error :: E");
			throw new PosidexException("Internal Error :: E");
		}

		else {
			logger.info("Internal Error");
			throw new PosidexException("Internal Error");
		}

		return response;

	}

	@Override
	public int validateRequestId(String requestId) {
		
		return dao.validateRequestId(requestId);
	}

}
