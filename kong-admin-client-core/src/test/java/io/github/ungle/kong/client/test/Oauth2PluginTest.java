package io.github.ungle.kong.client.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.github.ungle.kong.client.api.ConsumerApi;
import io.github.ungle.kong.client.api.plugins.Oauth2Api;
import io.github.ungle.kong.client.feignclient.KongClientFactory;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.model.IdNameRelation;
import io.github.ungle.kong.client.requests.ConsumerRequest;
import io.github.ungle.kong.client.requests.plugins.OAuth2CredentialsRequest;
import io.github.ungle.kong.client.requests.plugins.OAuth2TokenRequest;
import io.github.ungle.kong.client.response.ConsumerResponse;
import io.github.ungle.kong.client.response.plugins.OAuth2CredentialsResponse;
import io.github.ungle.kong.client.response.plugins.OAuth2TokenResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = OrderAnnotation.class)
public class Oauth2PluginTest {
    Oauth2Api oauth2Api;
    ConsumerApi consumerApi;
    String name;
    String customId;
    String consumerId;
    String credentialId;
    String tokenId;


    @BeforeAll
    public void initTest() {
        KongClientFactory kongClientFactory = KongClientFactory.builder()
                .targets(Arrays.asList("http://127.0.0.1:8001")).build();
        oauth2Api = kongClientFactory.getApiInstance(Oauth2Api.class);
        consumerApi = kongClientFactory.getApiInstance(ConsumerApi.class);
        name = "consumer-oauth2";
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
        OAuth2CredentialsRequest credentialsRequest =new OAuth2CredentialsRequest();
        credentialsRequest.setClientId("test123");
        credentialsRequest.setName("test-credential");
        OAuth2CredentialsResponse credentialsResponse = oauth2Api.addCredential(consumerId, credentialsRequest);
        assertEquals("test-credential",credentialsResponse.getName());
        credentialId = credentialsResponse.getId();
    }
    
    @Test
    @Order(2)
    public void testAddToken() {
    	OAuth2TokenRequest tokenRequest = new OAuth2TokenRequest();
    	tokenRequest.setCredential(new IdNameRelation(credentialId));
    	OAuth2TokenResponse response = oauth2Api.addToken(tokenRequest);
    	assertEquals(credentialId, response.getCredential().getId());
    	tokenId = response.getId();
    }

    @Test
    @Order(3)
    public void testFindByConsumer() throws Exception {
        ApiDataList<OAuth2CredentialsResponse> credentialsResponse  = oauth2Api.findByConsumer(name);
        assertEquals("test-credential",credentialsResponse.getData().get(0).getName());
    }
    
    
    
    @Test
    @Order(4)
    public void delete() {
    	oauth2Api.deleteToken(tokenId);
    	oauth2Api.delete(credentialId);
    }
    
    @AfterAll
    public void destroyTest() {
    	consumerApi.delete(consumerId);
    }
    
    


}
