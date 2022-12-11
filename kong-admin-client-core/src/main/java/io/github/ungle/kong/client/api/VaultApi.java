package io.github.ungle.kong.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.VaultRequest;
import io.github.ungle.kong.client.response.VaultResponse;
import io.github.ungle.kong.client.service.TagQueryBuilder;

public interface VaultApi {
	
	/**
	 * Create Vault
	 * @param request vault info
	 * @return added vault info
	 */
	@RequestLine("POST /vaults")
	@Headers("Content-Type: application/json")
	VaultResponse add(VaultRequest request);
	
	/**
	 * List All Vaults
	 * @return vaults list
	 */
	@RequestLine("GET /vaults")
	ApiDataList<VaultResponse> find();
	
	/**
	 * List All Vaults by offset
	 * @param offset offset
	 * @return vaults list
	 */
	@RequestLine("GET /vaults?offset={offset}")
	ApiDataList<VaultResponse> findByOffset(@Param("offset") String offset);
	
	/**
	 * List All Vaults by tags
	 * @param tagQueryBuilder tag info
	 * @return vaults list
	 */
	@RequestLine("GET /vaults?tags={tags}")
	ApiDataList<VaultResponse> findByTag(@Param("tags") TagQueryBuilder tagQueryBuilder);
	
	/**
	 * Update Vault
	 * @param vault The unique identifier or the prefix of the Vault
	 * @param request vault info
	 * @return updated vault info
	 */
	@RequestLine("PATCH /vaults/{vault}")
	@Headers("Content-Type: application/json")
	VaultResponse update(@Param("vault") String vault,VaultRequest request);
	
	/**
	 * Create Or Update Vault
	 * @param vault The unique identifier or the prefix of the Vault
	 * @param request vault info
	 * @return updated or created vault info
	 */
	@RequestLine("PUT /vaults/{vault}")
	@Headers("Content-Type: application/json")
	VaultResponse updateOrCreate(@Param("vault") String vault,VaultRequest request);
	
	/**
	 * Retrieve Vault
	 * @param vault The unique identifier or the prefix of the Vault
	 * @return vault info
	 */
	@RequestLine("GET /vaults/{vault}")
	VaultResponse retrieve(@Param("vault") String vault);
	
	/**
	 * Delete Vault
	 * @param vault The unique identifier or the prefix of the Vault
	 */
	@RequestLine("DELETE /vaults/{vault}")
	void delete(@Param("vault") String vault);	

}
