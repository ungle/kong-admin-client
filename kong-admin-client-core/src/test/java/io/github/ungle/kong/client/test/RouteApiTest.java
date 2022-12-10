package io.github.ungle.kong.client.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.ungle.kong.client.api.RouteApi;
import io.github.ungle.kong.client.api.ServiceApi;
import io.github.ungle.kong.client.enums.HttpMethod;
import io.github.ungle.kong.client.feignclient.KongClientFactory;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.RouteRequest;
import io.github.ungle.kong.client.requests.ServiceRequest;
import io.github.ungle.kong.client.response.RouteResponse;
import io.github.ungle.kong.client.response.ServiceResponse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = OrderAnnotation.class)
public class RouteApiTest {

	ObjectMapper objectMapper;
	RouteApi routeApi;
	ServiceApi serviceApi;
	String name;
	String serviceName;
	String serviceId;

	@BeforeAll
	public void initTest() {
		objectMapper = new ObjectMapper();
		KongClientFactory kongClientFactory = KongClientFactory.builder()
				.targets(Arrays.asList("http://127.0.0.1:8001")).build();
		routeApi = kongClientFactory.getApiInstance(RouteApi.class);
		name = "routetest-20210301-" + UUID.randomUUID().toString();

		serviceName = "test-service";
		ServiceRequest serviceRequest = new ServiceRequest();
		serviceRequest.setName(serviceName);
		serviceRequest.setUrl("http://127.0.0.1:8801");
		serviceApi = kongClientFactory.getApiInstance(ServiceApi.class);
		ServiceResponse response = serviceApi.add(serviceRequest);
		serviceId = response.getId();

	}

	@Test
	@Order(1)
	public void addRouteTest() throws Exception {
		
		RouteRequest request = new RouteRequest();
		request.setName(name);
		List<String> paths = new ArrayList<>();
		paths.add("/routetest-20210301");
		request.setPaths(paths);
		Set<HttpMethod> methods = new HashSet<>();
		methods.add(HttpMethod.GET);
		methods.add(HttpMethod.DELETE);
		request.setMethods(methods);
		RouteResponse response = routeApi.addByService(serviceName, request);
		assertEquals(name, response.getName());
		ApiDataList<RouteResponse> response2 = routeApi.findByService(serviceId);
		assertEquals(1,response2.getData().size());
		
		methods.add(HttpMethod.COPY);
		response = routeApi.createOrUpdate(name, request);
		assertTrue(response.getMethods().contains(HttpMethod.COPY));
		

		response = routeApi.retrieve(name);
		System.out.println(objectMapper.writeValueAsString(response));

		paths.add("/routetest-2021030122");
		response = routeApi.update(name, request);
		assertTrue(response.getPaths().contains("/routetest-2021030122"));

		response = routeApi.retrieve(name);
		System.out.println(objectMapper.writeValueAsString(response));
		assertEquals(name, response.getName());

	}

	@Test
	@Order(2)
	public void findAllTest() throws Exception {
		ApiDataList<RouteResponse> response = routeApi.find();
		assertEquals(1,response.getData().size());
	}

	@Test
	@Order(3)
	public void deleteRoute() throws Exception {
		routeApi.delete(name);
		ApiDataList<RouteResponse> response = routeApi.find();
		assertEquals(0,response.getData().size());
	}
	
	@AfterAll
	public void deleteService() {
		serviceApi.delete(serviceName);
	}

}
