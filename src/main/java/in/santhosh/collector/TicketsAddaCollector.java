package in.santhosh.collector;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.santhosh.exception.PosidexException;
import in.santhosh.request.CustomerRequest;
import in.santhosh.response.IRCTResponse;
import in.santhosh.service.TicketsAddaService;

@RestController
@RequestMapping(path = "/api")
public class TicketsAddaCollector  {

	@Autowired
	private TicketsAddaService service;

	Logger logger = Logger.getLogger(TicketsAddaCollector.class);

	@PostMapping(value = "searchTrain", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<IRCTResponse> findTrain(@RequestBody CustomerRequest customerRequest) throws PosidexException {
		List<IRCTResponse> response = new ArrayList<IRCTResponse>();
		logger.info("Inside TicketsAddaCollector class findCustomer method");

		int requestIdCount = service.validateRequestId(customerRequest.getRequestId());

		if (requestIdCount <= 0) {
			try {

				response = service.searchTrainService(customerRequest);
			} catch (PosidexException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else {
			throw new PosidexException("Duplicate RequestId is not allowed");
		}

		logger.info("List Of Trains :: " + response);

		return response;

	}
}
