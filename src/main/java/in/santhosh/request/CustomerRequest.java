package in.santhosh.request;

public class CustomerRequest {

	private String trainNo;
	private String from;
	private String to;
	private String name;

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
		return "CustomerRequest [trainNo=" + trainNo + ", from=" + from + ", to=" + to + ", name=" + name + "]";
	}

}
