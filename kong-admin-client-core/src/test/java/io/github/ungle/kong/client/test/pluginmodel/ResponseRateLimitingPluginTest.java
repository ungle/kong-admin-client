package io.github.ungle.kong.client.test.pluginmodel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.ungle.kong.client.api.PluginApi;
import io.github.ungle.kong.client.api.ServiceApi;
import io.github.ungle.kong.client.enums.InnerPluginName;
import io.github.ungle.kong.client.feignclient.KongClientFactory;
import io.github.ungle.kong.client.model.plugins.traffic.RateLimitData;
import io.github.ungle.kong.client.model.plugins.traffic.ResponseRateLimitingConfig;
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
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = OrderAnnotation.class)
public class ResponseRateLimitingPluginTest {
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
		request.setName(InnerPluginName.RESPONSE_RATELIMITING.getPluginName());
		request.setConfig(ResponseRateLimitingConfig.builder().addLimit("sms", RateLimitData.builder().withDay(11L).build()).build());
		PluginResponse result = pluginApi.add(request);
		pluginId = result.getId();
		JsonNode tree = objectMapper.readTree(objectMapper.writeValueAsBytes(result.getConfig()));
		assertEquals(result.getName(), InnerPluginName.RESPONSE_RATELIMITING.getPluginName());
		assertEquals(11L, tree.get("limits").get("sms").get("day").asLong());
	}
	
	@Test
	@Order(2)
	public void createPluginWithException() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
			RateLimitData.builder().withMinute(33L).withDay(1L).build();
		},"the limit for day(1) cannot be lower than the limit for minute(33)"); 
		assertThrows(IllegalArgumentException.class, () -> {
			RateLimitData.builder().build();
		},"the rate limit params second,minute,hour,day,month,year must have at least one non-null");
		assertThrows(IllegalArgumentException.class, () -> {
			RateLimitData.builder().withDay(-1L).build();
		},"the rate limit must greater than 0");
		
		
	}
	

	@AfterAll
	public void deleteService() {
		if (pluginId != null) {
			pluginApi.delete(pluginId);
		}
		serviceApi.delete(serviceId);
	}
}
