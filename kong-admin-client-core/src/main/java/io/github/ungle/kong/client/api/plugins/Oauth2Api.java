package io.github.ungle.kong.client.api.plugins;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.plugins.OAuth2CredentialsRequest;
import io.github.ungle.kong.client.requests.plugins.OAuth2TokenRequest;
import io.github.ungle.kong.client.response.plugins.OAuth2CredentialsResponse;
import io.github.ungle.kong.client.response.plugins.OAuth2TokenResponse;

/**
 * 
 * @author ungle
 *
 */
public interface Oauth2Api {

    /**
     * Add Credentials of Oauth2
     * @param consumer consumers name or id
     * @param credentialsRequest oauth2credentials
     * @return added credentials
     */
    @RequestLine("POST /consumers/{consumer}/oauth2")
    @Headers("Content-Type: application/json")
    OAuth2CredentialsResponse addCredential(@Param("consumer") String consumer, OAuth2CredentialsRequest credentialsRequest);


    /**
     * Get Credentials of a consumer
     * @param consumer consumers name or id
     * @return credential list
     */
    @RequestLine("GET /consumers/{consumer}/oauth2")
    ApiDataList<OAuth2CredentialsResponse> findByConsumer(@Param("consumer") String consumer);
    
    /**
     * Delete Credential
     * @param credential credential id
     */
    @RequestLine("DELETE /oauth2/{credential}")
    void delete(@Param("credential") String credential);
    
    /**
     * Delete Credential
     * @param consumer consumer id or name
     * @param credential credential id
     */
    @RequestLine("DELETE /consumers/{consumer}/oauth2/{credential}")
    void deleteByConsumer(@Param("consumer") String consumer,@Param("credential") String credential);
    
    /**
     * Create Token
     * @param request token info
     * @return created token info
     */
    @RequestLine("POST /oauth2_tokens")
    @Headers("Content-Type: application/json")
    OAuth2TokenResponse addToken(OAuth2TokenRequest request);
    
    /**
     * Retrieve Token
     * @param tokenId
     * @return token info
     */
    @RequestLine("GET /oauth2_tokens/{token}")
    OAuth2TokenResponse retrieveToken(@Param("token") String tokenId);
    
    /**
     * Update Token
     * @param tokenId token id
     * @param request token info
     * @return updated token info
     */
    @RequestLine("PATCH /oauth2_tokens/{token}")
    @Headers("Content-Type: application/json")
    OAuth2TokenResponse updateToken(@Param("token") String tokenId,OAuth2TokenRequest request);
    
    /**
     * Delete token
     * @param tokenId  token info
     */
    @RequestLine("DELETE /oauth2_tokens/{token}")
    void deleteToken(@Param("token") String tokenId);
    
    /**
     * List all tokens
     * @return token list
     */
    @RequestLine("GET /oauth2_tokens")
    ApiDataList<OAuth2TokenResponse> findToken();
    

}
