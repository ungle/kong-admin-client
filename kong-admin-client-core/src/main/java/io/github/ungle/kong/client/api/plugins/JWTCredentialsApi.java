package io.github.ungle.kong.client.api.plugins;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.plugins.JWTCredentialsRequest;
import io.github.ungle.kong.client.response.ConsumerResponse;
import io.github.ungle.kong.client.response.plugins.JWTCredentialsResponse;

public interface JWTCredentialsApi {

	/**
	 * Create a JWT credential
	 * 
	 * @param consumer The username or id property of the consumer
	 * @param request  jwt credential configuration
	 * @return added jwt credential
	 */
	@RequestLine("POST /consumers/{consumer}/jwt")
	@Headers("Content-Type: application/json")
	JWTCredentialsResponse add(@Param("consumer") String consumer, JWTCredentialsRequest request);

	/**
	 * List jwts
	 * 
	 * @return jwts list
	 */
	@RequestLine("GET /jwts")
	ApiDataList<JWTCredentialsResponse> find();

	/**
	 * List jwts by offset
	 * 
	 * @param offset offset
	 * @return jwts list
	 */
	@RequestLine("GET /jwts?offset={offset}")
	ApiDataList<JWTCredentialsResponse> find(@Param("offset") String offset);

	/**
	 * Retrieve a jwt
	 * 
	 * @param jwtId The id property of jwt
	 * @return jwt info
	 */
	@RequestLine("GET /jwts/{id}")
	JWTCredentialsResponse retrieve(@Param("id") String jwtId);

	/**
	 * Deletes a jwt
	 * 
	 * @param jwtId The id property of the jwt
	 */
	@RequestLine("DELETE /jwts/{id}")
	void delete(@Param("id") String jwtId);

	/**
	 * Retrieve jwts by consumer
	 * 
	 * @param consumer The username or id of the consumer
	 * @return jwt list
	 */
	@RequestLine("GET /consumers/{consumer}/jwt")
	ApiDataList<JWTCredentialsResponse> findByConsumer(@Param("consumer") String consumer);

	/**
	 * Retrieve jwts by consumer
	 * 
	 * @param consumer The username or id of the consumer
	 * @param offset   offset
	 * @return jwt list
	 */
	@RequestLine("GET /consumers/{consumer}/jwt?offset={offset}")
	ApiDataList<JWTCredentialsResponse> findByConsumerAndOffset(@Param("consumer") String consumer,
			@Param("offset") String offset);
	

	/**
	 * Retrieve a jwt
	 * 
	 * @param consumer The username or id property of the consumer entity.
	 * @param jwtId    The id property of jwt
	 * @return jwt info
	 */
	@RequestLine("GET /consumers/{consumer}/jwt/{id}")
	JWTCredentialsResponse retrieve(@Param("consumer") String consumer, @Param("id") String jwtId);
	
	/**
	 * Retrieve the consumer associated with jwt
	 * 
	 * @param jwtId    The id property of jwt
	 * @return consumer info
	 */
	@RequestLine("GET /jwts/{id}/consumer")
	ConsumerResponse retrieveConsumer(@Param("id") String jwtId);

	/**
	 * Deletes a jwt
	 * 
	 * @param consumer The username or id property of the consumer entity.
	 * @param jwtId    The id property of the jwt
	 */
	@RequestLine("DELETE /consumers/{consumer}/jwt/{id}")
	void delete(@Param("consumer") String consumer, @Param("id") String jwtId);
	

}
