package in.santhosh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import in.santhosh.request.CustomerRequest;
import in.santhosh.response.IRCTResponse;

@Repository
public class TicketsAddaDaoImpl implements TicketsAddaDao {
	
	Logger logger = Logger.getLogger(TicketsAddaDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment environment;
	
	@Override
	public int insertTrainSerachDetails(CustomerRequest custRequest) {
		
		logger.info("In TicketsAddaDaoImpl class insertTrainSerachDetails method");
		
		Gson gson = new Gson();
		String requestJson = gson.toJson(custRequest);
		
		String sql = environment.getProperty("insert_mmt_request_query");
		
		logger.info("Insert Request Details Query :: "+sql);
		
		int count = jdbcTemplate.update(sql,custRequest.getRequestId(),custRequest.getFrom(),custRequest.getTo(),requestJson);
		
		return count;
	}

	@Override
	public List<IRCTResponse> getTrainDetails(CustomerRequest customerRequest) {
		
		logger.info("In TicketsAddaDaoImpl class getTrainDetails method");
		
		List<IRCTResponse> listOfTrains = new ArrayList<IRCTResponse>();
	
		String sql = environment.getProperty("get_request_details");
		
		logger.info("Get Required Train Details Query :: "+sql);
		
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<IRCTResponse>>() {

			@Override
			public List<IRCTResponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				while(rs.next()) {
					IRCTResponse response = new IRCTResponse();
					response.setTrainName(rs.getString("train_name"));
					response.setTrainNo(rs.getString("train_number"));
					response.setStartingFrom(rs.getString("starting_from"));
					response.setToLocation(rs.getString("to_location"));
					response.setAvailableTickets(rs.getString("available_tickets"));
					response.setBoardingTime(rs.getString("boarding_time"));
					response.setDepartureTime(rs.getString("departure_time"));
				
					
					listOfTrains.add(response);
				}
				
				return listOfTrains;
			}
		},customerRequest.getRequestId());
		
		
	}

	@Override
	public int validateRequestId(String requestId) {
		
		String sql = environment.getProperty("validate_request_id");
		
		return jdbcTemplate.queryForObject(sql, new Object[] {requestId}, Integer.class);
	}

}
