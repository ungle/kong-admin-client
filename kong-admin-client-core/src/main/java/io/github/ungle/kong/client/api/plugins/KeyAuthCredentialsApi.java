package io.github.ungle.kong.client.api.plugins;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.plugins.KeyAuthCredentialsRequest;
import io.github.ungle.kong.client.response.ConsumerResponse;
import io.github.ungle.kong.client.response.plugins.KeyAuthCredentialsResponse;

public interface KeyAuthCredentialsApi {

	/**
	 * Create a KeyAuth credential
	 * 
	 * @param consumer The username or id property of the consumer
	 * @param request  key-auth credential configuration
	 * @return added key-auth credential
	 */
	@RequestLine("POST /consumers/{consumer}/key-auth")
	@Headers("Content-Type: application/json")
	KeyAuthCredentialsResponse add(@Param("consumer") String consumer, KeyAuthCredentialsRequest request);

	/**
	 * List key-auths
	 * 
	 * @return key-auths list
	 */
	@RequestLine("GET /key-auths")
	ApiDataList<KeyAuthCredentialsResponse> find();

	/**
	 * List key-auths by offset
	 * 
	 * @param offset offset
	 * @return key-auths list
	 */
	@RequestLine("GET /key-auths?offset={offset}")
	ApiDataList<KeyAuthCredentialsResponse> find(@Param("offset") String offset);

	/**
	 * Retrieve a key-auth
	 * 
	 * @param keyAuthId The id property of key-auth
	 * @return key-auth info
	 */
	@RequestLine("GET /key-auths/{id}")
	KeyAuthCredentialsResponse retrieve(@Param("id") String keyAuthId);

	/**
	 * Deletes a key-auth
	 * 
	 * @param keyAuthId The id property of the key-auth
	 */
	@RequestLine("DELETE /key-auths/{id}")
	void delete(@Param("id") String keyAuthId);

	/**
	 * Retrieve key-auths by consumer
	 * 
	 * @param consumer The username or id of the consumer
	 * @return key-auth list
	 */
	@RequestLine("GET /consumers/{consumer}/key-auth")
	ApiDataList<KeyAuthCredentialsResponse> findByConsumer(@Param("consumer") String consumer);

	/**
	 * Retrieve key-auths by consumer
	 * 
	 * @param consumer The username or id of the consumer
	 * @param offset   offset
	 * @return key-auth list
	 */
	@RequestLine("GET /consumers/{consumer}/key-auth?offset={offset}")
	ApiDataList<KeyAuthCredentialsResponse> findByConsumerAndOffset(@Param("consumer") String consumer,
			@Param("offset") String offset);
	

	/**
	 * Retrieve a key-auth
	 * 
	 * @param consumer The username or id property of the consumer entity.
	 * @param keyAuthId    The id property of key-auth
	 * @return key-auth info
	 */
	@RequestLine("GET /consumers/{consumer}/key-auth/{id}")
	KeyAuthCredentialsResponse retrieve(@Param("consumer") String consumer, @Param("id") String keyAuthId);
	
	/**
	 * Retrieve the consumer associated with key-auth
	 * 
	 * @param keyAuthId    The id property of key-auth
	 * @return consumer info
	 */
	@RequestLine("GET /key-auths/{id}/consumer")
	ConsumerResponse retrieveConsumer(@Param("id") String keyAuthId);

	/**
	 * Deletes a key-auth
	 * 
	 * @param consumer The username or id property of the consumer entity.
	 * @param keyAuthId    The id property of the key-auth
	 */
	@RequestLine("DELETE /consumers/{consumer}/key-auth/{id}")
	void delete(@Param("consumer") String consumer, @Param("id") String keyAuthId);
	

}
