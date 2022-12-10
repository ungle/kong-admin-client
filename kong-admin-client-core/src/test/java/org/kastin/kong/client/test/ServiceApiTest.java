package org.kastin.kong.client.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.kastin.kong.client.api.ServiceApi;
import org.kastin.kong.client.feignclient.KongClientFactory;
import org.kastin.kong.client.model.ApiDataList;
import org.kastin.kong.client.model.KongException;
import org.kastin.kong.client.requests.ServiceRequest;
import org.kastin.kong.client.response.ServiceResponse;
import org.kastin.kong.client.service.TagQueryBuilder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = OrderAnnotation.class)
public class ServiceApiTest {

    ObjectMapper objectMapper;
    ServiceApi serviceApi;
    String name;

    @BeforeAll
    public void initTest() {
        objectMapper = new ObjectMapper();
        KongClientFactory kongClientFactory = KongClientFactory.builder()
                .targets(Arrays.asList("http://127.0.0.1:8001")).build();
        serviceApi = kongClientFactory.getApiInstance(ServiceApi.class);
        name = "test-20210301-" + UUID.randomUUID().toString();
    }
    
    @Test
    @Order(1)
    public void addTest() throws JsonProcessingException {
    	  ServiceRequest serviceRequest = new ServiceRequest();
          serviceRequest.setName(name);
          serviceRequest.setUrl("http://127.0.0.1:8801");
          Set<String> tags = new HashSet<>();
          tags.add("TEST");
          serviceRequest.setTags(tags);
          ServiceResponse response = serviceApi.add(serviceRequest);
          tags.add("TEST2");
          response = serviceApi.update(name, serviceRequest);
          assertEquals(name, response.getName());
          
    }

    @Test
    @Order(2)
    public void findTest() throws JsonProcessingException  {
        try {
            ApiDataList<ServiceResponse> result = serviceApi.findByTag(new TagQueryBuilder().andTag("TEST2"));
            assertEquals(1, result.getData().size());
        } catch (KongException e) {
            e.printStackTrace();
            System.out.println(e.getKongCode());
        }
    }

    @Test
    @Order(3)
    public void deleteServiceTest() throws Exception {
    	serviceApi.delete(name);
    }
}
