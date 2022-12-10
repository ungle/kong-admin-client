package org.kastin.kong.client.requests.plugins;

import org.kastin.kong.client.model.IdNameRelation;
import org.kastin.kong.client.requests.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OAuth2TokenRequest  extends Request{
	
	@JsonProperty("expires_in")
	private Integer expiresIn =3600;
	@JsonProperty("access_token")
    private String accessToken;
	@JsonProperty("credential")
    private IdNameRelation credential;
    private String scope;
    @JsonProperty("authenticated_userid")
    private String authenticatedUserid;
    @JsonProperty("token_type")
    private String tokenType ="bearer";
    private IdNameRelation service;
    private Integer ttl;
    
     public OAuth2TokenRequest() {
		super();
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}


	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public IdNameRelation getCredential() {
		return credential;
	}

	public void setCredential(IdNameRelation credential) {
		this.credential = credential;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getAuthenticatedUserid() {
		return authenticatedUserid;
	}

	public void setAuthenticatedUserid(String authenticatedUserid) {
		this.authenticatedUserid = authenticatedUserid;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public IdNameRelation getService() {
		return service;
	}

	public void setService(IdNameRelation service) {
		this.service = service;
	}

	public Integer getTtl() {
		return ttl;
	}

	public void setTtl(Integer ttl) {
		this.ttl = ttl;
	}
    
    
    
    

}
