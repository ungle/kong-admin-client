package io.github.ungle.kong.client.test;


import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Logger.Level;
import io.github.ungle.kong.client.api.TargetApi;
import io.github.ungle.kong.client.api.UpstreamApi;
import io.github.ungle.kong.client.enums.BalancingAlgorithm;
import io.github.ungle.kong.client.feignclient.KongClientFactory;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.model.HealthCheck;
import io.github.ungle.kong.client.requests.TargetRequest;
import io.github.ungle.kong.client.requests.UpstreamRequest;
import io.github.ungle.kong.client.response.TargetResponse;
import io.github.ungle.kong.client.response.UpstreamResponse;
import io.github.ungle.kong.client.service.TagQueryBuilder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = OrderAnnotation.class)
public class UpstreamTargetTest {
    ObjectMapper objectMapper;
    UpstreamApi upstreamApi;
    TargetApi targetApi;
    String upstreamId;
    String upstreamName;
    String targetId;

    @BeforeAll
    public void initTest() {
        objectMapper = new ObjectMapper();
        KongClientFactory kongClientFactory = KongClientFactory.builder()
                .targets(Arrays.asList("http://127.0.0.1:8001")).logLevel(Level.FULL).build();
        upstreamApi = kongClientFactory.getApiInstance(UpstreamApi.class);
        targetApi = kongClientFactory.getApiInstance(TargetApi.class);
        upstreamName = "upstream-"+ UUID.randomUUID().toString();
    }

    @Test
    @Order(1)
    public void addAndUpdate() throws Exception {
    	UpstreamRequest upstreamRequest = new UpstreamRequest();
        upstreamRequest.setAlgorithm(BalancingAlgorithm.ROUND_ROBIN);
        upstreamRequest.setName(upstreamName);
        HealthCheck healthCheck = new HealthCheck();
        healthCheck.setThreshold(1);
        upstreamRequest.setHealthchecks(healthCheck);
        UpstreamResponse response = upstreamApi.add(upstreamRequest);
        assertEquals(1, response.getHealthchecks().getThreshold());
        healthCheck.setThreshold(0);
        upstreamRequest.setTags(Collections.singleton("upstream-test"));
        upstreamId = response.getId();
        upstreamName = response.getName();
        response = upstreamApi.update(upstreamName, upstreamRequest);
        assertEquals(0, response.getHealthchecks().getThreshold());
    }
    
    @Test
    @Order(2)
    public void findTest() {
    	ApiDataList<UpstreamResponse> response = upstreamApi.findByTag(new TagQueryBuilder().addTag("upstream-test"));
    	assertEquals(upstreamId, response.getData().get(0).getId());
    }
    
    @Test
    @Order(3)
    public void addTargetTest() throws Exception{
    	TargetRequest request = new TargetRequest();
    	request.setTarget("127.0.0.1:8001");
    	TargetResponse response = targetApi.addByUpstream(upstreamId, request);
    	assertEquals("127.0.0.1:8001", response.getTarget());
    	targetId = response.getId();
    	response = targetApi.find(upstreamId).getData().get(0);
    	assertEquals("127.0.0.1:8001", response.getTarget());

    	
    }
    
    @Test
    @Order(4)
    public void deleteTest() {
    	targetApi.deleteById(upstreamId, targetId);
    	upstreamApi.delete(upstreamId);
    }
    




}
