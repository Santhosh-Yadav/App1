package in.santhosh.dao;

import java.util.List;

import in.santhosh.request.CustomerRequest;
import in.santhosh.response.IRCTResponse;

public interface TicketsAddaDao {
	
	public int insertTrainSerachDetails(CustomerRequest custRequest);
	
	public List<IRCTResponse> getTrainDetails(CustomerRequest customerRequest);
	
	public int validateRequestId(String requestId);

}
