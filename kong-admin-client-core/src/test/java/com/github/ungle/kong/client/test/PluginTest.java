package com.github.ungle.kong.client.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ungle.kong.client.api.PluginApi;
import com.github.ungle.kong.client.api.ServiceApi;
import com.github.ungle.kong.client.feignclient.KongClientFactory;
import com.github.ungle.kong.client.model.ApiDataList;
import com.github.ungle.kong.client.model.IdNameRelation;
import com.github.ungle.kong.client.model.plugins.traffic.RateLimitingConfig;
import com.github.ungle.kong.client.requests.PluginRequest;
import com.github.ungle.kong.client.requests.ServiceRequest;
import com.github.ungle.kong.client.response.PluginResponse;
import com.github.ungle.kong.client.response.ServiceResponse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = OrderAnnotation.class)
public class PluginTest {
    ObjectMapper objectMapper;
    PluginApi pluginApi;
    String serviceName;
	String serviceId;
	ServiceApi serviceApi;
	String pluginId;

    @BeforeAll
    public void initTest() {
        objectMapper = new ObjectMapper();
        KongClientFactory kongClientFactory = KongClientFactory.builder()
                .targets(Arrays.asList("http://127.0.0.1:8001")).build();
        pluginApi = kongClientFactory.getApiInstance(PluginApi.class);
        serviceApi = kongClientFactory.getApiInstance(ServiceApi.class);
        
        serviceName = "test-plugin-service";
		ServiceRequest serviceRequest = new ServiceRequest();
		serviceRequest.setName(serviceName);
		serviceRequest.setUrl("http://127.0.0.1:8801");
		ServiceResponse response = serviceApi.add(serviceRequest);
		serviceId = response.getId();
    }

    @Test
    @Order(1)
    public void createPlugin() throws Exception {
    	PluginRequest request = new PluginRequest();
    	request.setName("rate-limiting");
    	request.setService(new IdNameRelation(serviceId));
    	request.setConfig(RateLimitingConfig.builder().withSecond(11L).build());
    	request.setTags(Collections.singleton("test-plugin"));
    	PluginResponse result = pluginApi.add(request);
    	assertEquals(result.getName(), "rate-limiting");
    	pluginId = result.getId();
    	
       
    }

    @Test
    @Order(2)
    public void listPlugin() throws Exception {
        ApiDataList<PluginResponse> result = pluginApi.findByService(serviceName);
        assertEquals(pluginId, result.getData().get(0).getId());
    }
    
    @Test
    @Order(3)
    public void findPluginByService() throws Exception {
        PluginResponse result = pluginApi.retrieveByService(serviceId, pluginId);
        assertEquals("rate-limiting", result.getName());
    }

    @Test
    @Order(4)
    public void deletePlugin() throws Exception {
    	pluginApi.delete(pluginId);
    }
    
    @AfterAll
    public void deleteService() {
    	serviceApi.delete(serviceId);
    }
}
