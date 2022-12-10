package org.kastin.kong.client.api;

import org.kastin.kong.client.model.ApiDataList;
import org.kastin.kong.client.response.NodeInformationResponse;
import org.kastin.kong.client.response.NodeStatusResponse;

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
