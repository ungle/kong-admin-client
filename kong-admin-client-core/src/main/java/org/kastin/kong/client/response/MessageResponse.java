package org.kastin.kong.client.response;

public class MessageResponse {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean schemaValidationSuccessful() {
		return "schema validation successful".equals(message);
	}
	

}
