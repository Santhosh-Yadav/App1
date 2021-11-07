package in.santhosh.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = Include.NON_NULL)
public class IRCTResponse {

	@JsonProperty
	private StatusInfo statusInfo;

	@JsonProperty("TrainName")
	private String trainName;

	@JsonProperty("TrainNumber")
	private String trainNo;

	@JsonProperty("AvailableTickets")
	private String availableTickets;

	@JsonProperty("BoardingTime")
	private String boardingTime;

	@JsonProperty("DepartureTime")
	private String departureTime;

	@JsonProperty("StartingFrom")
	private String startingFrom;

	@JsonProperty("ToLocation")
	private String toLocation;

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	public String getAvailableTickets() {
		return availableTickets;
	}

	public void setAvailableTickets(String availableTickets) {
		this.availableTickets = availableTickets;
	}

	public String getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getStartingFrom() {
		return startingFrom;
	}

	public void setStartingFrom(String startingFrom) {
		this.startingFrom = startingFrom;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public StatusInfo getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(StatusInfo statusInfo) {
		this.statusInfo = statusInfo;
	}

	@Override
	public String toString() {
		return "IRCTResponse [statusInfo=" + statusInfo + ", trainName=" + trainName + ", trainNo=" + trainNo
				+ ", availableTickets=" + availableTickets + ", boardingTime=" + boardingTime + ", departureTime="
				+ departureTime + ", startingFrom=" + startingFrom + ", toLocation=" + toLocation + "]";
	}

	

}
