package io.github.ungle.kong.client.test.pluginmodel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.ungle.kong.client.api.PluginApi;
import io.github.ungle.kong.client.api.ServiceApi;
import io.github.ungle.kong.client.enums.InnerPluginName;
import io.github.ungle.kong.client.feignclient.KongClientFactory;
import io.github.ungle.kong.client.model.IdNameRelation;
import io.github.ungle.kong.client.model.plugins.transformation.ResponseTransformerConfig.BasicResponseOperation;
import io.github.ungle.kong.client.model.plugins.transformation.ResponseTransformerConfig.JsonResponseOperation;
import io.github.ungle.kong.client.model.plugins.transformation.ResponseTransformerConfig.JsonTypeResponseOperation;
import io.github.ungle.kong.client.model.plugins.transformation.ResponseTransformerConfig;
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
public class ResponseTransformerPluginTest {
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
		request.setName(InnerPluginName.RESPONSE_TRANSFORMER.getPluginName());
		request.setService(new IdNameRelation(serviceId));
		BasicResponseOperation basicResponseOperation = new BasicResponseOperation();
		basicResponseOperation.setHeaders(Arrays.asList("kk:zz"));
		JsonResponseOperation jsonResponseOperation = new JsonResponseOperation();
		jsonResponseOperation.setJson(Arrays.asList("p1"));
		JsonTypeResponseOperation jsonTypeResponseOperation = new JsonTypeResponseOperation();
		jsonTypeResponseOperation.setJsonTypes(Arrays.asList("string"));
		request.setConfig(ResponseTransformerConfig.builder().withRename(basicResponseOperation).withRemove(jsonResponseOperation).withAdd(jsonTypeResponseOperation).withAppend(jsonTypeResponseOperation).withReplace(jsonTypeResponseOperation).build());
		PluginResponse result = pluginApi.add(request);
		pluginId = result.getId();
		JsonNode tree = objectMapper.readTree(objectMapper.writeValueAsBytes(result.getConfig()));
		assertEquals(result.getName(), InnerPluginName.RESPONSE_TRANSFORMER.getPluginName());
		assertEquals("kk:zz",tree.get("rename").get("headers").get(0).asText());
		assertEquals("p1", tree.get("remove").get("json").get(0).asText());
		assertEquals("string", tree.get("replace").get("json_types").get(0).asText());
		assertEquals("string", tree.get("add").get("json_types").get(0).asText());
		assertEquals("string", tree.get("append").get("json_types").get(0).asText());
	}

	@AfterAll
	public void deleteService() {
		if (pluginId != null) {
			pluginApi.delete(pluginId);
		}
		serviceApi.delete(serviceId);
	}
}
