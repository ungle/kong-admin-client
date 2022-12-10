package com.github.ungle.kong.client.api;

import com.github.ungle.kong.client.model.ApiDataList;
import com.github.ungle.kong.client.requests.SNIRequest;
import com.github.ungle.kong.client.response.SNIResponse;
import com.github.ungle.kong.client.service.TagQueryBuilder;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
/**
 * 
 * @author ungle
 *
 */
public interface SNIApi {
	
	/**
	 * Create SNI
	 * @param request sni info
	 * @return added sni info
	 */
	@RequestLine("POST /snis")
	@Headers("Content-Type: application/json")
	SNIResponse add(SNIRequest request);
	
	/**
	 * Create SNI Associated to a Specific Certificate
	 * @param certificate The unique identifier of the Certificate that should be associated to the newly-created SNI.
	 * @param request sni info
	 * @return added sni info
	 */
	@RequestLine("POST /certificates/{certificate_id}/snis")
	@Headers("Content-Type: application/json")
	SNIResponse add(@Param("certificate_id") String certificateId,SNIRequest request);
	
	/**
	 * List All SNIs
	 * @return sni info list
	 */
	@RequestLine("GET /snis")
	ApiDataList<SNIResponse> find();
	
	/**
	 * List SNIs Associated to a Specific Certificate
	 * @param certificate The unique identifier of the Certificate whose SNIs are to be retrieved. 
	 * When using this endpoint, only SNIs associated to the specified Certificate will be listed.
	 * @return sni info list
	 */
	@RequestLine("GET /certificates/{certificate_id}/snis")
	ApiDataList<SNIResponse> findByCertificate(@Param("certificate_id") String certificateId);
	
	/**
	 * List All SNIs by offset
	 * @param offset offset
	 * @return sni info list
	 */
	@RequestLine("GET /snis?offset={offset}")
	ApiDataList<SNIResponse> findByOffset(@Param("offset") String offset);
	
	/**
	 * List All SNIs by tags
	 * @param tagQueryBuilder tag info
	 * @return sni info list
	 */
	@RequestLine("GET /snis?tags={tags}")
	ApiDataList<SNIResponse> findByTag(@Param("tags") TagQueryBuilder tagQueryBuilder);
	
	/**
	 * Retrieve SNI
	 * @param sni The unique identifier or the name of the SNI to update
	 * @return sni info
	 */
	@RequestLine("GET /snis/{sni}")
	SNIResponse retrieve(@Param("sni") String sni);
	
	/**
	 * Retrieve SNI Associated to a Specific Certificate
	 * @param certificate The unique identifier of the Certificate to delete
	 * @param sni The unique identifier or the name of the SNI to update
	 * @return sni info
	 */
	@RequestLine("GET /certificates/{certificate_id}/snis/{sni}")
	SNIResponse retrieveByCertificate(@Param("certificate_id") String certificateId,@Param("sni") String sni);
	
	/**
	 * Update SNI
	 * @param request sni info
	 * @return updated sni info
	 */
	@RequestLine("PATCH /snis/{sni}")
	@Headers("Content-Type: application/json")
	SNIResponse update(@Param("sni") String sni,SNIRequest request);
	
	/**
	 * Update SNI Associated to a Specific Certificate
	 * @param certificate The unique identifier of the Certificate to delete
	 * @param sni The unique identifier or the name of the SNI to update
	 * @param request sni info
	 * @return updated sni info
	 */
	@RequestLine("PATCH /certificates/{certificate_id}/snis/{sni}")
	@Headers("Content-Type: application/json")
	SNIResponse updateByCertificate(@Param("certificate_id") String certificateId,@Param("sni") String sni,SNIRequest request);
	
	/**
	 * Create Or Update SNI
	 * @param request sni info
	 * @return updated or created sni info
	 */
	@RequestLine("PUT /snis/{sni}")
	@Headers("Content-Type: application/json")
	SNIResponse updateOrCreate(SNIRequest request,@Param("sni") String sni);
	
	/**
	 * Create Or Update SNI Associated to a Specific Certificate
	 * @param certificate The unique identifier of the Certificate to delete
	 * @param sni The unique identifier or the name of the SNI to update
	 * @param request sni info
	 * @return updated or created sni info
	 */
	@RequestLine("PUT /certificates/{certificate_id}/snis/{sni}")
	@Headers("Content-Type: application/json")
	SNIResponse updateOrCreateByCertificate(@Param("certificate_id") String certificateId,@Param("sni") String sni,SNIRequest request);	
	
	/**
	 * Delete SNI 
	 * @param sni The unique identifier or the name of the SNI to update
	 */
	@RequestLine("DELETE /snis/{sni}")
	void delete(@Param("sni") String sni);
	
	/**
	 * Delete SNI Associated to a Specific Certificate
	 * @param certificate The unique identifier of the Certificate to delete
	 * @param sni The unique identifier or the name of the SNI to update
	 */
	@RequestLine("DELETE /certificates/{certificate_id}/snis/{sni}")
	void deleteByCertificate(@Param("certificate_id") String certificateId,@Param("sni") String sni);		

}
