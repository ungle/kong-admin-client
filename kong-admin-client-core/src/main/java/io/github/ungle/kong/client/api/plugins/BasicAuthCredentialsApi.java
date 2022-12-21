package io.github.ungle.kong.client.api.plugins;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.plugins.BasicAuthCredentialsRequest;
import io.github.ungle.kong.client.response.ConsumerResponse;
import io.github.ungle.kong.client.response.plugins.BasicAuthCredentialsResponse;

public interface BasicAuthCredentialsApi {
	/**
	 * Create a BasicAuth credential
	 * @param consumer The username or id property of the consumer
	 * @param request basic-auth credential configuration
	 * @return added basic-auth credential
	 */
	@RequestLine("POST /consumers/{consumer}/basic-auth")
	@Headers("Content-Type: application/json")
	BasicAuthCredentialsResponse add(@Param("consumer") String consumer,BasicAuthCredentialsRequest request);
	
	
	/**
	 * List basic-auths
	 * 
	 * @return basic-auth list
	 */
	@RequestLine("GET /basic-auths")
	ApiDataList<BasicAuthCredentialsResponse> find();
	
	/**
	 * List basic-auths by offset
	 * @param offset offset
	 * @return basic-auths list
	 */
	@RequestLine("GET /basic-auths?offset={offset}")
	ApiDataList<BasicAuthCredentialsResponse> find(@Param("offset") String offset);
	
	/**
	 * Deletes a basic-auth
	 * 
	 * @param basicAuth id or username of the basic-auth credentials
	 */
	@RequestLine("DELETE /basic-auths/{basic_auth}")
	void delete(@Param("basic_auth") String basicAuth);
	
	/**
	 * Retrieve a basic-auth
	 * 
	 * @param basicAuth    id or username of the basic-auth credentials
	 * @return basic-auth info
	 */
	@RequestLine("GET /basic-auths/{basic_auth}")
	BasicAuthCredentialsResponse retrieve(@Param("basic_auth") String basicAuth);
	
	/**
	 * Retrieve the consumer associated with basic-auth credentials
	 * 
	 * @param basicAuth    id or username of the basic-auth credentials
	 * @return consumer info
	 */
	@RequestLine("GET /basic-auths/{basic_auth}/consumer")
	ConsumerResponse retrieveConsumer(@Param("basic_auth") String basicAuth);

	/**
	 * Retrieve basic-auths by consumer
	 * 
	 * @param consumer The username or id of the consumer
	 * @return basic-auth list
	 */
	@RequestLine("GET /consumers/{consumer}/basic-auth")
	ApiDataList<BasicAuthCredentialsResponse> findByConsumer(@Param("consumer") String consumer);

	/**
	 * Retrieve basic-auths by consumer
	 * 
	 * @param consumer The username or id of the consumer
	 * @param offset offset
	 * @return basic-auth list
	 */
	@RequestLine("GET /consumers/{consumer}/basic-auth?offset={offset}")
	ApiDataList<BasicAuthCredentialsResponse> findByConsumerAndOffset(@Param("consumer") String consumer,
			@Param("offset") String offset);

	/**
	 * Retrieve a basic-auth
	 * @param consumer The username or id property of the consumer entity.
	 * @param basicAuth The id or username of the basic-auth credentials
	 * @return basic-auth info
	 */
	@RequestLine("GET /consumers/{consumer}/basic-auth/{basic_auth}")
	BasicAuthCredentialsResponse retrieve(@Param("consumer") String consumer, @Param("basic_auth") String basicAuth);
	
	/**
	 * Deletes a basic-auth
	 * 
	 * @param consumer The username or id property of the consumer entity.
	 * @param basicAuth    The id or username of the basic-auth credentials
	 */
	@RequestLine("DELETE /consumers/{consumer}/basic-auth/{id}")
	void delete(@Param("consumer") String consumer, @Param("basic_auth") String basicAuth);

}
