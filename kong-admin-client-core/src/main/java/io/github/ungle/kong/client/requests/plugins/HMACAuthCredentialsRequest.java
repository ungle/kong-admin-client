package io.github.ungle.kong.client.requests.plugins;

import io.github.ungle.kong.client.requests.Request;

public class HMACAuthCredentialsRequest extends Request {
	
	private String username;
	
	private String secret;
	
	public HMACAuthCredentialsRequest() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	

}
