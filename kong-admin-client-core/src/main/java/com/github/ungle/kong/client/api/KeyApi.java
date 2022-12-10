package com.github.ungle.kong.client.api;

import com.github.ungle.kong.client.model.ApiDataList;
import com.github.ungle.kong.client.requests.KeyRequest;
import com.github.ungle.kong.client.response.KeyResponse;
import com.github.ungle.kong.client.service.TagQueryBuilder;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface KeyApi {
	
	/**
	 * Create Key
	 * @param request key info
	 * @return added key info
	 */
	@RequestLine("POST /keys")
	@Headers("Content-Type: application/json")
	KeyResponse add(KeyRequest request);
	
	/**
	 * Create Key Associated to a Specific Key Set
	 * @param keySet The unique identifier or the name of the Key Set
	 * @param request key info
	 * @return added key info
	 */
	@RequestLine("POST /key-sets/{key_set}/keys")
	@Headers("Content-Type: application/json")
	KeyResponse addByKeySet(@Param("key_set") String keySet,KeyRequest request);
	
	/**
	 * List All Keys
	 * @return keys list
	 */
	@RequestLine("GET /keys")
	ApiDataList<KeyResponse> find();
	
	/**
	 * List Keys Associated to a Specific Key Set
	 * @param keySet The unique identifier or the name of the Key Set
	 * @return keys list
	 */
	@RequestLine("GET /key-sets/{key_set}/keys")
	ApiDataList<KeyResponse> findByKeySet(@Param("key_set") String keySet);
	
	/**
	 * List All Keys by offset
	 * @param offset offset
	 * @return keys list
	 */
	@RequestLine("GET /keys?offset={offset}")
	ApiDataList<KeyResponse> findByOffset(@Param("offset") String offset);
	
	/**
	 * List All Keys by tags
	 * @param tagQueryBuilder tag info
	 * @return keys list
	 */
	@RequestLine("GET /keys?tags={tags}")
	ApiDataList<KeyResponse> findByTag(@Param("tags") TagQueryBuilder tagQueryBuilder);
	
	/**
	 * Update Key
	 * @param request key info
	 * @return updated key info
	 */
	@RequestLine("PATCH /keys/{key}")
	@Headers("Content-Type: application/json")
	KeyResponse update(@Param("key") String key,KeyRequest request);
	
	/**
	 * Update Key Associated to a Specific Key Set
	 * @param keySet The unique identifier or the name of the Key Set
	 * @param key The unique identifier or the name of the Key
	 * @param request key info
	 * @return updated key info
	 */
	@RequestLine("PATCH /key-sets/{key_set}/keys/{key}")
	@Headers("Content-Type: application/json")
	KeyResponse updateByKeySet(@Param("key_set") String keySet,@Param("key") String key,KeyRequest request);
	
	/**
	 * Create Or Update Key
	 * @param key The unique identifier or the name of the Key
	 * @param request key info
	 * @return updated or created key info
	 */
	@RequestLine("PUT /keys/{key}")
	@Headers("Content-Type: application/json")
	KeyResponse updateOrCreate(@Param("key") String key,KeyRequest request);
	
	/**
	 * Create Or Update Key Associated to a Specific Key Set
	 * @param keySet The unique identifier or the name of the Key Set
	 * @param key The unique identifier or the name of the Key
	 * @param request key info
	 * @return updated or created key info
	 */
	@RequestLine("PUT /key-sets/{key_set}/keys/{key}")
	@Headers("Content-Type: application/json")
	KeyResponse updateOrCreateByKeySet(@Param("key_set") String keySet,@Param("key") String key,KeyRequest request);
	
	/**
	 * Retrieve Key
	 * @param key The unique identifier or the name of the Key
	 * @return key info
	 */
	@RequestLine("GET /keys/{key}")
	KeyResponse retrieve(@Param("key") String key);
	
	/**
	 * Retrieve Key Associated to a Specific Key Set
	 * @param keySet The unique identifier or the name of the Key Set
	 * @param key The unique identifier or the name of the Key
	 * @param request key info
	 * @return key info
	 */
	@RequestLine("GET /key-sets/{key_set}/keys/{key}")
	KeyResponse retrieveByKeySet(@Param("key_set") String keySet,@Param("key") String key);
	
	/**
	 * Delete Key
	 * @param key The unique identifier or the name of the Key
	 */
	@RequestLine("DELETE /keys/{key}")
	void delete(@Param("key") String key);	
	
	/**
	 * Delete Key Associated to a Specific Key Set
	 * @param keySet The unique identifier or the name of the Key Set
	 * @param key The unique identifier or the name of the Key
	 * @return
	 */
	@RequestLine("DELETE /key-sets/{key_set}/keys/{key}")
	KeyResponse deleteByKeySet(@Param("key_set") String keySet,@Param("key") String key);

}
