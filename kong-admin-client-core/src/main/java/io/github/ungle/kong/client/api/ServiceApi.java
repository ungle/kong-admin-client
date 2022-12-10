package io.github.ungle.kong.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.ServiceRequest;
import io.github.ungle.kong.client.response.ServiceResponse;
import io.github.ungle.kong.client.service.TagQueryBuilder;

/**
 * 
 * @author ungle
 *
 */
public interface ServiceApi {
    /**
     * get services
     *
     * @return service list
     */
    @RequestLine("GET /services")
    ApiDataList<ServiceResponse> find();

    /**
     * get services from tags
     *
     * @param tagQueryBuilder tagQueryBuilder
     * @return service list
     */
    @RequestLine("GET /services?tags={tags}")
    ApiDataList<ServiceResponse> findByTag(@Param("tags") TagQueryBuilder tagQueryBuilder);

    /**
     * find services via offset
     *
     * @param offset 
     * @return service list
     */
    @RequestLine("GET /services?offset={offset}")
    ApiDataList<ServiceResponse> findByOffset(@Param("offset") String offset);

    /**
     * find service via cert id
     *
     * @param certId  cert id
     * @return service list
     */
    @RequestLine("GET /certificates/{cert_id}/services")
    ApiDataList<ServiceResponse> findByCertificate(@Param("cert_id") String certId);

    /**
     * find service via service id or service name
     *
     * @param service service id or service name
     * @return service info
     */
    @RequestLine("GET /services/{service}")
    ServiceResponse retrieve(@Param("service") String service);

    /**
     * find service via route id or route name
     *
     * @param route route id or route name
     * @return service info
     */
    @RequestLine("GET /routes/{route}/service")
    ServiceResponse retrieveByRoute(@Param("route") String route);

    /**
     * find service via plugin id
     *
     * @param plugin plugin id
     * @return service info
     */
    @RequestLine("GET /plugins/{plugin}/service")
    ServiceResponse retrieveByPlugin(@Param("plugin") String plugin);

    /**
     * update service
     *
     * @param service        service id or service name
     * @param serviceRequest service info
     * @return updated service info
     */
    @RequestLine("PATCH /services/{service}")
    @Headers("Content-Type: application/json")
    ServiceResponse update(@Param("service") String service, ServiceRequest serviceRequest);

    /**
     * update service via route
     *
     * @param route          route id or route name
     * @param serviceRequest service info
     * @return updated service info
     */
    @RequestLine("PATCH /routes/{route}/service")
    @Headers("Content-Type: application/json")
    ServiceResponse updateByRoute(@Param("route") String route, ServiceRequest serviceRequest);

    /**
     * update service via plugin id
     *
     * @param plugin         plugin id 
     * @param serviceRequest service info
     * @return updated service info
     */
    @RequestLine("PATCH /plugins/{plugin}/service")
    @Headers("Content-Type: application/json")
    ServiceResponse updateByPlugin(@Param("plugin") String plugin, ServiceRequest serviceRequest);

    /**
     * Create Or Update Service
     *
     * @param service        The unique identifier or the name of the Service to create or update.
     * @param serviceRequest service info
     * @return updated or created service info
     */
    @RequestLine("PUT /services/{service}")
    @Headers("Content-Type: application/json")
    ServiceResponse updateOrCreate(@Param("service") String service, ServiceRequest serviceRequest);
    
    /**
     * Create Or Update Service Associated to a Specific Certificate
     * 
     * @param certId The unique identifier of the Certificate to create or update.
     * @param service The unique identifier or the name of the Service to create or update.
     * @param serviceRequest service info
     * @return updated or created service info
     */
    @RequestLine("POST /certificates/{cert_id}/services/{service}")
    @Headers("Content-Type: application/json")
    ServiceResponse updateOrCreateByCertificate(@Param("cert_id") String certId,@Param("service") String service,ServiceRequest serviceRequest);
    

    /**
     * Create Or Update Service Associated to a Specific Route
     *
     * @param route The unique identifier or the name of the Route associated to the Service to be created or updated.
     * @param serviceRequest service info
     * @return updated or created service info
     */
    @RequestLine("PUT /routes/{route}/service")
    @Headers("Content-Type: application/json")
    ServiceResponse updateOrCreateByRoute(@Param("route") String route, ServiceRequest serviceRequest);

    /**
     * Create Or Update Service Associated to a Specific Plugin
     *
     * @param plugin The unique identifier of the Plugin associated to the Service to be created or updated.
     * @param serviceRequest service info
     * @return updated or created service info
     */
    @RequestLine("PUT /plugins/{plugin}/service")
    @Headers("Content-Type: application/json")
    ServiceResponse updateOrCreateByPlugin(@Param("plugin") String plugin, ServiceRequest serviceRequest);

    /**
     * add service
     *
     * @param request service info
     * @return added service info
     */
    @RequestLine("POST /services")
    @Headers("Content-Type: application/json")
    ServiceResponse add(ServiceRequest serviceRequest);

    /**
     * add service by certification
     *
     * @param certId         certification id
     * @param serviceRequest service info
     * @return added service info
     */
    @RequestLine("POST /certificates/{cert_id}/services")
    @Headers("Content-Type: application/json")
    ServiceResponse addByCertificate(@Param("cert_id") String certId, ServiceRequest serviceRequest);

    /**
     * delete service
     *
     * @param service The unique identifier or the name of the Service to create or update.
     */
    @RequestLine("DELETE /services/{service}")
    void delete(@Param("service") String service);

    /**
     * delete service by certification
     *
     * @param certId certification id
     */
    @RequestLine("DELETE /certificates/{cert_id}/services")
    void deleteByCertificate(@Param("cert_id") String certId);


}
