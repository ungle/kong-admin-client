package io.github.ungle.kong.client.requests.plugins;

import io.github.ungle.kong.client.requests.Request;

public class BasicAuthCredentialsRequest extends Request {
	
	private String username;
	
	private String password;
	
	public BasicAuthCredentialsRequest() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
