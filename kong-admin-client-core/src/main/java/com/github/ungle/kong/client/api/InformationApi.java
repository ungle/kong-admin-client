package com.github.ungle.kong.client.api;

import com.github.ungle.kong.client.model.ApiDataList;
import com.github.ungle.kong.client.response.NodeInformationResponse;
import com.github.ungle.kong.client.response.NodeStatusResponse;

import feign.Param;
import feign.RequestLine;

/**
 * @author ungle
 */
public interface InformationApi {

    @RequestLine("GET /")
    NodeInformationResponse getNodeInfo();

    @RequestLine("GET /status")
    NodeStatusResponse getNodeStatus();
    
    @RequestLine("HEAD /{endpoint}")
    void endpointExists(@Param("endpoint") String endpoint);
    
    @RequestLine("GET /endpoints")
    ApiDataList<String> getAvailableEndpoints();
}
