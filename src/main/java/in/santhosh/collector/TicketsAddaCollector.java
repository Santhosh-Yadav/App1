package in.santhosh.collector;

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
public class TicketsAddaCollector {
	
	@Autowired
	private TicketsAddaService service;

	@PostMapping(value = "searchCustomer", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public IRCTResponse findCustomer(@RequestBody CustomerRequest customerRequest) throws PosidexException {
		
		
		System.out.println("Inside findCustomer");
		IRCTResponse response = service.searchTrainService(customerRequest);
		
		return response;

	}
}
