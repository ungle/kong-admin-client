package org.kastin.kong.client.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.kastin.kong.client.api.ServiceApi;
import org.kastin.kong.client.api.TagApi;
import org.kastin.kong.client.feignclient.KongClientFactory;
import org.kastin.kong.client.model.ApiDataList;
import org.kastin.kong.client.requests.ServiceRequest;
import org.kastin.kong.client.response.ServiceResponse;
import org.kastin.kong.client.response.TagResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TagApiTest {
	
	TagApi tagApi;
	String serviceName;
	ServiceApi serviceApi;
	String serviceId;
	
	@BeforeAll
    public void initTest() {
        KongClientFactory kongClientFactory = KongClientFactory.builder()
                .targets(Arrays.asList("http://127.0.0.1:8001")).build();
        tagApi = kongClientFactory.getApiInstance(TagApi.class);
        serviceApi = kongClientFactory.getApiInstance(ServiceApi.class);
        
        String serviceName = "test-service";
		ServiceRequest serviceRequest = new ServiceRequest();
		serviceRequest.setName(serviceName);
		serviceRequest.setUrl("http://127.0.0.1:8801");
		serviceRequest.setTags(Collections.singleton("tag-test"));
		ServiceResponse response = serviceApi.add(serviceRequest);
		serviceId = response.getId();
    }

    @Test
    public void findAllTest() throws Exception {
        ApiDataList<TagResponse> result = tagApi.find();
        TagResponse response = result.getData().get(0);
        assertEquals(serviceId, response.getEntityId()); 
        assertEquals("services", response.getEntityName());
        assertEquals("tag-test", response.getTag());
    }
    
    @AfterAll
    public void afterTest() {
    	serviceApi.delete(serviceId);
    }

}
