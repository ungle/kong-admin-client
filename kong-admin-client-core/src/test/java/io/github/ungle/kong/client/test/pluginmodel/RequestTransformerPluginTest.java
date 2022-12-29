package io.github.ungle.kong.client.test.pluginmodel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.ungle.kong.client.api.PluginApi;
import io.github.ungle.kong.client.api.ServiceApi;
import io.github.ungle.kong.client.enums.InnerPluginName;
import io.github.ungle.kong.client.feignclient.KongClientFactory;
import io.github.ungle.kong.client.model.IdNameRelation;
import io.github.ungle.kong.client.model.plugins.transformation.RequestTransformerConfig;
import io.github.ungle.kong.client.model.plugins.transformation.RequestTransformerConfig.ReplaceRequestOperation;
import io.github.ungle.kong.client.model.plugins.transformation.RequestTransformerConfig.RequestOperation;
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
import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = OrderAnnotation.class)
public class RequestTransformerPluginTest {
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
		request.setName(InnerPluginName.REQUEST_TRANSFORMER.getPluginName());
		request.setService(new IdNameRelation(serviceId));
		RequestOperation requestOperation = new RequestOperation();
		requestOperation.setHeaders(Arrays.asList("x-new-header:val"));
		ReplaceRequestOperation replaceRequestOperation = new ReplaceRequestOperation();
		replaceRequestOperation.setUri("/flowers");
		replaceRequestOperation.setBody(Arrays.asList("kk:kk"));
		request.setConfig(RequestTransformerConfig.builder().withAdd(requestOperation).withReplace(replaceRequestOperation).build());
		PluginResponse result = pluginApi.add(request);
		pluginId = result.getId();
		JsonNode tree = objectMapper.readTree(objectMapper.writeValueAsBytes(result.getConfig()));
		assertEquals(result.getName(), InnerPluginName.REQUEST_TRANSFORMER.getPluginName());
		assertEquals("x-new-header:val",tree.get("add").get("headers").get(0).asText());
		assertEquals("/flowers", tree.get("replace").get("uri").asText());
		assertEquals("kk:kk", tree.get("replace").get("body").get(0).asText());
	}

	@AfterAll
	public void deleteService() {
		if (pluginId != null) {
			pluginApi.delete(pluginId);
		}
		serviceApi.delete(serviceId);
	}
}
