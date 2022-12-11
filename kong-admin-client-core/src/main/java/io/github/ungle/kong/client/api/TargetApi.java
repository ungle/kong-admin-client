package io.github.ungle.kong.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.TargetRequest;
import io.github.ungle.kong.client.response.TargetResponse;
import io.github.ungle.kong.client.service.TagQueryBuilder;

/**
 * @author ungle
 */
public interface TargetApi {

	/**
	 * add target
	 * @param upstream The unique identifier or the name of the upstream.
	 * @param targetRequest target info
	 * @return added target info
	 */
    @RequestLine("POST /upstreams/{upstream}/targets")
    @Headers("Content-Type: application/json")
    TargetResponse addByUpstream(@Param("upstream") String upstream, TargetRequest targetRequest);
    
    /**
     * update target by target id
     * @param upstream The unique identifier or the name of the upstream.
     * @param targetId The id of an existing target entry.
     * @param targetRequest target info
     * @return updated target info
     */
    @RequestLine("PATCH /upstreams/{upstream}/targets/{target_id}")
    @Headers("Content-Type: application/json")
    TargetResponse updateById(@Param("upstream") String upstream, @Param("target_id") String targetId, TargetRequest targetRequest);


    /**
     * update target by target address
     * @param upstream The unique identifier or the name of the upstream.
     * @param targetHost The host of target
     * @param targetPort The port of target
     * @param targetRequest target info
     * @return updated target info
     */
    @RequestLine("PATCH /upstreams/{upstream}/targets/{target_host}:{target_port}")
    @Headers("Content-Type: application/json")
    TargetResponse updateByAddress(@Param("upstream") String upstream, @Param("target_host") String targetHost, @Param("target_port") int targetPort, TargetRequest targetRequest);
    
    /**
     * update or create target by target id
     * @param upstream The unique identifier or the name of the upstream.
     * @param targetId The id of an existing target entry.
     * @param targetRequest target info
     * @return updated or created target info
     */
    @RequestLine("PUT /upstreams/{upstream}/targets/{target_id}")
    @Headers("Content-Type: application/json")
    TargetResponse updateOrCreateById(@Param("upstream") String upstream, @Param("target_id") String targetId, TargetRequest targetRequest);


    /**
     * update or create target by target address
     * @param upstream The unique identifier or the name of the upstream.
     * @param targetHost The host of target
     * @param targetPort The port of target
     * @param targetRequest target info
     * @return updated or created target info
     */
    @RequestLine("PUT /upstreams/{upstream}/targets/{target_host}:{target_port}")
    @Headers("Content-Type: application/json")
    TargetResponse updateOrCreateByAddress(@Param("upstream") String upstream, @Param("target_host") String targetHost, @Param("target_port") int targetPort, TargetRequest targetRequest);
    
    

    /**
     * List All Targets
     * @param upstream The unique identifier or the name of the upstream.
     * @return target list
     */
    @RequestLine("GET /upstreams/{upstream}/targets/all")
    ApiDataList<TargetResponse> find(@Param("upstream") String upstream);
    
    /**
     * List All Targets by tags
     * @param upstream The unique identifier or the name of the upstream.
     * @param tagQueryBuilder tags
     * @return target list
     */
    @RequestLine("GET /upstreams/{upstream}/targets/all?tags={tags}")
    ApiDataList<TargetResponse> find(@Param("upstream") String upstream,@Param("tags") TagQueryBuilder tagQueryBuilder);    


    /**
     * Delete Target by ID
     * @param upstream The unique identifier or the name of the upstream.
     * @param targetId The id of an existing target entry.
     */
    @RequestLine("DELETE /upstreams/{upstream}/targets/{target_id}")
    void deleteById(@Param("upstream") String upstream, @Param("target_id") String targetId);


    /**
     * Delete Target by address
     * @param upstream The unique identifier or the name of the upstream.
     * @param targetHost The host of target
     * @param targetPort The port of target
     */
    @RequestLine("DELETE /upstreams/{upstream}/targets/{target_host}:{target_port}")
    void deleteByAddress(@Param("upstream") String upstream, @Param("target_host") String targetHost, @Param("target_port") int targetPort);

    
    /**
     * Set Target Address As Healthy
     * @param upstream The unique identifier or the name of the upstream.
     * @param target The host/port combination element of the target to set as healthy, or the id of an existing target entry.
     * @param address The host/port combination element of the address to set as healthy.
     */
    @RequestLine("PUT /upstreams/{upstream}/targets/{target}/{address}/healthy")
    void setAddressHealthy(@Param("upstream") String upstream, @Param("target") String target, @Param("address") String address);


    /**
     * Set Target Address As Unhealthy
     * @param upstream The unique identifier or the name of the upstream.
     * @param target The host/port combination element of the target to set as healthy, or the id of an existing target entry.
     * @param address The host/port combination element of the address to set as healthy.
     */
    @RequestLine("PUT /upstreams/{upstream}/targets/{target}/{address}/unhealthy")
    void setAddressUnHealthy(@Param("upstream") String upstream, @Param("target") String target, @Param("address") String address);


    /**
     * Set Target As Healthy
     * @param upstream The unique identifier or the name of the upstream.
     * @param target The host/port combination element of the target to set as unhealthy, or the id of an existing target entry.
     */
    @RequestLine("PUT /upstreams/{upstream}/targets/{target}/healthy")
    void setHealthy(@Param("upstream") String upstream, @Param("target") String target);


    /**
     * Set Target As Unhealthy
     * @param upstream The unique identifier or the name of the upstream.
     * @param target The host/port combination element of the target to set as unhealthy, or the id of an existing target entry.
     */
    @RequestLine("PUT /upstreams/{upstream}/targets/{target}/unhealthy")
    void setUnHealthy(@Param("upstream") String upstream, @Param("target") String target);


}
