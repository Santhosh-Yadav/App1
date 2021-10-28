package in.santhosh.service;

import in.santhosh.exception.PosidexException;
import in.santhosh.request.CustomerRequest;
import in.santhosh.response.IRCTResponse;

public interface TicketsAddaService {
	
	
	public IRCTResponse searchTrainService(CustomerRequest custReq) throws PosidexException;

	public void ackn(CustomerRequest custReq) throws PosidexException;


}
