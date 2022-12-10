package io.github.ungle.kong.client.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.ungle.kong.client.api.ConsumerApi;
import io.github.ungle.kong.client.api.plugins.AclApi;
import io.github.ungle.kong.client.feignclient.KongClientFactory;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.ConsumerRequest;
import io.github.ungle.kong.client.requests.plugins.AclRequest;
import io.github.ungle.kong.client.response.ConsumerResponse;
import io.github.ungle.kong.client.response.plugins.AclResponse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = OrderAnnotation.class)
public class AclPluginTest {
    ObjectMapper objectMapper;
    AclApi aclApi;
    ConsumerApi consumerApi;
    String name;
    String customId;
    String consumerId;

    @BeforeAll
    public void initTest() {
        objectMapper = new ObjectMapper();
        KongClientFactory kongClientFactory = KongClientFactory.builder()
                .targets(Arrays.asList("http://127.0.0.1:8001")).build();
        consumerApi = kongClientFactory.getApiInstance(ConsumerApi.class);
        name = "consumer-acl";
        customId = name+"-id";
        aclApi = kongClientFactory.getApiInstance(AclApi.class);
        
        ConsumerRequest request = new ConsumerRequest();
        request.setCustomId(customId);
        request.setUsername(name);
        ConsumerResponse response = consumerApi.add(request);
        consumerId = response.getId();
        
    }

    

    @Test
    @Order(1)
    public void addAndUpdate() throws JsonProcessingException {
        AclRequest aclRequest = new AclRequest("test-group-1");
        AclResponse response = aclApi.add(name, aclRequest);
        assertEquals(consumerId, response.getConsumer().getId());
        
        aclRequest = new AclRequest("test-group-1");
        aclRequest.setTags(Collections.singleton("test-acl"));
        response = aclApi.add(consumerId, response.getId(), aclRequest);
        assertTrue(response.getTags().contains("test-acl"));
        
    }
    
    @Test
    @Order(2)
    public void find() throws Exception {
    	ApiDataList<AclResponse> response = aclApi.find();
    	assertEquals(1, response.getData().size());
    	
    	response = aclApi.findByConsumer(name);
    	assertEquals("test-group-1",response.getData().get(0).getGroup());
        
    	
    }
    
    @Test
    @Order(3)
    public void delete() {
    	aclApi.deleteByGroup(name, "test-group-1");
    }
    
    @AfterAll
    public void destroyTest() {
    	consumerApi.delete(consumerId);
    }
    


}
