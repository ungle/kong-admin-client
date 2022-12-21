package io.github.ungle.kong.client.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.github.ungle.kong.client.api.ConsumerApi;
import io.github.ungle.kong.client.api.plugins.KeyAuthCredentialsApi;
import io.github.ungle.kong.client.feignclient.KongClientFactory;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.ConsumerRequest;
import io.github.ungle.kong.client.requests.plugins.KeyAuthCredentialsRequest;
import io.github.ungle.kong.client.response.ConsumerResponse;
import io.github.ungle.kong.client.response.plugins.KeyAuthCredentialsResponse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = OrderAnnotation.class)
public class KeyAuthPluginTest {
	
	KeyAuthCredentialsApi credentialsApi;
	ConsumerApi consumerApi;
    String name;
    String customId;
    String consumerId;
    String credentialId;
	
	@BeforeAll
    public void initTest() {
        KongClientFactory kongClientFactory = KongClientFactory.builder()
                .targets(Arrays.asList("http://127.0.0.1:8001")).build();
        credentialsApi = kongClientFactory.getApiInstance(KeyAuthCredentialsApi.class);
        consumerApi = kongClientFactory.getApiInstance(ConsumerApi.class);
        name = "consumer-basic-auth";
        customId = name+"-id";
        
        ConsumerRequest request = new ConsumerRequest();
        request.setCustomId(customId);
        request.setUsername(name);
        ConsumerResponse response = consumerApi.add(request);
        consumerId = response.getId();
    }
	
	@Test
    @Order(1)
    public void testAddCredential() throws Exception {
        KeyAuthCredentialsRequest credentialsRequest =new KeyAuthCredentialsRequest();
        credentialsRequest.setKey("the-key");
        KeyAuthCredentialsResponse credentialsResponse = credentialsApi.add(consumerId, credentialsRequest);
        assertEquals("the-key",credentialsResponse.getKey());
        credentialId = credentialsResponse.getId();
    }
    
    @Test
    @Order(2)
    public void testFind() {
    	KeyAuthCredentialsResponse result = credentialsApi.find().getData().get(0);
    	assertEquals(credentialId, result.getId());
    }

    @Test
    @Order(3)
    public void testFindByConsumer() throws Exception {
        ApiDataList<KeyAuthCredentialsResponse> credentialsResponse  = credentialsApi.findByConsumer(name);
        assertEquals("the-key",credentialsResponse.getData().get(0).getKey());
    }
    
    @Test
    @Order(4)
    public void testFindConsumer() throws Exception {
        ConsumerResponse response = credentialsApi.retrieveConsumer(credentialId);
        assertEquals(name,response.getUsername());
    }
    
    @Test
    @Order(5)
    public void deleteTest() {
    	credentialsApi.delete(credentialId);
    	assertEquals(0,credentialsApi.findByConsumer(name).getData().size());
    }
    
    @AfterAll
    public void destroyTest() {
    	consumerApi.delete(consumerId);
    }
    
    

}
