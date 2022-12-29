package io.github.ungle.kong.client.test.pluginmodel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.ungle.kong.client.api.PluginApi;
import io.github.ungle.kong.client.api.ServiceApi;
import io.github.ungle.kong.client.enums.InnerPluginName;
import io.github.ungle.kong.client.feignclient.KongClientFactory;
import io.github.ungle.kong.client.model.IdNameRelation;
import io.github.ungle.kong.client.model.plugins.authentication.KeyAuthenticationConfig;
import io.github.ungle.kong.client.requests.PluginRequest;
import io.github.ungle.kong.client.requests.ServiceRequest;
import io.github.ungle.kong.client.response.PluginResponse;
import io.github.ungle.kong.client.response.ServiceResponse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = OrderAnnotation.class)
public class KeyAuthPluginModelTest {
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
	public void createPlugin() throws Exception {
		PluginRequest request = new PluginRequest();
		String pluginName = InnerPluginName.KEY_AUTH.getPluginName();
		request.setName(pluginName);
		request.setService(new IdNameRelation(serviceId));
		request.setConfig(KeyAuthenticationConfig.builder().withHideCredentials(true).withKeyNames(new HashSet<>(Arrays.asList("workkey")))
				.build());
		PluginResponse result = pluginApi.add(request);
		pluginId = result.getId();
		JsonNode tree = objectMapper.readTree(objectMapper.writeValueAsBytes(result.getConfig()));
		assertEquals(pluginName, result.getName());
		assertTrue(tree.get("hide_credentials").asBoolean());
		assertEquals("workkey", tree.get("key_names").get(0).asText());
		
	}

	@AfterAll
	public void deleteService() {
		if (pluginId != null) {
			pluginApi.delete(pluginId);
		}
		serviceApi.delete(serviceId);
	}
}
