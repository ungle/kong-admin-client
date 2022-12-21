package io.github.ungle.kong.client.requests.plugins;

import io.github.ungle.kong.client.requests.Request;

public class KeyAuthCredentialsRequest extends Request {

	private String key;

	private Long ttl;

	public KeyAuthCredentialsRequest() {
		super();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getTtl() {
		return ttl;
	}

	public void setTtl(Long ttl) {
		if(ttl <0L || ttl > 100000000L) {
			throw new IllegalArgumentException("ttl must be an integer between 0 and 100000000");
		}
		this.ttl = ttl;
	}

}
