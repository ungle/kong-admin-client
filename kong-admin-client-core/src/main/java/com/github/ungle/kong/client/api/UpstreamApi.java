package com.github.ungle.kong.client.api;

import com.github.ungle.kong.client.model.ApiDataList;
import com.github.ungle.kong.client.requests.UpstreamRequest;
import com.github.ungle.kong.client.response.HealthResponse;
import com.github.ungle.kong.client.response.UpstreamHealthResponse;
import com.github.ungle.kong.client.response.UpstreamResponse;
import com.github.ungle.kong.client.service.TagQueryBuilder;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * @author ungle
 */
public interface UpstreamApi {


	/**
	 * Create Upstream
	 * @param request upstream info
	 * @return added upstream info
	 */
    @RequestLine("POST /upstreams")
    @Headers("Content-Type: application/json")
    UpstreamResponse add(UpstreamRequest request);
    
    /**
     * Create Upstream Associated to a Specific Certificate
     * @param certificateId The unique identifier attribute of the Certificate that should be associated
     * @param request upstream info
     * @return added upstream info
     */
    @RequestLine("POST /certificates/{certificate_id}/upstreams")
    @Headers("Content-Type: application/json")
    UpstreamResponse addByCertificate (@Param("certificate_id") String certificateId,UpstreamRequest request);

    /**
     * List All Upstreams
     * @return upstream info list
     */
    @RequestLine("GET /upstreams")
    ApiDataList<UpstreamResponse> find();

    /**
     * List All Upstreams by offset
     * @param offset offset info
     * @return upstream info list
     */
    @RequestLine("GET /upstreams?offset={offset}")
    ApiDataList<UpstreamResponse> findByOffset(@Param("offset") String offset);

    /**
     * List All Upstreams by tags
     * @param tagQueryBuilder tag info
     * @return upstream info list
     */
    @RequestLine("GET /upstreams?tags={tags}")
    ApiDataList<UpstreamResponse> findByTag(@Param("tags") TagQueryBuilder tagQueryBuilder);
    
    /**
     * List Upstreams Associated to a Specific Certificate
     * @param certificateId The unique identifier attribute of the Certificate that should be associated
     * @param request upstream info
     * @return upstream info list
     */
    @RequestLine("GET /certificates/{certificate_id}/upstreams")
    ApiDataList<UpstreamResponse> findByCertificate (@Param("certificate_id") String certificateId,UpstreamRequest request);

    /**
     * Retrieve Upstream
     * @param upstream The unique identifier or the name of the Upstream
     * @return upstream info
     */
    @RequestLine("GET /upstreams/{upstream}")
    UpstreamResponse retrieve(@Param("upstream") String upstream);
    
    /**
     * Retrieve Upstream Associated to a Specific Certificate
     * @param certificateId The unique identifier attribute of the Certificate that should be associated
     * @param upstream The unique identifier or the name of the Upstream
     * @param request upstream info
     * @return upstream info
     */
    @RequestLine("GET /certificates/{certificate_id}/upstreams/{upstream}")
    UpstreamResponse retrieveByCertificate (@Param("certificate_id") String certificateId,@Param("upstream") String upstream,UpstreamRequest request);


    /**
     * Update Upstream
     * @param upstream The unique identifier or the name of the Upstream
     * @param request upstream info
     * @return updated upstream info
     */
    @RequestLine("PATCH /upstreams/{upstream}")
    @Headers("Content-Type: application/json")
    UpstreamResponse update(@Param("upstream") String upstream, UpstreamRequest request);


    /**
     * Update Upstream Associated to a Specific Certificate
     * @param certificateId The unique identifier attribute of the Certificate that should be associated
     * @param upstream The unique identifier or the name of the Upstream
     * @param request upstream info
     * @return updated upstream info
     */
    @RequestLine("PATCH /certificates/{certificate_id}/upstreams/{upstream}")
    @Headers("Content-Type: application/json")
    UpstreamResponse updateByCertificate(@Param("certificate_id") String certificateId,@Param("upstream") String upstream,UpstreamRequest request);

    /**
     * Create Or Update Upstream
     * @param upstream The unique identifier or the name of the Upstream
     * @param request upstream info
     * @return created or updated upstream info
     */
    @RequestLine("PUT /upstreams/{upstream}")
    @Headers("Content-Type: application/json")
    UpstreamResponse createOrUpdate(@Param("upstream") String upstream, UpstreamRequest request);

    /**
     * Create Or Update Upstream Associated to a Specific Certificate
     * @param certificateId The unique identifier attribute of the Certificate that should be associated
     * @param upstream The unique identifier or the name of the Upstream
     * @param request upstream info
     * @return created or updated upstream info
     */
    @RequestLine("PUT /certificates/{certificate_id}/upstreams/{upstream}")
    @Headers("Content-Type: application/json")
    UpstreamResponse createOrUpdateByCertificate(@Param("certificate_id") String certificateId,@Param("upstream") String upstream,UpstreamRequest request);

    /**
     * Delete Upstream
     * @param upstream The unique identifier or the name of the Upstream
     */
    @RequestLine("DELETE /upstreams/{upstream}")
    void delete(@Param("upstream") String upstream);


    /**
     * Delete Upstream Associated to a Specific Certificate
     * @param certificateId The unique identifier attribute of the Certificate that should be associated
     * @param upstream The unique identifier or the name of the Upstream
     */
    @RequestLine("DELETE /certificates/{certificate_id}/upstreams/{upstream}")
    void deleteByCertificate(@Param("certificate_id") String certificateId,@Param("upstream") String upstream);

    /**
     * Show Upstream Health for Node
     * @param upstream The unique identifier or the name of the Upstream
     * @return Upstream Health for Node
     */
    @RequestLine("GET /upstreams/{upstream}/health")
    ApiDataList<HealthResponse> getTargetHealth(@Param("upstream") String upstream);
    
    /**
     * Show Upstream Health for Upstream itself
     * @param upstream The unique identifier or the name of the Upstream
     * @return Health for Upstream itself
     */
    @RequestLine("GET /upstreams/{upstream}/health?balancer_health=1")
    UpstreamHealthResponse getUpstreamHealth(@Param("upstream") String upstream);

}
