package org.kastin.kong.client.api;

import org.kastin.kong.client.model.ApiDataList;
import org.kastin.kong.client.requests.CACertificateRequest;
import org.kastin.kong.client.response.CACertificateResponse;
import org.kastin.kong.client.service.TagQueryBuilder;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface CACertificateApi {
	
	/**
	 * Create CA Certificate
	 * @param caCertificateRequest ca certificate info
	 * @return created ca certificate info
	 */
	
	@RequestLine("POST /ca_certificates")
	@Headers("Content-Type: application/json")
	CACertificateResponse add(CACertificateRequest caCertificateRequest);
	
	/**
	 * List All CA Certificates
	 * @return ca certificate list
	 */
	@RequestLine("GET /ca_certificates")
	ApiDataList<CACertificateResponse> find();
	
	/**
	 * List CA Certificates by offset
	 * @param offset offset
	 * @return ca certificate list
	 */
	@RequestLine("GET /ca_certificates?offset={offset}")
	ApiDataList<CACertificateResponse> findByOffset(@Param("offset") String offset);
	
	/**
	 * List CA Certificates by tag
	 * @param tagQueryBuilder tag info
	 * @return ca certificate list
	 */
	@RequestLine("GET /ca_certificates?tags={tags}")
	ApiDataList<CACertificateResponse> findByTag(@Param("tags") TagQueryBuilder tagQueryBuilder);
	
	/**
	 * Retrieve CA Certificate
	 * @param caCertificateId The unique identifier of the CA Certificate to delete.
	 * @return ca certificate info
	 */
	@RequestLine("GET /ca_certificates/{ca_certificate_id}")
	CACertificateResponse retrieve(@Param("ca_certificate_id") String caCertificateId);
	
	/**
	 * Update CA Certificate
	 * @param caCertificateId The unique identifier of the CA Certificate to delete.
	 * @param caCertificateRequest ca certificate info
	 * @return updated ca certificate info
	 */
	@RequestLine("PATCH /ca_certificates/{ca_certificate_id}")
	@Headers("Content-Type: application/json")
	CACertificateResponse update(@Param("ca_certificate_id") String caCertificateId,CACertificateRequest caCertificateRequest);
	
	/**
	 * Create Or Update CA Certificate
	 * @param caCertificateId The unique identifier of the CA Certificate to delete.
	 * @param caCertificateRequest ca certificate info
	 * @return updated or created ca certificate info
	 */
	@RequestLine("PUT /ca_certificates/{ca_certificate_id}")
	@Headers("Content-Type: application/json")
	CACertificateResponse updateOrCreate(@Param("ca_certificate_id") String caCertificateId,CACertificateRequest caCertificateRequest);	
	
	/**
	 * Delete CA Certificate
	 * @param caCertificateId The unique identifier of the CA Certificate to delete.
	 */
	@RequestLine("DELETE /ca_certificates/{ca_certificate_id}")
	void delete(@Param("ca_certificate_id") String caCertificateId);	

}
