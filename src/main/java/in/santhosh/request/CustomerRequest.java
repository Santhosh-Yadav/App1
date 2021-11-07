package in.santhosh.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "From", "To", "TrainNo", "TrainName" })
@JsonInclude(value = Include.NON_NULL)
public class CustomerRequest {

	@JsonProperty("TrainNo")
	private String trainNo;

	@JsonProperty("From")
	private String from;

	@JsonProperty("To")
	private String to;

	@JsonProperty("TrainName")
	private String name;

	@JsonProperty("RequestId")
	private String requestId;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CustomerRequest [trainNo=" + trainNo + ", from=" + from + ", to=" + to + ", name=" + name
				+ ", requestId=" + requestId + "]";
	}

}
