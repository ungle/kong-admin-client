package io.github.ungle.kong.client.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.github.ungle.kong.client.api.ConsumerApi;
import io.github.ungle.kong.client.feignclient.KongClientFactory;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.ConsumerRequest;
import io.github.ungle.kong.client.response.ConsumerResponse;
import io.github.ungle.kong.client.service.TagQueryBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = OrderAnnotation.class)
public class ConsumerApiTest {
    ConsumerApi consumerApi;
    String name;
    String customId;

    @BeforeAll
    public void initTest() {
        KongClientFactory kongClientFactory = KongClientFactory.builder()
                .targets(Arrays.asList("http://127.0.0.1:8001")).build();
        consumerApi = kongClientFactory.getApiInstance(ConsumerApi.class);
        name = "consumer-"+UUID.randomUUID().toString();
        customId = name+"-id";
    }
    
    @Test
    @Order(1)
    public void addConsumerTest() {
    	 ConsumerRequest request = new ConsumerRequest();
         request.setCustomId(customId);
         request.setUsername(name);
         Set<String> tags = new HashSet<>();
         tags.add("TEST-CONSUMER");
         request.setTags(tags);
         ConsumerResponse response = consumerApi.add(request);
         assertEquals(customId, response.getCustomId());
         request.getTags().add("consumer-update");
         response = consumerApi.update(name, request);
         assertTrue(response.getTags().contains("consumer-update"));
    }

    @Test
    @Order(2)
    public void findTest() throws Exception {
        ApiDataList<ConsumerResponse> response = consumerApi.findByTag(new TagQueryBuilder().addTag("TEST-CONSUMER"));
        assertEquals(1, response.getData().size());
    }

    @Test
    @Order(3)
    public void deleteTest() throws Exception {
        consumerApi.delete(name);
    }


}
