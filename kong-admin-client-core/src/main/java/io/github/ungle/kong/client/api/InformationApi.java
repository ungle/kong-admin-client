package io.github.ungle.kong.client.api;

import feign.Param;
import feign.RequestLine;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.response.NodeInformationResponse;
import io.github.ungle.kong.client.response.NodeStatusResponse;

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
