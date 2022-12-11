package io.github.ungle.kong.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.KeySetRequest;
import io.github.ungle.kong.client.response.KeySetResponse;
import io.github.ungle.kong.client.service.TagQueryBuilder;

public interface KeySetApi {
	
	/**
	 * Create KeySet
	 * @param request key set info
	 * @return added key set info
	 */
	@RequestLine("POST /key-sets")
	@Headers("Content-Type: application/json")
	KeySetResponse add(KeySetRequest request);
	
	/**
	 * List All KeySets
	 * @return key-sets list
	 */
	@RequestLine("GET /key-sets")
	ApiDataList<KeySetResponse> find();
	
	/**
	 * List All KeySets by offset
	 * @param offset offset
	 * @return key sets list
	 */
	@RequestLine("GET /key-sets?offset={offset}")
	ApiDataList<KeySetResponse> findByOffset(@Param("offset") String offset);
	
	/**
	 * List All KeySets by tags
	 * @param tagQueryBuilder tag info
	 * @return key sets list
	 */
	@RequestLine("GET /key-sets?tags={tags}")
	ApiDataList<KeySetResponse> findByTag(@Param("tags") TagQueryBuilder tagQueryBuilder);
	
	/**
	 * Update KeySet
	 * @param keySet The unique identifier or the name of the KeySet
	 * @param request key set info
	 * @return updated key set info
	 */
	@RequestLine("PATCH /key-sets/{key_set}")
	@Headers("Content-Type: application/json")
	KeySetResponse update(@Param("key_set") String keySet,KeySetRequest request);
	
	/**
	 * Create Or Update KeySet
	 * @param keySet The unique identifier or the name of the KeySet
	 * @param request key set info
	 * @return updated or created key set info
	 */
	@RequestLine("PUT /key-sets/{key_set}")
	@Headers("Content-Type: application/json")
	KeySetResponse updateOrCreate(@Param("key_set") String keySet,KeySetRequest request);
	
	/**
	 * Retrieve KeySet
	 * @param keySet The unique identifier or the name of the KeySet
	 * @return key set info
	 */
	@RequestLine("GET /key-sets/{key_set}")
	KeySetResponse retrieve(@Param("key_set") String keySet);
	
	/**
	 * Delete KeySet
	 * @param keySet The unique identifier or the name of the KeySet
	 */
	@RequestLine("DELETE /key-sets/{key_set}")
	void delete(@Param("key_set") String keySet);	
	
	/**
	 * Retrieve Key Set Associated to a Specific Key
	 * @param key The unique identifier or the name of the Key associated to the Key Set
	 * @return key set list
	 */
	@RequestLine("GET /keys/{key}/set")
	KeySetResponse getKeySet(@Param("key") String key);
	
	/**
	 * Update Key Set Associated to a Specific Key
	 * @param key The unique identifier or the name of the Key associated to the Key Set
	 * @param request key set info
	 * @return updated key info
	 */
	@RequestLine("PATCH /keys/{key}/set")
	@Headers("Content-Type: application/json")
	KeySetResponse updateKeySet(@Param("key") String key,KeySetRequest request);
	
	/**
	 * Create Or Update Key Set Associated to a Specific Key
	 * @param key The unique identifier or the name of the Key associated to the Key Set
	 * @param request key set info
	 * @return
	 * 
	 * Though it appears in the doc, this method cannot work
	 * @RequestLine("PUT /keys/{key}/set")
	 * @Headers("Content-Type: application/json")
	 * KeySetResponse updateOrCreateKeySet(@Param("key") String key,KeySetRequest request);
	 */
	
	
	/**
	 * Delete Key Set Associated to a Specific Key
	 * @param key The unique identifier or the name of the Key associated to the Key Set
	 * Though it appears in the doc, this method cannot work
	 * @RequestLine("DELETE /keys/{key}/set")
	 * void deleteKeySet(@Param("key") String key);
	 */
	
	
	

}
