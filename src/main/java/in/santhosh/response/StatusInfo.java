package in.santhosh.response;

public class StatusInfo {

	private String requestStatus;
	private String message;
	private String description;
	private String errorCode;

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "StatusInfo [requestStatus=" + requestStatus + ", message=" + message + ", description=" + description
				+ ", errorCode=" + errorCode + "]";
	}

}
