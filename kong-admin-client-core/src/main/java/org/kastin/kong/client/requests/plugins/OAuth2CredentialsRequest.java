package org.kastin.kong.client.requests.plugins;


import org.kastin.kong.client.requests.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * add credentials for oauth2
 *
 * @author ungle
 */
public class OAuth2CredentialsRequest extends Request {
    private String name;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("client_secret")
    private String clientSecret;

    @JsonProperty("redirect_uris")
    private String redirectUris;

    @JsonProperty("hash_secret")
    private Boolean hashSecret = Boolean.FALSE;
    
    public OAuth2CredentialsRequest() {
		super();
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(String redirectUris) {
        this.redirectUris = redirectUris;
    }

    public Boolean getHashSecret() {
        return hashSecret;
    }

    public void setHashSecret(Boolean hashSecret) {
        this.hashSecret = hashSecret;
    }
}
