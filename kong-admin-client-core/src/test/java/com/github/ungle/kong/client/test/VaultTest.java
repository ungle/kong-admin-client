package com.github.ungle.kong.client.test;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.github.ungle.kong.client.api.VaultApi;
import com.github.ungle.kong.client.feignclient.KongClientFactory;
import com.github.ungle.kong.client.requests.VaultRequest;
import com.github.ungle.kong.client.response.VaultResponse;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = OrderAnnotation.class)
public class VaultTest {
	String vaultPrefix;
	String vaultId;
	VaultApi api;
	
	@BeforeAll
    public void initTest() {
        KongClientFactory kongClientFactory = KongClientFactory.builder()
                .targets(Arrays.asList("http://127.0.0.1:8001")).build();
        api = kongClientFactory.getApiInstance(VaultApi.class);
        vaultPrefix = "my-vault";
        
    }
	
	@Test
	@Order(1)
	public void addTest() {
		VaultRequest request = new VaultRequest(vaultPrefix, "env");
		VaultResponse response = api.updateOrCreate(UUID.randomUUID().toString(), request);
		assertEquals(vaultPrefix, response.getPrefix());
		vaultId =response.getId();
	}
	
	@Test
	@Order(2)
	public void updateTest() {
		VaultRequest request = new VaultRequest(vaultPrefix, "env");
		request.setTags(Collections.singleton("test-vault"));
		request.setDescription("just for fun today");
		VaultResponse response = api.update(vaultId, request);
		assertTrue(response.getTags().contains("test-vault"));
	}
	
	@Test
	@Order(3)
	public void findTest() {
		VaultResponse response = api.find().getData().get(0);
		assertEquals("just for fun today", response.getDescription());
	}
	
	@Test
	@Order(4)
	public void deleteTest() {
		api.delete(vaultPrefix);
	}

}
