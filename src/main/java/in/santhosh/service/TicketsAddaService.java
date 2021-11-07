package in.santhosh.service;

import java.util.List;

import org.json.JSONException;

import in.santhosh.exception.PosidexException;
import in.santhosh.request.CustomerRequest;
import in.santhosh.response.IRCTResponse;

public interface TicketsAddaService {
	
	
	public List<IRCTResponse> searchTrainService(CustomerRequest custReq) throws PosidexException, JSONException;

	public List<IRCTResponse>  ackn(CustomerRequest custReq) throws PosidexException, JSONException;
	
	public int validateRequestId(String requestId);


}
