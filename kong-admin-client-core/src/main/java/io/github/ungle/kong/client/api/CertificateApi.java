package io.github.ungle.kong.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.CertificateRequest;
import io.github.ungle.kong.client.response.CertificateResponse;
import io.github.ungle.kong.client.service.TagQueryBuilder;

public interface CertificateApi {
	
	/**
	 * Create Certificate
	 * @param certificateRequest certificate info
	 * @return added certificate
	 */
	
	@RequestLine("POST /certificates")
	@Headers("Content-Type: application/json")
	CertificateResponse add(CertificateRequest certificateRequest);
	
	/**
	 * List All Certificates
	 * @return certificates list
	 */
	
	@RequestLine("GET /certificates")
	ApiDataList<CertificateResponse> find();
	
	/**
	 * Filter Certificates by tag
	 * @param tagQueryBuilder tag query
	 * @return certificates list
	 */
	@RequestLine("GET /certificates?tag={tags}")
	ApiDataList<CertificateResponse> findByTag(@Param("tags") TagQueryBuilder tagQueryBuilder);
	
	/**
     * List Certificates by offset
     *
     * @param offset offset value
     * @return certificates list
     */
    @RequestLine("GET /certificates?offset={offset}")
    ApiDataList<CertificateResponse> findByOffset(@Param("offset") String offset);
	
	/**
	 * Retrieve Certificate
	 * @param certificateId The unique identifier of the Certificate to retrieve
	 * @return certificate info
	 */
	
	@RequestLine("GET /certificates/{certificate_id}")
	CertificateResponse retrieve(@Param("certificate_id") String certificateId);
	
	/**
	 * Retrieve Certificate Associated to a Specific Upstream
	 * @param upstream The unique identifier or the name of the Upstream associated to the Certificate to be retrieved
	 * @return certificate info
	 */
	@RequestLine("GET /upstreams/{upstream}/client_certificate")
	CertificateResponse retrieveByUpstream(@Param("upstream") String upstream);
	
	
	/**
	 * Update Certificate
	 * @param certificateId The unique identifier of the Certificate to retrieve
	 * @param certificateRequest certificate info
	 * @return updated certificate info
	 */
	@RequestLine("PATCH /certificates/{certificate_id}")
	@Headers("Content-Type: application/json")
	CertificateResponse update(@Param("certificate_id") String certificateId,CertificateRequest certificateRequest);
	
	/**
	 * Update Certificate Associated to a Specific Upstream
	 * @param upstream The unique identifier or the name of the Upstream associated to the Certificate to be retrieved
	 * @param certificateRequest certificate info
	 * @return updated certificate info
	 */
	@RequestLine("PATCH /upstreams/{upstream}/client_certificate")
	@Headers("Content-Type: application/json")
	CertificateResponse updateByUpstream(@Param("upstream") String upstream,CertificateRequest certificateRequest);
	
	/**
	 * Create Or Update Certificate
	 * @param certificateId The unique identifier of the Certificate to retrieve
	 * @param certificateRequest certificate info
	 * @return updated or created certificate info
	 */
	@RequestLine("PUT /certificates/{certificate_id}")
	@Headers("Content-Type: application/json")
	CertificateResponse updateOrCreate(@Param("certificate_id") String certificateId,CertificateRequest certificateRequest);
	
	/**
	 * Create Or Update Certificate Associated to a Specific Upstream
	 * @param upstream The unique identifier or the name of the Upstream associated to the Certificate to be retrieved
	 * @param certificateRequest certificate info
	 * @return updated or created certificate info
	 */
	@RequestLine("PUT /upstreams/{upstream}/client_certificate")
	@Headers("Content-Type: application/json")
	CertificateResponse updateOrCreateByUpstream(@Param("upstream") String upstream,CertificateRequest certificateRequest);
	
	/**
	 * Delete Certificate
	 * @param certificateId The unique identifier of the Certificate to retrieve
	 * @return
	 */
	@RequestLine("DELETE /certificates/{certificate_id}")
	CertificateResponse delete(@Param("certificate_id") String certificateId);
	
	/**
	 * Delete Certificate Associated to a Specific Upstream
	 * @param upstream The unique identifier or the name of the Upstream associated to the Certificate to be retrieved
	 * @return
	 */
	@RequestLine("DELETE /upstreams/{upstream}/client_certificate")
	CertificateResponse deleteByUpstream(@Param("upstream") String upstream);

}
