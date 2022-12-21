package io.github.ungle.kong.client.api.plugins;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.plugins.HMACAuthCredentialsRequest;
import io.github.ungle.kong.client.response.ConsumerResponse;
import io.github.ungle.kong.client.response.plugins.HMACAuthCredentialsResponse;

public interface HMACAuthCredentialsApi {
	/**
	 * Create a HMACAuth credential
	 * @param consumer The username or id property of the consumer
	 * @param request hmac-auth credential configuration
	 * @return added hmac-auth credential
	 */
	@RequestLine("POST /consumers/{consumer}/hmac-auth")
	@Headers("Content-Type: application/json")
	HMACAuthCredentialsResponse add(@Param("consumer") String consumer,HMACAuthCredentialsRequest request);
	
	
	/**
	 * List hmac-auths
	 * 
	 * @return hmac-auth list
	 */
	@RequestLine("GET /hmac-auths")
	ApiDataList<HMACAuthCredentialsResponse> find();
	
	/**
	 * List hmac-auths by offset
	 * @param offset offset
	 * @return hmac-auths list
	 */
	@RequestLine("GET /hmac-auths?offset={offset}")
	ApiDataList<HMACAuthCredentialsResponse> find(@Param("offset") String offset);
	
	/**
	 * Deletes a hmac-auth
	 * 
	 * @param hmacAuth id or username of the hmac-auth credentials
	 */
	@RequestLine("DELETE /hmac-auths/{hmac_auth}")
	void delete(@Param("hmac_auth") String hmacAuth);
	
	/**
	 * Retrieve a hmac-auth
	 * 
	 * @param hmacAuth    id or username of the hmac-auth credentials
	 * @return hmac-auth info
	 */
	@RequestLine("GET /hmac-auths/{hmac_auth}")
	HMACAuthCredentialsResponse retrieve(@Param("hmac_auth") String hmacAuth);
	
	/**
	 * Retrieve the consumer associated with hmac credential
	 * 
	 * @param hmacAuth    id or username of the hmac-auth credentials
	 * @return consumer info
	 */
	@RequestLine("GET /hmac-auths/{hmac_auth}/consumer")
	ConsumerResponse retrieveConsumer(@Param("hmac_auth") String hmacAuth);

	/**
	 * Retrieve hmac-auths by consumer
	 * 
	 * @param consumer The username or id of the consumer
	 * @return hmac-auth list
	 */
	@RequestLine("GET /consumers/{consumer}/hmac-auth")
	ApiDataList<HMACAuthCredentialsResponse> findByConsumer(@Param("consumer") String consumer);

	/**
	 * Retrieve hmac-auths by consumer
	 * 
	 * @param consumer The username or id of the consumer
	 * @param offset offset
	 * @return hmac-auth list
	 */
	@RequestLine("GET /consumers/{consumer}/hmac-auth?offset={offset}")
	ApiDataList<HMACAuthCredentialsResponse> findByConsumerAndOffset(@Param("consumer") String consumer,
			@Param("offset") String offset);

	/**
	 * Retrieve a hmac-auth
	 * @param consumer The username or id property of the consumer entity.
	 * @param hmacAuth The id or username property of hmac-auth
	 * @return hmac-auth info
	 */
	@RequestLine("GET /consumers/{consumer}/hmac-auth/{hmac_auth}")
	HMACAuthCredentialsResponse retrieve(@Param("consumer") String consumer, @Param("hmac_auth") String hmacAuth);
	
	/**
	 * Deletes a hmac-auth
	 * 
	 * @param consumer The username or id property of the consumer entity.
	 * @param hmacAuth The id or username property of the hmac-auth
	 */
	@RequestLine("DELETE /consumers/{consumer}/hmac-auth/{hmac_auth}")
	void delete(@Param("consumer") String consumer, @Param("hmac_auth") String hmacAuth);

}
